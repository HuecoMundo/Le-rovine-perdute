import java.util.*;
public class Rotta {
	private String nome=null;
	private int numeroCitta=0;
	private Map<Integer, LinkedList<Citta>> mappa;
	ArrayList<Citta> cittaLette=new ArrayList<Citta>();
	ArrayList<Double> distanze=new ArrayList<Double>();
	ArrayList<Citta> precedenti=new ArrayList<Citta>();
	ArrayList<Citta> percorsoMinimo=new ArrayList<Citta>();
	/**
	 * costruttore della classe rotta, riceve in ingresso il numero di citta e le citta lette
	 * dalla classe LeggiXML, che saranno passate nel main tramite i due metodi get della classe
	 * citata poco prima. 
	 * @param nome
	 * @param numeroCitta
	 * @param cittaLette
	 */
	public Rotta(String nome,int numeroCitta,ArrayList<Citta> cittaLette) {//arrivano dal main
		this.nome=nome;
		mappa=new HashMap<Integer,LinkedList<Citta>>();
		this.numeroCitta=numeroCitta;
		for(int i=0;i<numeroCitta;i++)
			mappa.put(i, new LinkedList<>());
		this.cittaLette=cittaLette;
	}
	/**
	 * questo metodo crea l'intera mappa delle città
	 * per farlo innanzitutto crea una LinkedList corrispondente alle città vicine all'i-esima
	 * successivamente ottengo la città di partenza
	 * di questa città di partenza mi interessano gli id delle sue vicine
	 * per ogni id aggiungo alla LinkedList una città presa da quelle
	 * lette dall'XML la cui posizione corrisponde all'id j-esimo
	 */
	public void creaMappaCompleta() {
		for(int i=0;i<mappa.size();i++) {
			LinkedList<Citta> vicine=mappa.get(i);
			Citta partenza=cittaLette.get(i);
			ArrayList<Integer> idVicine=partenza.getCittaVicine();
			for(int j=0;j<idVicine.size();j++) {
				int idCittaVicina=idVicine.get(j);
				vicine.add(cittaLette.get(idCittaVicina));
			}
		}
	}
	/**
	 * inizializza la lista di distanze a infinito e le città precedenti per ora sono null
	 * preparazione a Dijkstra
	 */
	public void inizializzaDistanzeEPrecedenti() {
		for(int i=0;i<numeroCitta;i++) {
			if(i==0)
				distanze.add(0.0);//distanza campoBase-campoBase=0
			else
				distanze.add(Double.POSITIVE_INFINITY);
			precedenti.add(null);
		}
	}
	
	public int cercaMinimo(ArrayList<Double> distanze) {
		double min=Double.POSITIVE_INFINITY;
		for(int i=0;i<distanze.size();i++) {
			if(distanze.get(i)<min)
				min=distanze.get(i);
		}
		return distanze.indexOf(min);
	}
	
	public void calcolaPercorsoMinimo(Rotta mappaDelTesoro, Veicolo macchina) {
		while(!cittaLette.isEmpty()) {
			inizializzaDistanzeEPrecedenti();//rendo tutte le distanze infinito e i prec. null
			int indirizzoMinimo=cercaMinimo(distanze);
			Citta partenza=cittaLette.get(indirizzoMinimo);//città con distanza minima, la T
			LinkedList<Citta> vicinePartenza=mappa.get(indirizzoMinimo);//prendo le vicine alla partenza
			for(int i=0;i<vicinePartenza.size();i++) {
				//la città è ancora da visitare?
				if(cittaLette.contains(vicinePartenza.get(i))) {
					Citta vicina=vicinePartenza.get(i);//N
					//calcola la distanza tra una città e l'altra e la somma a quella già percorsa
					double distanzaDaPercorrere=distanze.get(indirizzoMinimo)+
							macchina.calcolaDistanza(partenza, vicina);
					//guarda se la distanza appena calcolata è minore di quella memorizzata
					//nella lista di distanze alla posizione corrispondente all'id della
					//città vicina
					if(distanzaDaPercorrere<distanze.get(vicina.getId())) {
						distanze.set(vicina.getId(), distanzaDaPercorrere);//mette la distanza minima
						precedenti.set(vicina.getId(), partenza);//il precedente per ora è partenza
					}
				}
				else
					continue;
			}
			/*
			 * toglie la città appena letta, ha già calcolato la distanza minima
			 * toglie inoltre la distanza minima appena usata come riferimento per evitare che
			 * alla prossima iterazione ripeschi lo stesso indirizzo
			 */
			cittaLette.remove(indirizzoMinimo);
			distanze.remove(indirizzoMinimo);
		}
	}
	
	public void costruisciPercorsoMinimo() {
		
	}

}

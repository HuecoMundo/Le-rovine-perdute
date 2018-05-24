import java.util.*;
public class Rotta {
	private String nome=null;
	private int numeroCitta=0;
	private Map<Integer, LinkedList<Citta>> mappa;
	private ArrayList<Citta> cittaLette=new ArrayList<Citta>();
	private ArrayList<Double> distanze=new ArrayList<Double>();
	private ArrayList<Citta> precedenti=new ArrayList<Citta>();
	private ArrayList<Citta> percorsoMinimo=new ArrayList<Citta>();
	private ArrayList<Integer> minimiGiaLetti=new ArrayList<Integer>();
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
	private void inizializzaDistanzeEPrecedenti() {
		for(int i=0;i<numeroCitta;i++) {
			if(i==0)
				distanze.add(0.0);//distanza campoBase-campoBase=0
			else
				distanze.add(Double.POSITIVE_INFINITY);
			precedenti.add(null);
		}
	}
	/**
	 * cerca la distanza minimo evitando di leggere quella che aveva preso nell'iterazione
	 * precedente l'algoritmo di Dijkstra servendosi della lista minimiGiaLetti
	 * @param distanze
	 * @return posizione del minimo
	 */
	private int cercaMinimo(ArrayList<Double> distanze) {
		double min=Double.POSITIVE_INFINITY;
		int posizioneMinimo=0;
		for(int i=0;i<distanze.size();i++) {
			//la seconda condizione impedisce che una città isolata venga ignorata(città 151 nelle 200)
			if(distanze.get(i)<min || distanze.get(i)==min) {
				if(!minimiGiaLetti.contains(i)) {//ho già letto questo minimo?
					min=distanze.get(i);
					posizioneMinimo=i;
				}
			}
		}
		minimiGiaLetti.add(posizioneMinimo);//aggiungilo ai minimi già letti
		return posizioneMinimo;
	}
	/**
	 * cerca la città nella lista di quelle lette per evitare che prenda una città sbagliata
	 * cancellalo
	 * @param id
	 * @return indirizzo in cui trova la città
	 */
	private int cercaCittaPerId(int id) {
		for(int i=0;i<cittaLette.size();i++)
			if(cittaLette.get(i).getId()==id)
				return i;
		return -1;//non l'ho trovata
	}
	
	/**
	 * algoritmo di Dijkstra
	 * @param macchina
	 */
	public void calcolaPercorsoMinimo(Veicolo macchina) {
		inizializzaDistanzeEPrecedenti();
		while(!cittaLette.isEmpty()) {
			int posizioneMinimo=cercaMinimo(distanze);//cerca la posizione del nodo con distanza minima
			Citta partenza=cittaLette.get(cercaCittaPerId(posizioneMinimo));//parti da lì
			LinkedList<Citta> vicine=mappa.get(partenza.getId());//prendi le sue vicine
			for(int i=0;i<vicine.size();i++) {
				if(cittaLette.contains(vicine.get(i))) {//ho già visitato questa città?
					Citta vicina=vicine.get(i);
					double distanza=distanze.get(posizioneMinimo)+
							macchina.calcolaDistanza(partenza, vicina);//calcola alt
					//alt è minore della distanza già presente nella lista di distanze?
					if(distanza<distanze.get(vicina.getId())) {
						distanze.set(vicina.getId(), distanza);//metti la nuova distanza
						precedenti.set(vicina.getId(), partenza);//scrivi la nuova precedente
					}
				}
			}
			cittaLette.remove(partenza);//rimuovi la città visitata
		}
	}
	/**
	 * questo metodo costruisce il percorso minimo risalendo a ritroso l'ArrayList dei percorsi
	 * precedenti e memorizzando queste città in una nuova ArrayList di città che rappresenterà
	 * il percorso minimo percorribile
	 * @param quanteCitta
	 */
	public ArrayList<Citta> costruisciPercorsoMinimo(int quanteCitta) {
		int i=quanteCitta-1;
		percorsoMinimo.add(precedenti.get(i));
		while(true) {
			int idCittaPrecedente=precedenti.get(i).getId();
			if(idCittaPrecedente==0)//attenzione alla nullptr exception
				break;//se c'è interrompi la costruzione e restituisci l'array
			percorsoMinimo.add(precedenti.get(idCittaPrecedente));
			i=idCittaPrecedente;//reinizializza i
		}
		return percorsoMinimo;
	}

}

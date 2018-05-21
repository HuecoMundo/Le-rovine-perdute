import java.util.*;
public class Rotta {
	private String nome=null;
	private int numeroCitta=0;
	private Map<Integer, LinkedList<Citta>> mappa;
	ArrayList<Citta> cittaLette=new ArrayList<Citta>();
	ArrayList<Double> distanze=new ArrayList<Double>();
	ArrayList<Citta> precedenti=new ArrayList<Citta>();
	/**
	 * costruttore della classe rotta, riceve in ingresso il numero di citta e le citta lette
	 * dalla classe LeggiXML, che saranno passate nel main tramite i due metodi get della classe
	 * citata poco prima. 
	 * @param nome
	 * @param numeroCitta
	 * @param cittaLette
	 */
	public Rotta(String nome,int numeroCitta,ArrayList<Citta> cittaLette) {//arrivano dal main
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
	public void inizializzaDistanzeEPredenti() {
		for(int i=0;i<cittaLette.size();i++) {
			distanze.add(Double.POSITIVE_INFINITY);
			precedenti.add(null);
		}
	}

}

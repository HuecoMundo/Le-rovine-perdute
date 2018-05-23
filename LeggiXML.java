import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;


public class LeggiXML {
	private static ArrayList<Città> listaCitta = new ArrayList<Città>();
	private static int numeroCitta = 0;
	/**
	 * questo metodo legge gli attributi dei tag city e link e incrementa il numero di città
	 * ogni volta che legge il tag city. Successivamente memorizza nella posizione numeroCitta
	 * i vari attributi letti nei corrispondenti attributi della classe Citta scelti tramite 
	 * lo switch
	 * @param filename
	 */
	public void leggiAttributi(String filename) {
		try {
			XMLInputFactory xmlif=XMLInputFactory.newInstance();
	        XMLStreamReader xmlr = xmlif.createXMLStreamReader(filename,
	                                   new FileInputStream(filename));
	        while(xmlr.hasNext()) {
	            switch(xmlr.getEventType()) {
	            case XMLStreamConstants.START_ELEMENT:{
		            if(xmlr.getLocalName().equals("city")) {
		            	listaCitta.add(new Città()); //gli aggiungo una città vuota	
		            	for(int i=0;i<xmlr.getAttributeCount();i++) {
		            		String attributo=xmlr.getAttributeLocalName(i);
		            		switch(i) {
		            		case 0: listaCitta.get(numeroCitta).setId(Integer.parseInt(attributo)); break;
		            		case 1: listaCitta.get(numeroCitta).setNome(attributo); break;
		            		case 2: listaCitta.get(numeroCitta).setX(Integer.parseInt(attributo)); break;
		            		case 3: listaCitta.get(numeroCitta).setY(Integer.parseInt(attributo)); break;
		            		case 4: listaCitta.get(numeroCitta).setH(Integer.parseInt(attributo)); break;
		            		}
		            	}
		            	numeroCitta++;//incremento alla fine così non salto la posizione 0
	            	}
		            else if(xmlr.getLocalName().equals("link")) {
		            	String attributo=xmlr.getAttributeLocalName(0);
		            	listaCitta.get(numeroCitta).getCittaVicine().add(Integer.parseInt(attributo));
		            }
	            	break;
	            }
	            default:
	            	break;
	            }
	            xmlr.next();
	        }
		}catch(Exception e) {
			System.out.println("Ho trovato un errore nella lettura del file");
		}
	}
	//quante città hai letto?
	public static int getNumeroCitta() {
		return listaCitta.size();
	}
	//quali città hai letto?
	public ArrayList<Città> getListaCitta(){
		return listaCitta;
	}
	
	public static Città getCittaFromId (int id) {
		
		return listaCitta.get(id);
	}
	
	
}
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
public class LeggiXML {
	private ArrayList<Citta> listaCitta=new ArrayList<Citta>();
	private int numeroCitta=0;
	
	public void leggiAttributi(String filename) {
		try {
			XMLInputFactory xmlif=XMLInputFactory.newInstance();
	        XMLStreamReader xmlr = xmlif.createXMLStreamReader(filename,
	                                   new FileInputStream(filename));
	        while(xmlr.hasNext()) {
	            switch(xmlr.getEventType()) {
	            case XMLStreamConstants.START_ELEMENT:{
		            if(xmlr.getLocalName().equals("city")) {
		            	numeroCitta++;	
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

}

import java.io.FileWriter;
import java.util.*;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
public class ScriviXML {
	/**
	 * questo metodo scrive il file XML con il percorso minimo che deve fare il veicolo
	 * per raggiungere le Rovine Perdute.
	 * Scorre le città realizzando un tag city per ognuna
	 * Per ogni città fa scorrere anche gli id dei suoi vicini realizzando i tag link
	 * @param percorsoMinimo
	 * @param filename
	 * @return
	 */
	public boolean write(ArrayList<Citta> percorsoMinimo, String filename) {
		System.out.println("Scrittura su file");
		XMLOutputFactory output = XMLOutputFactory.newInstance();
		XMLStreamWriter writer;
		try {
			writer = output.createXMLStreamWriter(new FileWriter(filename));

			writer.writeComment("data saved");
			writer.writeStartElement("mappa");
			writer.writeAttribute("nome", "mappaCittà");
			for(Citta c: percorsoMinimo) {
				writer.writeStartElement("city");
				writer.writeAttribute("id", ""+c.getId());
				writer.writeAttribute("nome", c.getNome());
				writer.writeAttribute("x", ""+c.getX());
				writer.writeAttribute("y", ""+c.getY());
				writer.writeAttribute("h", ""+c.getH());
				writer.writeEndElement();
			}
			writer.writeEndDocument();
			writer.flush();
			writer.close();
			System.out.println("End!");
		}catch(Exception e) {
			System.out.println("Ho avuto un problema a scrivere il tuo file");
			e.printStackTrace();
			return false;
		}
		return true;
	}

}

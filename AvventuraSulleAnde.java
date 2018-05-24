import java.util.*;

import it.unibs.fp.mylib.InputDati;
public class AvventuraSulleAnde {
	public static void main(String[] args) {
		String[] veicoli= {"Tonatiuh", "Metztli"};
		int i=0;
		while(i<veicoli.length) {
			System.out.println("Veicolo "+veicoli[i]+" scrivo il tuo percorso");
			int numeroCitta=InputDati.leggiIntero("Quante città avete nella mappa? ");
			if(numeroCitta==5 || numeroCitta==12 || numeroCitta==50 || numeroCitta==200 ||
					numeroCitta==2000 || numeroCitta==10000) {
			LeggiXML stream=new LeggiXML();
			ScriviXML write=new ScriviXML();
			switch(numeroCitta) {
			case 5: stream.leggiAttributi("./src/PgAr_Map_5.xml"); break;
			case 12: stream.leggiAttributi("./src/PgAr_Map_12.xml"); break;
			case 50: stream.leggiAttributi("./src/PgAr_Map_5.xml"); break;
			case 200: stream.leggiAttributi("./src/PgAr_Map_200.xml"); break;
			case 2000: stream.leggiAttributi("./src/PgAr_Map_2000.xml"); break;
			case 10000: stream.leggiAttributi("./src/PgAr_Map_10000.xml"); break;
			}
			ArrayList<Citta> cittaLette=stream.getListaCitta();
			int quanteCitta=stream.getNumeroCitta();
			Rotta rotta=new Rotta("One Piece",quanteCitta,cittaLette);
			rotta.creaMappaCompleta();
			switch(veicoli[i]) {
			case "Tonatiuh":{ 
				rotta.calcolaPercorsoMinimo(new Tonatiuh());
				ArrayList<Citta> mappaDelTesoro=rotta.costruisciPercorsoMinimo(quanteCitta);
				write.write(mappaDelTesoro, "PercorsoMinimoTonatiuh");
				break;
				}
			case "Metztli":{ 
				rotta.calcolaPercorsoMinimo(new Metztli()); 
				ArrayList<Citta> mappaDelTesoro=rotta.costruisciPercorsoMinimo(quanteCitta);
				write.write(mappaDelTesoro, "PercorsoMinimoMetztli");
				break;
				}
			}
			}
			i++;
		}
		System.out.println("Ho finito di scrivere le mappe, buon viaggio!");
		
	}

}

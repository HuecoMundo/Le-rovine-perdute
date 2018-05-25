import it.unibs.fp.mylib.MyMenu;
public class RovinePerduteMatriciMain {
	
	private static final String MENU="Scegli la mappa";
	private static final String BENVENUTO="Benvenuto nel programma delle Rovine Perdute. Preparati a iniziare una nuova avventura";
	private static final String[] FILE= {"PgAr_Map_5.xml", "PgAr_Map_12.xml", "PgAr_Map_50.xml", "PgAr_Map_200.xml", "PgAr_Map_2000.xml", "PgAr_Map_10000.xml"};
	
	public static void main (String[] args) {
		int scelta;
		
		System.out.println(BENVENUTO);
		LeggiXMLMatrici filename= new LeggiXMLMatrici();
		MyMenu menuInizio = new MyMenu(MENU, FILE);
		
		do {
			scelta=menuInizio.scegli();
			switch(scelta) {
				case 1: 
					filename.leggiAttributi("PgAr_Map_5.xml");
					break;
				
				case 2: 
					filename.leggiAttributi("PgAr_Map_12.xml");
					break;
				
				case 3: 
					filename.leggiAttributi("PgAr_Map_50.xml");
					break;
				case 4: 
					filename.leggiAttributi("PgAr_Map_200.xml");
					break;
				case 5: 
					filename.leggiAttributi("PgAr_Map_2000.xml");
					break;
				case 6: 
					filename.leggiAttributi("PgAr_Map_10000.xml");
					break;
			}
		
		}while(scelta!=0);
		
		
	}
}

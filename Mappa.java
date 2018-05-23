import java.util.*;
public class Mappa {

	
	ArrayList <String> listaNomi = new ArrayList <String>();
	ArrayList <Integer> listaId = new ArrayList <Integer>();
	int [][] distanze_team_Tonatiuh;
	int [][] distanze_team_Metzli;
	
	
	//Costruisco un oggetto di tipo Mappa inizializzando la dimensione delle matrici e allocando in tutte le caselle il valore infinity 
	public Mappa (int nCitta){
		
		distanze_team_Tonatiuh = new int [LeggiXML.getNumeroCitta()][LeggiXML.getNumeroCitta()];
		distanze_team_Metzli   = new int [LeggiXML.getNumeroCitta()][LeggiXML.getNumeroCitta()];
		
		int i = 0, j = 0;
				
		for(i = 0; i < LeggiXML.getNumeroCitta(); i++) {
			
			for(j = 0; j < LeggiXML.getNumeroCitta(); j++) {
				
				
			}
			
		}
	}
	
	
	//Integrare riempimento automatico da xml
	public void aggiungiNome(String nome){
		
		listaNomi.add(nome);
	}
	
	//Integrare riempimento automatico da xml
	public void aggiungiId(int id) {
		
		listaId.add(id);
	}
	
	//metodo che aggiunge tutte le distanze calcolate per il team Tonatiuh in una matrice denominata "distanze_team_Tonatiuh"
	public void aggiungiDistanzeTonatiuh() {		
		int i = 0;
		int j= 0;
		
		//ciclo per scorrere le righe, ovvero le città "da esaminare" con il controllo incrociato
		for (i = 0; i < LeggiXML.getNumeroCitta(); i++) {
			
			//ciclo per scorrere le colonne, ovvero tutte le possibili città vicine
			for (j = 0; j < LeggiXML.getCittaFromId(i).getNumeroVicini(); j++) {
				
				//Se la posizione nella matrice non è sulla diagonale...do something
				if (i != j) {
					
					/*	metodo che inserisce nella posizione corrispondente alla riga della città esaminata
					 *	e nella colonna corrispondente all'id del vicino (che corrisponde all'indice dell'ArrayList 
					 *	di città grazie al fatto che gli id siano in ordine crescente nell'xml) il peso per il veicolo del team Tonatiuh 
					*/
					distanze_team_Tonatiuh[i][LeggiXML.getCittaFromId(i).getIdVicino(j)] = 
							
							
							Funzioni.calculateTeamTonatiuh( LeggiXML.getCittaFromId(i).getX(),
							LeggiXML.getCittaFromId(i).getY(),
							LeggiXML.getCittaFromId(LeggiXML.getCittaFromId(i).getIdVicino(j)).getX(),
							LeggiXML.getCittaFromId(LeggiXML.getCittaFromId(i).getIdVicino(j)).getY());
					
				}
				
				else
					//Se la posizione nella matrice è sulla diagonale inizializza il peso a 0 
					if (i == j)
						distanze_team_Tonatiuh [i][j] = 0;
							
			}
		
		}
	
	}
	
	public void aggiungiDistanzeMetzli() {
		
		int i = 0, j = 0;
		
		//ciclo per scorrere le righe, ovvero le città "da esaminare" con il controllo incrociato
		for (i = 0; i < LeggiXML.getNumeroCitta(); i++) {
			
			//ciclo per scorrere le colonne, ovvero tutte le possibili città vicine
			for (j = 0; j < LeggiXML.getCittaFromId(i).getNumeroVicini(); j++) {
			
				//Se la posizione nella matrice non è sulla diagonale...do something
				if (i != j) {
					

					/*	metodo che inserisce nella posizione corrispondente alla riga della città esaminata
					 *	e nella colonna corrispondente all'id del vicino (che corrisponde all'indice dell'ArrayList 
					 *	di città grazie al fatto che gli id siano in ordine crescente nell'xml) il peso per il veicolo del team Tonatiuh 
					*/
					
					distanze_team_Metzli[i][LeggiXML.getCittaFromId(i).getIdVicino(j)] = 
							
							
							Funzioni.calculateTeamMetzli(LeggiXML.getCittaFromId(i).getH(),
														 LeggiXML.getCittaFromId(LeggiXML.getCittaFromId(i).getIdVicino(j)).getH());
							
							
					
				}
				
				else 
					//Se la posizione nella matrice è sulla diagonale inizializza il peso a 0 
					if (i == j)
						
						distanze_team_Metzli [i][j] = 0;
			}
		}
		
		
	}

	
}
	
	
	
	
	

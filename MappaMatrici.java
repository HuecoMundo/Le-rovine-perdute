import java.util.*;
public class MappaMatrici{

	
	ArrayList <String> listaNomi = new ArrayList <String>();
	ArrayList <Integer> listaId = new ArrayList <Integer>();
	static double[][] distanze_team_Tonatiuh=null;
	static double[][] distanze_team_Metztli=null;
	
	
	public static double[][] getDistanze_team_Tonatiuh() {
		return distanze_team_Tonatiuh;
	}


	public void setDistanze_team_Tonatiuh(double[][] distanze_team_Tonatiuh) {
		this.distanze_team_Tonatiuh = distanze_team_Tonatiuh;
	}


	public static double[][] getDistanze_team_Metztli() {
		return distanze_team_Metztli;
	}


	public void setDistanze_team_Metztli(double[][] distanze_team_Metztli) {
		this.distanze_team_Metztli = distanze_team_Metztli;
	}


	//Costruisco un oggetto di tipo Mappa inizializzando la dimensione delle matrici e allocando in tutte le caselle il valore infinity 
	public MappaMatrici (int nCitta){
		
		distanze_team_Tonatiuh = new double [LeggiXMLMatrici.getNumeroCitta()][LeggiXMLMatrici.getNumeroCitta()];
		distanze_team_Metztli   = new double [LeggiXMLMatrici.getNumeroCitta()][LeggiXMLMatrici.getNumeroCitta()];
		
		int i = 0, j = 0;
		
		for(i = 0; i < LeggiXMLMatrici.getNumeroCitta(); i++) {
			
			for(j = 0; j < LeggiXMLMatrici.getNumeroCitta(); j++) {
				
				if(i!=j) {
					distanze_team_Tonatiuh[i][j]=Double.POSITIVE_INFINITY;
					distanze_team_Metztli[i][j]=Double.POSITIVE_INFINITY;
				}
				
				else {
					distanze_team_Tonatiuh[i][j]=0;
					distanze_team_Metztli[i][j]=0;
				}
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
	
	//metodo che aggiunge tutte le distanze calcolate per il team TonatiuhMatrici in una matrice denominata "distanze_team_Tonatiuh"
	public void aggiungiDistanzeTonatiuh(VeicoloMatrici veicolo) {		
		int i = 0;
		int j= 0;
		
		//ciclo per scorrere le righe, ovvero le città "da esaminare" con il controllo incrociato
		for (i = 0; i < LeggiXMLMatrici.getNumeroCitta(); i++) {
			
			//ciclo per scorrere le colonne, ovvero tutte le possibili città vicine
			for (j = 0; j < LeggiXMLMatrici.getNumeroCitta(); j++) {
				
				//Se la posizione nella matrice non è sulla diagonale...do something
				if ((i != j) && LeggiXMLMatrici.getCittaFromId(i).getCittaVicine().contains(j)) {
					distanze_team_Tonatiuh[i][j]=TonatiuhMatrici.calcolaDistanza(LeggiXMLMatrici.getCittaFromId(i), LeggiXMLMatrici.getCittaFromId(j));	
				}
				
				//else distanze_team_Tonatiuh [i][j] = (Double) null;
							
			}
		
		}
	
	}
	
	public void aggiungiDistanzeMetzli() {
		
		int i = 0, j = 0;
		
		//ciclo per scorrere le righe, ovvero le città "da esaminare" con il controllo incrociato
		for (i = 0; i < LeggiXMLMatrici.getNumeroCitta(); i++) {
			
			//ciclo per scorrere le colonne, ovvero tutte le possibili città vicine
			for (j = 0; j < LeggiXMLMatrici.getCittaFromId(i).getNumeroVicini(); j++) {
			
				//Se la posizione nella matrice non è sulla diagonale...do something
				if (i != j) {
					

					distanze_team_Metztli[i][j]=MetztliMatrici.calcolaDistanza(LeggiXMLMatrici.getCittaFromId(i), LeggiXMLMatrici.getCittaFromId(j));												
					
				}
				
				else 
					//Se la posizione nella matrice è sulla diagonale inizializza il peso a 0 
					if (i == j)
						
						distanze_team_Metztli [i][j] = 0;
			}
		}
		
		
	}

	
}
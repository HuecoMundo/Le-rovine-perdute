import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class RottaMatrici {
	
	private ArrayList<CittaMatrici> rotta= new ArrayList<CittaMatrici>(null);
	private Deque<CittaMatrici> queue= new ArrayDeque<>(null);
	
	public void dijkstra(double distanze_team_Tonatiuh[][]) {
		for(int i=0;i<LeggiXMLMatrici.getNumeroCitta();i++) {
			double distanza=Double.POSITIVE_INFINITY;
			CittaMatrici prev=null;
			queue.add(LeggiXMLMatrici.getCittaFromId(i));
		}
		
		while(!(queue.isEmpty())){
			double[][] max=MappaMatrici.getDistanze_team_Metztli();
			double temp=0;
			int j=0;
			for(int i=0;i<LeggiXMLMatrici.getNumeroCitta();i++) {
				if((max[j][i])>temp) temp=max[j][i];	
			}
			queue.remove();
			for(int i=0;i<CittaMatrici.getNumeroVicini();i++) {
				if((CittaMatrici.getIdVicino())!(queue.contains(LeggiXMLMatrici.getCittaFromId(i)))
			}
			
		}
	}
}


public class Metztli extends Veicolo {
	
	public Metztli() {
		super("Metztli");
	}
	
	public double calcolaDistanza(Citta partenza, Citta arrivo) {
		double altezza=arrivo.getH()-partenza.getH();
		return Math.abs(altezza);
	}

}

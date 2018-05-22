
public class Tonatiuh extends Veicolo {
	
	public Tonatiuh() {
		super("Tonatiuh");
	}
	
	public double calcolaDistanza(Citta partenza, Citta arrivo) {
		double quadratoX=Math.pow(arrivo.getX()-partenza.getX(), 2);
		double quadratoY=Math.pow(arrivo.getY()-partenza.getY(), 2);
		return Math.sqrt(quadratoX+quadratoY);
	}

}

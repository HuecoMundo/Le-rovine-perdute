
public class Tonatiuh extends Veicolo {
	
	public Tonatiuh() {
		super("Tonatiuh");
	}
	/**
	 * calcola la distanza secondo il veicolo Tonatiuh
	 * @param partenza arrivo
	 * @return distanza euclidea tra due città
	 */
	@Override
	public double calcolaDistanza(Citta partenza, Citta arrivo) {
		double quadratoX=Math.pow(arrivo.getX()-partenza.getX(), 2);
		double quadratoY=Math.pow(arrivo.getY()-partenza.getY(), 2);
		return Math.sqrt(quadratoX+quadratoY);
	}

}

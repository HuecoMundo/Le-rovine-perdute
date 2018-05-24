
public class Metztli extends Veicolo {//eredita da veicolo che è una classe astratta
	
	public Metztli() {
		super("Metztli");
	}
	/**
	 * distanza calcolata secondo Metztli
	 * @param partenza arrivo
	 * @return la differenza di altezze tra due città
	 */
	@Override
	public double calcolaDistanza(Citta partenza, Citta arrivo) {
		double altezza=arrivo.getH()-partenza.getH();
		return Math.abs(altezza);
	}

}

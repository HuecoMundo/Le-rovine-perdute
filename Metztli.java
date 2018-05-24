
public class Metztli extends Veicolo {//eredita da veicolo che � una classe astratta
	
	public Metztli() {
		super("Metztli");
	}
	/**
	 * distanza calcolata secondo Metztli
	 * @param partenza arrivo
	 * @return la differenza di altezze tra due citt�
	 */
	@Override
	public double calcolaDistanza(Citta partenza, Citta arrivo) {
		double altezza=arrivo.getH()-partenza.getH();
		return Math.abs(altezza);
	}

}

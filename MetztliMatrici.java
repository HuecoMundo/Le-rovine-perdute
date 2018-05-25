public class MetztliMatrici{
	
	TipoVeicoloMatrici nome;

	public TipoVeicoloMatrici getNome() {
		return nome;
	}

	public void setNome(TipoVeicoloMatrici nome) {
		this.nome = nome;
	}

	public static double calcolaDistanza(CittaMatrici partenza, CittaMatrici arrivo) {
		double altezza=arrivo.getH()-partenza.getH();
		return Math.abs(altezza);
	}

}
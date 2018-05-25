public class TonatiuhMatrici{
	
	TipoVeicoloMatrici nome;

	public static double calcolaDistanza(CittaMatrici partenza, CittaMatrici arrivo) {
		double quadratoX=Math.pow(arrivo.getX()-partenza.getX(), 2);
		double quadratoY=Math.pow(arrivo.getY()-partenza.getY(), 2);
		return Math.sqrt(quadratoX+quadratoY);
	}
	
	public TipoVeicoloMatrici getNome() {
		return nome;
	}


	public void setNome(TipoVeicoloMatrici nome) {
		this.nome = nome;
	}

}
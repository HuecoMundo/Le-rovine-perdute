public abstract class VeicoloMatrici {
	private String nome=null;
	
	
	public VeicoloMatrici(String nome) {
		this.nome=nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public abstract double calcolaDistanza(CittaMatrici partenza, CittaMatrici arrivo);
	
	public abstract TipoVeicoloMatrici setTipoVeicoloMatrici();

}

public abstract class Veicolo {
	private String nome=null;
	
	public Veicolo(String nome) {
		this.nome=nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * definito nelle classi figlie
	 * @param partenza
	 * @param arrivo
	 * @return
	 */
	public abstract double calcolaDistanza(Citta partenza, Citta arrivo);

}

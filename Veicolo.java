
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

	public abstract double calcolaDistanza(Citta partenza, Citta arrivo);

}

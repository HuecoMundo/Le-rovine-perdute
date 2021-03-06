import java.util.ArrayList;

public class Citta {
	private int id = 0;
	private String nome = null;
	private double x = 0;
	private double y = 0;
	private double h = 0;
	//ha gli id delle citta vicine
	private ArrayList<Integer> cittaVicine=new ArrayList<Integer>();
	
	
	public Citta (int x, int y, int h, String nome, int id){ //costruttore
		
		this.x = x;
		this.y = y;
		this.h = h;
		this.nome = nome;
		this.id = id;
		
	}
	
	public Citta (){ //costruttore vuoto
		
		x = 0;
		y = 0;
		h = 0;
		nome = null;
		id = 0;
		
	}
	//getters e setters con controlli nei setters
	public double getX() {
		return x;
	}

	public void setX(int x) {
		if(x>=0)
			this.x = x;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(controllaNome(nome)) //vedi sotto
			this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id>=0)
			this.id = id;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		if(y>=0)
			this.y = y;
	}

	public double getH() {
		return h;
	}

	public void setH(int h) {
		if(h>=0)
			this.h = h;
	}
	public ArrayList<Integer> getCittaVicine(){
		return cittaVicine;
	}
	//controlla che il nome sia composto da lettere maiuscole in questo caso in quanto convertito
	public boolean controllaNome(String nomeCitta) {
		String maiuscolo=nomeCitta.toUpperCase();
		for(int i=0;i<maiuscolo.length();i++)
			if(maiuscolo.charAt(i)<'A' || maiuscolo.charAt(i)>'Z')
				return false;//se trovi un carattere che non � una lettera non va bene
		return true;
	}

}

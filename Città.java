
public class Città {
	
	private int x = 0;
	private int y = 0;
	private int h = 0;
	public String nome = null;
	public int id = 0;
	
	
	Città (int x, int y, int h, String nome, int id){ //costruttore
		
		this.x = x;
		this.y = y;
		this.h = h;
		this.nome = nome;
		this.id = id;
		
	}
	
	Città (){ //costruttore vuoto
		
		x = 0;
		y = 0;
		h = 0;
		nome = null;
		id = 0;
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}
	

	
	public String controllaPosizione(int pos) {
		
		if (pos < 0)
			return "Parametro inserito non valido, l'oggetto non verrà creato";
					
		else
			return "Parametro valido";
			
	}
	
	/*public String controllaNome(String nome) {
		
		try {
			
			nome
		}*/
}


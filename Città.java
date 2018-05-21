import java.util.*;


public class Città {
	
	static Scanner scrivi = new Scanner(System.in);
	
	private int x = 0;
	private int y = 0;
	private int h = 0;
	public  String nome = null;
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
	
	public static String controllaNome() {
	
		boolean correct = true;
		String nome = null;
		
		do {
		
			
			correct = true;
			int i = 0;
		
		
			try {
			
				System.out.println("Inserire il nome della città:\n");
				nome = scrivi.next();
				
			}
		
			catch (NoSuchElementException e) {
				
				System.out.println("Inserisci qualcosa!");
				correct = false;
			}
		
			catch(IllegalStateException v) {
				
				System.out.println("La tastiera non riesce a comunicare col pc!");
				correct = false;
			}
						
			
			for (i = 0; i < nome.length() && correct == true; i++) { //controlla che la parola contenga solo lettere alfabetiche 
				
				char split = nome.charAt(i);
				
					if (!Character.isAlphabetic(split))
						correct = false;
					}
			
		} while (correct == false);
			
		
		return nome.toUpperCase().charAt(0) + nome.substring(1);
		
		
	}
	
}


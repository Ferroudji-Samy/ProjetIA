
public class Piece {
	
	private String Joueur;
	private int x,y;
	private int AR;
	private int deplacement;
	
	public Piece(String nomJoueur,int posX, int posY,int deplacement) {
		Joueur=nomJoueur;
		x=posX;
		y=posY;
		AR=1; //1 aller -1 retour
		this.deplacement=deplacement;
	}
	
	public int getDeplacement() {
		return this.deplacement;
	}
	
	public int getX() {
		return this.x;
		
	}
	
	public int getY() {
		return this.y;
		
	}
	
	public String getNomJoueur() {
		return this.Joueur;
		
	}
	
	public int getAR() {
		return this.AR;
		
	}
	
	public void changeDir() {
		this.AR = -this.AR;
	}
}

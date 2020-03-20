
public class Piece {
	
	private String Joueur;
	private int x,y;
	private String AR;
	private int deplacement;
	
	public Piece(String nomJoueur,int posX, int posY,int deplacement) {
		Joueur=nomJoueur;
		x=posX;
		y=posY;
		AR="aller";
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
	
	public String getAR() {
		return this.AR;
		
	}
	
}

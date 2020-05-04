package iia.games.base;

public class Piece {
	
	private char representation;
	private int x,y;
	private int AR;
	private int deplacement;
	private boolean inGame;
	
	public Piece(char rep,int posX, int posY,int deplacement) {
		representation=rep; //representation de la piece sur le plateau 
		x=posX;
		y=posY;
		AR=1; //1 aller -1 retour
		this.deplacement=deplacement;
		inGame=true;
	}
	
	public Piece copyPiece() {
		char R=this.representation;
		int X=this.x;
		int Y=this.y;
		int Ar=this.AR;
		int D=this.deplacement;
		Piece p= new Piece(R, X, Y, D);
		p.inGame=this.inGame;
		p.setAR(Ar);
		return p;
		
	}
	
	
	public void setAR(int AR) {
		this.AR=AR;
	}
	public int getAR() {
		return this.AR;
		
	}
	
	public int getDeplacement() {
		return this.deplacement;
	}
	
	public int getX() {
		return x;
		
	}	
	public int getY() {
		return y;
		
	}
	
	public void setX(int i) {
		this.x=i;	
	}


	public void setY(int i) {
		this.y=i;	
	}
	
	public char getRepresentation() {
		return representation;	
	}
	
	public void setRepresentation(char r) {
		this.representation=r;
	}
	
	/**
	 * inverse le deplacement d une piece
	 */
	public void inverseDeplacement() {
		if(this.AR==-1) {
			this.deplacement=0;
			this.inGame=false;
		}
		else {
			this.deplacement=4-this.deplacement;
			this.AR=-1;
			inverseRepresentation();
		}
		
	}

	/**
	 * inverse la representation d'une piece
	 */
	private void inverseRepresentation() {
		if(representation=='^')this.representation='v';
		else this.representation='<';
		
	}

	/**
	 * @return True si la piece est en jeu False sinon
	 */
	public boolean isInGame() {
		return inGame;
	}

	/**
	 * Ajoute ou retire une piece du jeu, True pour ajouter False pour retirer
	 * @param inGame
	 */
	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}

	/**
	 * Remet une piece sur ca case de Retour
	 * @param joueur True ou False
	 * @return L'entier sur lequel la piece a ete mise
	 */
	public int retour(boolean joueur) {
		if(joueur) {
			if(getAR()==1) {
				setY(6);
				return 6;
			}
			else {
				setY(0);
				return 0;
			}
		}
		else {
			if(getAR()==1) {
				setX(0);
				return 0;
			}
			else {
				setX(6);
				return 6;
			}
		}
		
	}
}

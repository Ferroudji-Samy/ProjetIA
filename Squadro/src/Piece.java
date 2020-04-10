
public class Piece {
	
	private char representation;
	private int x,y;
	private int AR;
	private int deplacement;
	private boolean inGame;
	
	public Piece(char rep,int posX, int posY,int deplacement) {
		representation=rep;
		x=posX;
		y=posY;
		AR=1; //1 aller -1 retour
		this.deplacement=deplacement;
		inGame=true;
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


	private void inverseRepresentation() {
		if(representation=='^')this.representation='v';
		else this.representation='<';
		
	}


	public boolean isInGame() {
		return inGame;
	}


	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}


	public int retour(boolean joueur) {
		// TODO Auto-generated method stub
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

import java.util.Random;

public class Jeu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Joueur horizontal = new Joueur();
		Joueur vertical = new Joueur();
		SquadroBoard plateau=new SquadroBoard(null, null, null);
		Random entier = null;
		@SuppressWarnings("null")
		int joueur=entier.nextInt(2);
		
		
		while (plateau.gameOver()) {
			if ( joueur==0) {
				horizontal.nextmove();
				joueur=1;
			}
			else {
				vertical.nextmove();
				joueur=0;
			}
			plateau.saveToFile("test.txt");
		}
		
	}

}

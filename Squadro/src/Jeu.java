import java.nio.file.Paths;
import java.util.Random;

public class Jeu {
	
	public static SquadroBoard initialisation() {
		
		String filename="save.txt";
		
		char [][]init=new char[7][7];

		
		Piece un = new Piece("horizontal",0,1,1);
		Piece deux = new Piece("horizontal",0,2,2);
		Piece trois = new Piece("horizontal",0,3,3);
		Piece quatre= new Piece("horizontal",0,4,2);
		Piece cinq = new Piece("horizontal",0, 5,1);
		
		Piece []horizontal= {un,deux,trois,quatre,cinq};
		
		un = new Piece("vertical",1,6,1);
		deux = new Piece("vertical",2,6,2);
		trois = new Piece("vertical",3,6,3);
		quatre= new Piece("vertical",4,6,2);
		cinq = new Piece("vertical",5, 6,1);
		
		Piece []vertical={un,deux,trois,quatre,cinq};
		
		SquadroBoard plateau= new SquadroBoard(init,vertical, horizontal);
		plateau.setFromFile(filename);
		
		
		
		
		return plateau;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long debut = System.currentTimeMillis();
		int somme=0;
		
		for(int nbPartie=0 ;nbPartie<10000;nbPartie++) {
		
			String filename="save.txt";

			
			SquadroBoard plateau= initialisation();
			plateau.setLastPlayer("vertical");
			String[] cp;
			
			int rand ;
			
			
		while(!plateau.gameOver()) {
			if(plateau.getLastPlayer().equals("vertical")) {
				
				cp=plateau.possibleMoves("horizontal");
				rand = (int)(Math.random() * cp.length) + 0;
				plateau.play(cp[rand],"horizontal");
				plateau.saveToFile("test.txt");
			}
			else {
				cp=plateau.possibleMoves("vertical");
				rand = (int)(Math.random() * cp.length) + 0;
				plateau.play(cp[rand],"vertical");
				plateau.saveToFile("test.txt");
			}
		}
		
		somme+=System.currentTimeMillis()-debut;
		
	}		
		System.out.print("fin test\n");
		System.out.println("temps moyen d'une partie "+somme/100000+" ms");
		//Affiche la dur�e d'ex�cution en millisecondes
		
		}
}

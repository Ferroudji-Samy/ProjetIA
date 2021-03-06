package iia.games.base;

import iia.games.base.MyChallenger;

public class Jeu {
	
	
	//on initilise le plateau et on assigne j2 aux deplacements horizontaux et j1 aux deplacements verticaux
	/**
	 * initialise le plateau a partir du fichier save.txt
	 * @return un plateau de jeu
	 */
	public static SquadroBoard initialisation() {
		
		String filename="save.txt";
		
		int [][]init=new int[7][7];

		
		Piece un = new Piece('>',0,1,1); //x y deplacement
		Piece deux = new Piece('>',0,2,3);
		Piece trois = new Piece('>',0,3,2);
		Piece quatre= new Piece('>',0,4,3);
		Piece cinq = new Piece('>',0, 5,1);
		
		Piece []horizontal= {un,deux,trois,quatre,cinq};
		
		un = new Piece('^',1,6,3);
		deux = new Piece('^',2,6,1);
		trois = new Piece('^',3,6,2);
		quatre= new Piece('^',4,6,1);
		cinq = new Piece('^',5, 6,3);
		
		Piece []vertical={un,deux,trois,quatre,cinq};
		
		SquadroBoard plateau= new SquadroBoard(init,vertical, horizontal);
		plateau.setFromFile(filename);
		plateau.setLastPlayerInterne(false);
		
		
		return plateau;
	}
	
	public static void main(String[] args) {

			MyChallenger vert=new MyChallenger();
			MyChallenger hori=new MyChallenger();
			vert.setRole("vertical");
			hori.setRole("horizontal");
			hori.getPlateau().setLastPlayer("horizontal");
		
			String res="vertical";
			//on test le code avec des parties jouees par des joueurs aleatoires	
			while(!hori.getPlateau().gameOver() ||!vert.getPlateau().gameOver()) {
			if(res.equals("horizontal")) {
				String move=hori.bestMove();
				hori.iPlay(move);
				vert.otherPlay(move);
				hori.getPlateau().saveToFile("test.txt");
				res="vertical";
			}
			else {
				String[] m=vert.getPlateau().possibleMoves("Vertical");
				String move=m[(int)(Math.random() * m.length) + 0];
				vert.iPlay(move);
				hori.otherPlay(move);
				vert.getPlateau().saveToFile("test.txt");
				res="horizontal";
			}
		}
			System.out.println("le gagnant est:"+res );
	
/**
			
		//on test la representation interne
			while(!plateau.gameOver()) {
				if(plateau.getLastPlayerInterne()) {
					
					cpi=plateau.possibleMovesInterne(false);
					cp=plateau.possibleMoves("horizontal");
					rand = (int)(Math.random() * cpi.length) + 0;
					plateau.playInterne(cpi[rand],false);
					plateau.saveToFile("test.txt");
				}
				else {
					cpi=plateau.possibleMovesInterne(true);
					cp=plateau.possibleMoves("vertical");
					rand = (int)(Math.random() * cpi.length) + 0;
					plateau.playInterne(cpi[rand],true);
					plateau.saveToFile("test.txt");
				}
			}
	
		System.out.print("fin test , gagnant: "+ plateau.getLastPlayer() +"\n");
		
		//dans le fichier de sauvegarde il est normal d'avoir toujour le meme joueurcar on ne le change pas
		
		
	}
	*/
	}
}

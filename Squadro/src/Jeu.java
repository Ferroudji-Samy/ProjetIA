
public class Jeu {
	
	
	//on initilise le plateau et on assigne j2 aux deplacements horizontaux et j1 aux deplacements verticaux
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
			
			SquadroBoard plateau= initialisation();
			plateau.setLastPlayer("vertical");
			String[] cp;
			int rand ;
			
			
		//on test le code avec des parties jouees par des joueurs aleatoires	
		//le fichier "save.txt" sert a initialise le plateau et 
		//	le fichier "test.txt" sert a stocke l avancement de la partie 
		while(!plateau.gameOver()) {
			if(plateau.getLastPlayer().equals("vertical")) {
				
				cp=plateau.possibleMoves("horizontal");
				rand = (int)(Math.random() * cp.length) + 0;
				System.out.println(cp[rand]+"\n");
				plateau.play(cp[rand],"horizontal");
				plateau.saveToFile("test.txt");
			}
			else {
				cp=plateau.possibleMoves("vertical");
				rand = (int)(Math.random() * cp.length) + 0;
				System.out.println(cp[rand]+"\n");
				plateau.play(cp[rand],"vertical");
				plateau.saveToFile("test.txt");
			}
		}
		
	
		System.out.print("fin test\n");
		//une version du code plus optimise est en cours (puisque plus c'est optimise plus on a de temps pour la recherche) mais comme il reste des erreurs
		//on prefere vous transmetre celle-ci
	}
}

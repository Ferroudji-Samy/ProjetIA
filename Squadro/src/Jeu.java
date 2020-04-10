

public class Jeu {
	
	
	//on initilise le plateau et on assigne j2 aux deplacements horizontaux et j1 aux deplacements verticaux
	public static SquadroBoard initialisation() {
		
		String filename="save.txt";
		
		int [][]init=new int[7][7];

		
		Piece un = new Piece('>',0,1,1);
		Piece deux = new Piece('>',0,2,2);
		Piece trois = new Piece('>',0,3,3);
		Piece quatre= new Piece('>',0,4,2);
		Piece cinq = new Piece('>',0, 5,1);
		
		Piece []horizontal= {un,deux,trois,quatre,cinq};
		
		un = new Piece('^',1,6,1);
		deux = new Piece('^',2,6,2);
		trois = new Piece('^',3,6,3);
		quatre= new Piece('^',4,6,2);
		cinq = new Piece('^',5, 6,1);
		
		Piece []vertical={un,deux,trois,quatre,cinq};
		
		SquadroBoard plateau= new SquadroBoard(init,vertical, horizontal);
		plateau.setFromFile(filename);
		
		
		
		
		return plateau;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

			SquadroBoard plateau= initialisation();
			plateau.setLastPlayer("vertical");
			String[] cp;
			
			int rand ;
			
			
		//on test le code avec des parties jouees par des joueurs aleatoires	
			
		while(!plateau.gameOver()) {
			if(plateau.getLastPlayer().equals("vertical")) {
				
				cp=plateau.possibleMoves("horizontal");
				rand = (int)(Math.random() * cp.length) + 0;
				System.out.println(cp[rand]+"\n");
				plateau.play(cp[rand],"horizontal");
				System.out.println(cp[rand]+" fait\n");
				plateau.affiche();
				plateau.saveToFile("test.txt");
			}
			else {
				cp=plateau.possibleMoves("vertical");
				rand = (int)(Math.random() * cp.length) + 0;
				System.out.println(cp[rand]+"\n");
				plateau.play(cp[rand],"vertical");
				System.out.println(cp[rand]+" fait\n");
				plateau.affiche();
				plateau.saveToFile("test.txt");
			}
		}
		
	
		System.out.print("fin test\n");
	}
}

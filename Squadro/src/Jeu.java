import java.nio.file.Paths;

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
		String filename="save.txt";

		
		SquadroBoard plateau= initialisation();
		String[] test=plateau.possibleMoves("horizontal");
		
		for(String i : test) {
			plateau.play(i,"horizontal");
			plateau.saveToFile("test.txt");
		}
		
		
		test=plateau.possibleMoves("vertical");
		
		for(String i : test) {
			plateau.play(i,"vertical");
			plateau.saveToFile("test.txt");
		}
		
		plateau.saveToFile("test.txt");
		System.out.print("fin test");
		
		}
}

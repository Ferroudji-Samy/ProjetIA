import java.nio.file.Paths;

public class Jeu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename="save.txt";
		
		char [][]init=new char[7][7];
		
		SquadroBoard plateau= new SquadroBoard(init,null, null);
		plateau.setFromFile(filename);
		
		String move="C7-C3";
		plateau.play(move, "horizontal");
		
		plateau.saveToFile("test.txt");
		
		System.out.print(plateau.gameOver());
		
		}
}

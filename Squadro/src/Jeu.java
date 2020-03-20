import java.nio.file.Path;
import java.nio.file.Paths;

public class Jeu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename="save.txt";
		
		char [][]init=new char[7][7];
		
		SquadroBoard plateau= new SquadroBoard(init,null, null);
		plateau.setFromFile(filename);
		plateau.saveToFile("test.txt");
		int []tab=plateau.stringToMove("F2-B6");
		for(int i : tab) {
			System.out.println(tab[i]);
		}
	}

}

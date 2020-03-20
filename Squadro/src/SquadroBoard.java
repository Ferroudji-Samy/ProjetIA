
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquadroBoard implements IPartie2{
	
	private char[][] plateau = new char [7][7];
	private Piece[] j1=new Piece [5] ;
	private Piece[] j2=new Piece [5] ;
	
	public SquadroBoard(char[][] p, Piece[] pieceJ1, Piece[] pieceJ2) {
		plateau=p;
		j1=pieceJ1;
		j2=pieceJ2;
	}
	

	@Override
	public void setFromFile(String fileName) {
		// TODO Auto-generated method stub

		int y=0;
		try {
			for (String ligne : Files.readAllLines(Paths.get(fileName))) {
				for (String chaine : ligne.split(" ")){
					if(chaine != "^" || chaine !=">" || chaine !="." || chaine != "v" || chaine !="<" ) {
						for(int i=0;i<7;i++) {
							plateau[i][y]=chaine.charAt(i);
						}
						y++;
						
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void saveToFile(String fileName) {
		// TODO Auto-generated method stub
		
		Path fichier = Paths.get(fileName);
		
		ArrayList<String> afficheVertical = new ArrayList();
		ArrayList<String> afficheHorizontal = new ArrayList();
		afficheHorizontal.add("%  ABCDEFG");
		ArrayList<String> afficheLigne = new ArrayList();
		int count=1;
		
		try {
			Files.write(fichier,afficheHorizontal,Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for(char[] ligne : this.plateau) {
			
			afficheVertical.add("%0"+count);
			try {
				Files.write(fichier,afficheVertical,Charset.forName("UTF-8"), StandardOpenOption.APPEND);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			afficheLigne.add(ligne.toString());
			try {
				Files.write(fichier,afficheLigne,Charset.forName("UTF-8"), StandardOpenOption.APPEND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			afficheLigne.clear();
			
			try {
				Files.write(fichier,afficheVertical,Charset.forName("UTF-8"), StandardOpenOption.APPEND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			afficheVertical.clear();
			count++;
			
		}
		
		try {
			Files.write(fichier,afficheHorizontal,Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean isValidMove(String move, String player) {
		// TODO Auto-generated method stub
		String[] moves=possibleMoves(player);
		for(String i : moves) {
			if (i.compareTo(move)==0)return true;
		}
		return false;
	}

	@Override
	public String[] possibleMoves(String player) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void play(String move, String role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean gameOver() {
		// TODO Auto-generated method stub
		int count1=0;
		int count2=0;
		for(int i=0; i<this.plateau.length;i++) {
			for(int j=0;i<this.plateau[i].length;i++) {
				if(this.plateau[i][j]=='^' || this.plateau[i][j]=='v')count1++;
				if(this.plateau[i][j]=='<' || this.plateau[i][j]=='>')count2++;
				if(count1<3 || count2<3)return true;
			}
		}
		return false;
	}
	
}

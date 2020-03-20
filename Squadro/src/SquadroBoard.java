
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;

public class SquadroBoard implements IPartie2{
	
	private char[][] plateau = new char [7][7];
	private Piece[] j1=new Piece [5] ;
	private Piece[] j2=new Piece [5] ;
	private HashMap<String, Integer> col = new HashMap<String, Integer>(); //Les lettres correspondant aux colonnes
	private String lastPlayer;
	public SquadroBoard(char[][] p, Piece[] pieceJ1, Piece[] pieceJ2) {
		plateau=p;
		j1=pieceJ1;
		j2=pieceJ2;
		
		col.put("A", 0);
		col.put("B", 1);
		col.put("C", 2);
		col.put("D", 3);
		col.put("E", 4);
		col.put("F", 5);
		col.put("G", 6);
		
		this.plateau=p;
		this.setJ1(pieceJ1);
		this.setJ2(pieceJ2);
		this.lastPlayer=null;
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
		
		ArrayList<String> afficheVertical = new ArrayList<String>();
		ArrayList<String> afficheHorizontal = new ArrayList<String>();
		afficheHorizontal.add("%  ABCDEFG");
		ArrayList<String> afficheLigne = new ArrayList<String>();
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
		
		
		afficheHorizontal.clear();
		afficheHorizontal.add(this.lastPlayer);
		try {
			Files.write(fichier,afficheHorizontal,Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	// ATTENTION : comment prendre en compte le fait de passer au dessus d'un autre joueur ?
	@Override
	public boolean isValidMove(String move, String player) {
		/*
		String[] moves=possibleMoves(player);
		for(String i : moves) {
			if (i.compareTo(move)==0)return true;
		}
		return false;
		*/
		
		//Peut-etre mieux de verifier le coup directement, sans avoir a creer le tableau entier des coups possibles :
		int[] tab = stringToMove(move);
		if(player.equals("v")) { 		//si le joueur joue verticalement
			int valDep = j1[tab[1]].getDeplacement();
			if(tab[0] != tab[2] || Math.abs(tab[2]-tab[0]) != valDep) { //Si la colonne change ou qu'on ne respecte pas la valeur de deplacement
				return false;
			}
		} else {	//si le joueur joue horizontalement
			int valDep = j2[tab[0]].getDeplacement();
			if(tab[1] != tab[3]|| Math.abs(tab[3]-tab[1]) != valDep) { //Si la ligne change ou qu'on ne respecte pas la valeur de deplacement
				return false;
			}
		}
		return true;
	}

	
	
	
	@Override
	public String[] possibleMoves(String player) {

		return null;
	}

	
	
	@Override
	public void play(String move, String role) {
		// TODO Auto-generated method stub
		int []tab = stringToMove(move);
		
		this.plateau[tab[2]][tab[3]]=this.plateau[tab[0]][tab[1]];
		this.plateau[tab[0]][tab[1]]='.';
		
		this.lastPlayer=role;	
		
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


	public Piece[] getJ1() {
		return j1;
	}


	public void setJ1(Piece[] j1) {
		this.j1 = j1;
	}


	public Piece[] getJ2() {
		return j2;
	}


	public void setJ2(Piece[] j2) {
		this.j2 = j2;
	}
	
	public int[] stringToMove(String move) { 
		int[] tab = new int[4];
		
		String s1 = move.substring(0, 1);
		String s2 = move.substring(1, 2);
		String s3 = move.substring(2, 3);
		String s4 = move.substring(3, 4);
		
		tab[0] = col.get(s1);
		tab[1] = Integer.parseInt(s2);
		tab[2] = col.get(s3);
		tab[3] = Integer.parseInt(s4);
		
		return tab;
	}
}

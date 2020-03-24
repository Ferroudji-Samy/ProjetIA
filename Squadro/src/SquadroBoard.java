
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
	private HashMap<Integer, String> colChiffre = new HashMap<Integer, String>();
	
	private String lastPlayer;
	
	
	public SquadroBoard(char[][] p, Piece[] pieceJ1, Piece[] pieceJ2) {
		this.plateau=p;
		this.j1=pieceJ1;
		this.j2=pieceJ2;
		
		col.put("A", 0);
		col.put("B", 1);
		col.put("C", 2);
		col.put("D", 3);
		col.put("E", 4);
		col.put("F", 5);
		col.put("G", 6);
		
		colChiffre.put(0, "A");
		colChiffre.put(1, "B");
		colChiffre.put(2, "C");
		colChiffre.put(3, "D");
		colChiffre.put(4, "E");
		colChiffre.put(5, "F");
		colChiffre.put(6, "G");
		
		this.plateau=p;

		this.setLastPlayer(null);
	}
	

	@Override
	public void setFromFile(String fileName) {
		int y=0;
		try {
			for (String ligne : Files.readAllLines(Paths.get(fileName))) {
				for (String chaine : ligne.split(" ")){

					if(chaine.contains(".")||chaine.contains(">")||chaine.contains("<")||chaine.contains("^")||chaine.contains("v")) {
						for(int i=0;i<7;i++) {
							plateau[y][i]=chaine.charAt(i);
						}
						y++;
				
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveToFile(String fileName) {
		
		Path fichier = Paths.get(fileName);
		
		ArrayList<String> afficheHorizontal = new ArrayList<String>();
		afficheHorizontal.add("%  ABCDEFG");
		ArrayList<String> afficheLigne = new ArrayList<String>();
		int count=1;
		
		try {
			Files.write(fichier,afficheHorizontal,Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for(char[] ligne : this.plateau) {

			afficheLigne.add("0"+count+" "+String.valueOf(ligne)+" "+"0"+count);
 
			try {
				Files.write(fichier,afficheLigne,Charset.forName("UTF-8"), StandardOpenOption.APPEND);
			} catch (IOException e) {
				e.printStackTrace();
			}
			afficheLigne.clear();
			
			count++;
			
		}
		
		try {
			Files.write(fichier,afficheHorizontal,Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		afficheHorizontal.clear();
		afficheHorizontal.add(this.getLastPlayer());
		try {
			Files.write(fichier,afficheHorizontal,Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

	// ATTENTION : comment prendre en compte le fait de passer au dessus d'un autre joueur ?
	@Override
	public boolean isValidMove(String move, String player) {
		//TODO
		String[] moves=possibleMoves(player);
		for(String i : moves) {
			if (i.compareTo(move)==0)return true;
		}
		return false;
		
		/*
		 * je le met en com vu que pour l'instant ca marche pas vraiment
		 * 
		//Peut-etre mieux de verifier le coup directement, sans avoir a creer le tableau entier des coups possibles :
		int[] tab = stringToMove(move);
		if(player.equals("vertical")) { 		//si le joueur joue verticalement
			int valDep = j1[tab[1]].getDeplacement();
			if(tab[0] != tab[2] || Math.abs(tab[3]-tab[1]) != valDep || tab[3]>=7 || tab[3]<0) { //Si la colonne change ou qu'on ne respecte pas la valeur de deplacement ou qu'on sot des mimites du tableau
				return false;
			}
		} else {	//si le joueur joue horizontalement
			int valDep = j2[tab[0]].getDeplacement();
			if(tab[1] != tab[3]|| Math.abs(tab[2]-tab[0]) != valDep || tab[2]>=7 || tab[2]<0) { //Si la ligne change ou qu'on ne respecte pas la valeur de deplacement
				return false;
			}
		}
		return true;
		**/
	}

	//Il faudra prendre en compte les allers retours pendant le coup et les sauts par dessus des adversaires
	@Override
	public String[] possibleMoves(String player) {
		//TODO
		ArrayList<String> moveArray=new ArrayList<String>();
		if(player.equals("vertical")) {	//si le joueur joue verticalement
			for(int i=0; i< j1.length; i++) {	//On rajoute le coups possible pour chaque piece
				if(j1[i].isInGame()) {	
					Piece p = j1[i];
					
					int y = p.getY();
					int d= p.getDeplacement() * p.getAR();
					int newY = y-d;
					
					while(newY<7 && newY>=0 && Character.compare(this.plateau[newY][p.getX()],'.')!=0) {
						newY-=p.getAR();
					}
					
					if(newY>=7) { //si on atteint le bord droit
						newY = 6;
						//Il faudra changer la direction de la piece si on decide de jouer ce coup
					}else if(newY<0) { //Si on rencontre un bord gauche
						newY = 0;
						//Il faudra changer la direction de la piece si on decide de jouer ce coup
					}
					
					y++;
					newY++;
					String coup = colChiffre.get(p.getX()) + y + "-" + colChiffre.get(p.getX()) + newY;
					moveArray.add(coup);
				}
			}
		} 
		else {	//si le joueur joue horizontalement
			for(int i=0; i<j2.length; i++) {
				if(j2[i].isInGame()) {	
					Piece p = j2[i];
					
					int x = p.getX();
					int d=p.getAR()*p.getDeplacement();
					int newX = x+d;
					
					while(newX<7 && newX>=0 && Character.compare(this.plateau[p.getY()][newX],'.')!=0) {
						newX+=p.getAR();
					}
					
					
					if(newX>=7) { //si on atteint le bord haut
						newX = 6;
						//Il faudra changer la direction de la piece si on decide de jouer ce coup
					}else if(newX<0) { //Si on rencontre un bord bas
						newX = 0;
						//Il faudra changer la direction de la piece si on decide de jouer ce coup
					}
					
					String coup = colChiffre.get(x) + (p.getY()+1) + "-" + colChiffre.get(newX) + (p.getY()+1);
					moveArray.add(coup);
				}	
			}
		}
		
		
		String []arrayToTab=new String[moveArray.size()];
		int j=0;
		for(String i: moveArray) {
			arrayToTab[j]=i;
			j++;
		}
		return arrayToTab;
	}

	@Override
	public void play(String move, String role) {
		int []tab = stringToMove(move);
		char stock;
		stock=this.plateau[tab[3]][tab[2]];
		this.plateau[tab[3]][tab[2]]=this.plateau[tab[1]][tab[0]];
		this.plateau[tab[1]][tab[0]]=stock;
		
		int c=0;
		if(role.equals("vertical")) {
			
			for(Piece i : this.j1) {

				if(i.getX()==tab[0] && i.getY()==tab[1]) {
					this.j1[c].setX(tab[2]);
					this.j1[c].setY(tab[3]);
					if(tab[3]==0 ) {
						this.plateau[tab[3]][tab[2]]='v';
						this.j1[c].inverseDeplacement();
						this.j1[c].setAR(-1);
					}
					if(tab[3]==6 && this.j1[c].getAR()==-1 ) {
						this.j1[c].inverseDeplacement();
					}
					
					int c2=0;
					int min=Math.min(tab[1],tab[3]);
					int max=Math.max(tab[1],tab[3]);
					for(Piece j : j2) {
						if(j.getY()>min && j.getY()<max && j.getX()==tab[0]) {
							if (j2[c2].getAR()==1) {
								this.plateau[j.getY()][0]='>';
								this.plateau[j.getY()][j.getX()]='.';
								j2[c2].setX(0);
							}
							else {
								this.plateau[j.getY()][6]='<';
								this.plateau[j.getY()][j.getX()]='.';
								j2[c2].setX(6);
							}
						}
						c2++;
					}
	
				}
				c++;
			}

			
		}
		else {
			for(Piece i : this.j2) {
				if(i.getX()==tab[0] && i.getY()==tab[1]) {
					this.j2[c].setX(tab[2]);
					this.j2[c].setY(tab[3]);
					if(tab[2]==6) {
						this.plateau[tab[3]][tab[2]]='<';
						this.j2[c].inverseDeplacement();
						this.j2[c].setAR(-1);
					}
					if(tab[3]==0 && this.j2[c].getAR()==-1 ) {
						this.j2[c].inverseDeplacement();
					}
					int c2=0;
					int min=Math.min(tab[0],tab[2]);
					int max=Math.max(tab[0],tab[2]);
					for(Piece j : j1) {
						if(j.getX()>min && j.getX()<max && j.getY()==tab[1]) {
							if (j1[c2].getAR()==1) {
								this.plateau[6][j.getX()]='^';
								this.plateau[j.getY()][j.getX()]='.';
								j1[c2].setY(6);
							}
							else {
								this.plateau[0][j.getX()]='v';
								this.plateau[j.getY()][j.getX()]='.';
								j1[c2].setY(0);
							}
						}
						c2++;
					}
				
				}
				c++;
			}
						
		}
		this.setLastPlayer(role);	
		
	}

	
	
	
	@Override
	public boolean gameOver() {
		int count1=0;
		int count2=0;
		for(int y=1;y<this.plateau[0].length;y++) {

			if(this.plateau[y][0]=='<')count1++;
			if(count1>2)return true;
		}
		for(int x=1;x<this.plateau[6].length;x++) {
			if(this.plateau[6][x]=='v')count2++;
			if(count2>2)return true;
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
		String s3 = move.substring(3, 4);
		String s4 = move.substring(4);
		
		tab[0] = col.get(s1);
		tab[1] = Integer.parseInt(s2)-1;
		tab[2] = col.get(s3);
		tab[3] = Integer.parseInt(s4)-1;
		
		return tab;
	}


	public String getLastPlayer() {
		return lastPlayer;
	}


	public void setLastPlayer(String lastPlayer) {
		this.lastPlayer = lastPlayer;
	}
}

package iia.games.algo;

import iia.games.base.SquadroBoard;

public class Aleatoire {
	
	public static String alea(SquadroBoard plateau , boolean role ) {
		if(role) {
			String[] s=plateau.possibleMoves("vertical");
			int i=(int)(Math.random() * s.length);
			return s[i];
		}
		else{
			String[] s=plateau.possibleMoves("horizontal");
			int i=(int)(Math.random() * s.length);
			return s[i];
		}

	}

}

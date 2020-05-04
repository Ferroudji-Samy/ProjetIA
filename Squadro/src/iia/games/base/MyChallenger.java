package iia.games.base;

import iia.games.algo.Aleatoire;
import iia.games.algo.IDAlphaBeta;

public class MyChallenger implements IChallenger {

	private boolean role; //2 joueurs donc un booleen est plus rapide a calcule pour la comparaison qu une string
						  //True pour le joueur vertical False pour le joueur Horizontal
	private SquadroBoard plateau;
	
	public MyChallenger() {
		this.setPlateau(Jeu.initialisation());
	}
	
	@Override
	public String teamName() {
		// TODO Auto-generated method stub
		System.out.println(role);
		return "Patricia_Samy";
		
	}

	@Override
	public void setRole(String r) {
		// TODO Auto-generated method stub
		this.role=r.equals("vertical");
		System.out.println(role);
	}

	@Override
	public void iPlay(String move) {
		if(this.role) {
			this.getPlateau().play(move,"vertical");
		}
		else this.getPlateau().play(move,"horizontal");
	}

	@Override
	public void otherPlay(String move) {
		// TODO Auto-generated method stub
		if(this.role) {
			this.getPlateau().play(move,"horizontal");
		}
		else{
			this.getPlateau().play(move,"vertical");
		}
	}

	@Override
	public String bestMove() {
		//return Aleatoire.alea(this.plateau,this.role);
		IDAlphaBeta a=new IDAlphaBeta();
		System.out.println("AlphaBeta");
		SquadroBoard state=this.plateau.copy();
		state.setLastPlayer("Horizontal");
		return plateau.moveToString(a.IdAlphaBeta(this.plateau,CHeuristique.h1));
		
	}

	@Override
	public String victory() {
		// TODO Auto-generated method stub
		return  "░░░░░░░░░░▄▄▀▀▀▀▀▀▀▀▀▄▄░░░░░░░░░░"+"\n"+
				"░░░░░░░░░█░░░░░░░░░░░░░█░░░░░░░░░"+"\n"+
				"░░░░░░░░█░░░░░░░░░░▄▄▄░░█░░░░░░░░"+"\n"+
				"░░░░░░░░█░░▄▄▄░░▄░░███░░█░░░░░░░░"+"\n"+
				"░░░░░░░░▄█░▄░░░▀▀▀░░░▄░█▄░░░░░░░░"+"\n"+
				"░░░░░░░░█░░▀█▀█▀█▀█▀█▀░░█░░░░░░░░"+"\n"+
				"░░░░░░░░▄██▄▄▀▀▀▀▀▀▀▄▄██▄░░░░░░░░"+"\n"+
				"░░░░░░▄█░█▀▀█▀▀▀█▀▀▀█▀▀█░█▄░░░░░░"+"\n"+
				"░░░░░▄▀░▄▄▀▄▄▀▀▀▄▀▀▀▄▄▀▄▄░▀▄░░░░░"+"\n"+
				"░░░░░█░░░░▀▄░█▄░░░▄█░▄▀░░░░█░░░░░"+"\n"+
				"░░░░░░▀▄▄░█░░█▄▄▄▄▄█░░█░▄▄▀░░░░░░"+"\n"+
				"░░░░░░░░▀██▄▄███████▄▄██▀░░░░░░░░"+"\n"+
				"░░░░░░░░████████▀████████░░░░░░░░"+"\n"+
				"░░░░░░░▄▄█▀▀▀▀█░░░█▀▀▀▀█▄▄░░░░░░░"+"\n"+
				"░░░░░░░▀▄▄▄▄▄▀▀░░░▀▀▄▄▄▄▄▀░░﻿░░░░░"+"\n";
	}

	@Override
	public String defeat() {
		// TODO Auto-generated method stub
		return  "	⠀⠀⠀⠀⣠⣶⡾⠏⠉⠙⠳⢦⡀⠀⠀⠀    ⢠⠞⠉⠙⠲⡀⠀"+"\n"+
				"	⠀⠀⠀⣴⠿⠏⠀⠀⠀⠀⠀⠀⢳⡀⠀     ⡏⠀⠀⠀⠀⠀      ⢷"+"\n"+
				"	⠀⠀⢠⣟⣋⡀⢀⣀⣀⡀⠀⣀⡀⣧⠀⢸⠀⠀⠀⠀⠀           ⡇"+"\n"+
				"	⠀⠀⢸⣯⡭⠁⠸⣛⣟⠆⡴⣻⡲⣿⠀⣸  Defaite ⡇"+"\n"+
				"	⠀⠀⣟⣿⡭⠀⠀⠀⠀⠀⢱⠀⠀⣿⠀  ⢹⠀⠀⠀⠀⠀          ⡇"+"\n"+
				"	⠀⠀⠙⢿⣯⠄⠀⠀⠀⢀⡀⠀⠀⡿⠀⠀  ⡇⠀⠀⠀⠀     ⡼"+"\n"+
				"	⠀⠀⠀⠀⠹⣶⠆⠀⠀⠀⠀⠀⡴⠃⠀⠀     ⠘⠤⣄⣠⠞⠀"+"\n"+
				"	⠀⠀⠀⠀⠀⢸⣷⡦⢤⡤⢤⣞⣁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
				"	⠀⠀⢀⣤⣴⣿⣏⠁⠀⠀⠸⣏⢯⣷⣖⣦⡀⠀⠀⠀⠀⠀⠀"+"\n"+
				"	⢀⣾⣽⣿⣿⣿⣿⠛⢲⣶⣾⢉⡷⣿⣿⠵⣿⠀⠀⠀⠀⠀⠀"+"\n"+
				"	⣼⣿⠍⠉⣿⡭⠉⠙⢺⣇⣼⡏⠀⠀⠀⣄⢸⠀⠀⠀⠀⠀⠀"+"\n"+
				"	⣿⣿⣧⣀⣿.........⣀⣰⣏⣘⣆⣀⠀⠀"+"\n";
	}

	@Override
	public String tie() {
		// TODO Auto-generated method stub
		return "	⠀⠀⠀⠀⣠⣶⡾⠏⠉⠙⠳⢦⡀⠀⠀⠀    ⢠⠞⠉⠙⠲⡀⠀"+"\n"+
				"	⠀⠀⠀⣴⠿⠏⠀⠀⠀⠀⠀⠀⢳⡀⠀     ⡏⠀⠀⠀⠀⠀      ⢷"+"\n"+
				"	⠀⠀⢠⣟⣋⡀⢀⣀⣀⡀⠀⣀⡀⣧⠀⢸⠀⠀⠀⠀⠀           ⡇"+"\n"+
				"	⠀⠀⢸⣯⡭⠁⠸⣛⣟⠆⡴⣻⡲⣿⠀⣸  Egalite ⡇"+"\n"+
				"	⠀⠀⣟⣿⡭⠀⠀⠀⠀⠀⢱⠀⠀⣿⠀  ⢹⠀⠀⠀⠀⠀          ⡇"+"\n"+
				"	⠀⠀⠙⢿⣯⠄⠀⠀⠀⢀⡀⠀⠀⡿⠀⠀  ⡇⠀⠀⠀⠀     ⡼"+"\n"+
				"	⠀⠀⠀⠀⠹⣶⠆⠀⠀⠀⠀⠀⡴⠃⠀⠀     ⠘⠤⣄⣠⠞⠀"+"\n"+
				"	⠀⠀⠀⠀⠀⢸⣷⡦⢤⡤⢤⣞⣁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
				"	⠀⠀⢀⣤⣴⣿⣏⠁⠀⠀⠸⣏⢯⣷⣖⣦⡀⠀⠀⠀⠀⠀⠀"+"\n"+
				"	⢀⣾⣽⣿⣿⣿⣿⠛⢲⣶⣾⢉⡷⣿⣿⠵⣿⠀⠀⠀⠀⠀⠀"+"\n"+
				"	⣼⣿⠍⠉⣿⡭⠉⠙⢺⣇⣼⡏⠀⠀⠀⣄⢸⠀⠀⠀⠀⠀⠀"+"\n"+
				"	⣿⣿⣧⣀⣿.........⣀⣰⣏⣘⣆⣀⠀⠀"+"\n";
	}

	public SquadroBoard getPlateau() {
		return plateau;
	}

	public void setPlateau(SquadroBoard plateau) {
		this.plateau = plateau;
	}

}

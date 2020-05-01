package iia.games.base;

public class MyChallenger implements IChallenger {

	private boolean role; //2 joueurs donc un booleen est plus rapide a calcule pour la comparaison qu une string
						  //True pour le joueur vertical False pour le joueur Horizontal
	private SquadroBoard plateau;
	
	public MyChallenger() {
		this.plateau= Jeu.initialisation();
	}
	
	@Override
	public String teamName() {
		// TODO Auto-generated method stub
		return "Patricia_Samy";
	}

	@Override
	public void setRole(String role) {
		// TODO Auto-generated method stub
		this.role=role.equals("vertical");
		
	}

	@Override
	public void iPlay(String move) {
		System.out.println(move);
		if(this.role) {
			this.plateau.play(move,"vertical");
		}
		this.plateau.play(move,"horizontal");
	}

	@Override
	public void otherPlay(String move) {
		// TODO Auto-generated method stub
		if(this.role) {
			this.plateau.play(move,"horizontal");
		}
		else{
			this.plateau.play(move,"vertical");
		}
	}

	@Override
	public String bestMove() {
		// TODO Auto-generated method stub
		if(this.role) {
			String[] s=this.plateau.possibleMoves("vertical");
			int i=(int)(Math.random() * s.length);
			System.out.println(i);
			return s[i];
		}
		else{
			String[] s=this.plateau.possibleMoves("horizontal");
			int i=(int)(Math.random() * s.length);
			System.out.println(i);
			return s[i];
		}
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

}

package iia.games.base;

public class Joueur implements IChallenger {

	private boolean role;
	private SquadroBoard plateau;
	
	public Joueur(String role, SquadroBoard plateau) {
		this.plateau=plateau;
		setRole(role);
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
		// TODO Auto-generated method stub
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
		return null;
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

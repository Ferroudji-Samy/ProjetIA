
public interface IPartie2 {
	/** 
	 *  initialise un plateau � partir d'un fichier texte
	 *  @param fileName le nom du fichier � lire 
	 */
	public void setFromFile(String fileName);
	
	
	/**
	 * sauve la configuration de l'�tat courant (plateau et pieces restantes)
	 * dans un fichier 
	 * @param fileName le nom du fichier � sauvegarder 
	 * Le format doit �tre compatible avec celui utlis� pour la lecture.
	 */
	public void saveToFile(String fileName);
	
	
	/**
	 * indique si le coup <move> est valide pour le joueur <player>
	 * sur le plateau courant 
	 * @param move le coup � jouer, sous la forme "A4-C4"
	 * @param player le joueur qui joue, repr�sent� par "vertival" ou "horizontal"
	 */
	public boolean isValidMove(String move, String player);
	
	
	/**
	 * calcule les coups possibles pour le joueur <player> sur le plateau courant
	 * @param player le joueur qui joue, repr�sent� par "verical" ou "horizontal"
	 */
	public String[] possibleMoves(String player);
	
	/**
	 * modifie le plateau en jouant le coup move avec la pi�ce choose
	 * @param move le coup � jouer, sous la forme "A4-C4"
	 * @param player le joueur qui joue, repr�sent� par "vertical" ou "horizontal"
	 */
	public void play(String move, String role);
	
	
	/**
	 *vrai lorsque le plateau correspond � une fin de partie 
	 */
	public boolean gameOver();
	
	
}

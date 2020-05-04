package iia.games.base;

public class CHeuristique implements IHeuristique {
	
	public static CHeuristique h1 = new CHeuristique() {

        @Override
        public float eval(SquadroBoard plateau) {
            int j1=0;
            int j2=0;
            Piece []joueur1=plateau.getJ1();
            Piece []joueur2=plateau.getJ2();
            for(int i=0;i<plateau.getJ1().length;i++) {
            	if(joueur1[i].getAR()==-1) {
            		j1++;
            		if(joueur1[i].isInGame())j1++;
            	}
            	if(joueur2[i].getAR()==-1) {
            		j2++;
            		if(joueur2[i].isInGame())j2++;
            	}	
            }
            return j1-j2;
            
        }
	};
	
	

	
	
	@Override
	public float eval(SquadroBoard plateau) {
		// TODO Auto-generated method stub
		return 0;
	}

}

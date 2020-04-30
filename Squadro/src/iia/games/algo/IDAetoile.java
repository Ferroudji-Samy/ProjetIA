package iia.games.algo;

import java.util.ArrayList;

import iia.games.base.IPartie2;
import iia.games.base.Jeu;

public class IDAetoile implements IAlgo {

	public int IDAEtoile(Etat s){ //etat ou plateau
        int Borne = h(s);
        boolean succes = false;
        boolean stop = false;
        int res;
        
        while(!succes && !stop) {
        	res = rProfHeuristiqueBornee(s, DejaVu, Borne);
        	if(res == echec(ValEchec)) {
        		if(ValEchec > Borne) {
        			Borne = ValEchec;
        		}else {
        			stop = true;
        		}
        	} else {
        		succes = true;
        	}
        }
        return res;
    }
	
	public void rProfHeuristiqueBornee(Etat s, ArrayList<Etat> DejaVu, int Borne){
		
		if(f(s) > Borne) {
			return echec(f(s));
		}
		
		if(estTerminal(s)) {
			ArrayList<Etat> l = new ArrayList<Etat>();
			l.add(s);
			return l;
			
		}else {
			int nouvelleBorne = Integer.MAX_VALUE;
			ArrayList<Etat> LSucc = successeurs(s);
			
			for(int i=0; i < LSucc.size(); i++) {
				Etat s2 = LSucc.get(i);
				//est-ce qu'on met s dans DejaVu ou est-ce qu'on le met dans une copie de DejaVu ?
				//DejaVu.add(s); 
				//int res = rProfHeuristiqueBornee(s2, DejaVu, Borne);
				ArrayList<Etat> DejaVuS = DejaVu.copy();
				DejaVuS.add(s2);
				int res = rProfHeuristiqueBornee(s2, DejaVuS, Borne);
				
				if(res.equals(echec(valEchec))) {
					nouvelleBorne = Math.min(nouvelleBorne, valEchec);
				}else {
					ArrayList<Etat> l = new ArrayList<>();
					l.add(s);
					return s + res;
				}
			}
			return echec(nouvelleBorne);
		}
	}
	


	@Override
	public String bestMove(IPartie2 game, String role) {
		// TODO Auto-generated method stub
		return null;
	}}

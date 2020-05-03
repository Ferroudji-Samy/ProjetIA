package iia.games.algo;

import iia.games.base.Heuristique;
import iia.games.base.SquadroBoard;

public class IDAlphaBeta {
	
	
	final int MaxAllowedTime = 10000;
	final int MaxDepth=100;
	private long startTime;
	private boolean ami;
	
	public int[] IdAlphaBeta(SquadroBoard state, Heuristique evaluationFunc) {
		//TODO
		startTime=System.currentTimeMillis();
		int [] bestMove = null;
		for (int depth=1; depth<MaxDepth;depth++){
			if (System.currentTimeMillis() - startTime > MaxAllowedTime) break;
			double val = Integer.MIN_VALUE;
				//solution provisoire
				int i=0;
				int[][]move=state.possibleMovesInterne(!state.getLastPlayerInterne());
				////
				for (SquadroBoard successor : state.successeurs(!state.getLastPlayerInterne())) {
					double score = alphaBeta(successor, Integer.MIN_VALUE, Integer.MAX_VALUE, depth,evaluationFunc);
				    if (score > val) {
				    	val=score;
				    	bestMove = move[i];//TODO
				    }
				    i++;
				  }
		}
		return bestMove;
	}
	
	public double alphaBeta(SquadroBoard state,double alpha,double beta,int depth, Heuristique evaluationFunc){
		if (state.gameOver()){
			if(state.getLastPlayerInterne()==ami) {
				return Integer.MAX_VALUE;
			}
			else return Integer.MIN_VALUE;
		}
		
		if (depth <= 0 || System.currentTimeMillis() - startTime > MaxAllowedTime) {
			return evaluationFunc.eval(state); //heuristique
		}
		
		if (state.getLastPlayerInterne()==ami){
			return maxValue(state, alpha, beta, depth,evaluationFunc); 
		}
		else return minValue(state, alpha, beta, depth,evaluationFunc);

	}
	
	public double maxValue(SquadroBoard state,double alpha,double beta,int depth, Heuristique evaluationFunc) {
		double val = Integer.MIN_VALUE;
		for (SquadroBoard successor : state.successeurs(!state.getLastPlayerInterne())) {
			val = Math.max(val, alphaBeta(successor, alpha, beta, depth, evaluationFunc));
			if (val >= beta) return val;
				alpha = Math.max(alpha, val);
		}
		return val;
	}
	
	
	public double minValue(SquadroBoard state,double alpha,double beta,int depth, Heuristique evaluationFunc) {
		double val = Integer.MAX_VALUE;
		for (SquadroBoard successor : state.successeurs(!state.getLastPlayerInterne())) {
			val = Math.min(val, alphaBeta(successor, alpha, beta, depth - 1, evaluationFunc));
			if (val <= alpha) return val;
				beta = Math.min(beta, val);
		}
		return val;
	}
	

}

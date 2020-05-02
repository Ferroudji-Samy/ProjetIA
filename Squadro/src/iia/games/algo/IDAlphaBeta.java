package iia.games.algo;

import iia.games.base.Heuristique;
import iia.games.base.SquadroBoard;

public class IDAlphaBeta {
	
	
	public int[] IdAlphaBeta(SquadroBoard state, Heuristique evaluationFunc) {
		//TODO
		int [] bestMove = null;
		for (int depth=1; depth<MaxDepth;depth++){
			if (time() - startTime > MaxAllowedTimeInSeconds) break;
			double val = -MaxUtility;
				for (SquadroBoard successor : state.getSuccessors()) {
					double score = alphaBetaSearch(successor, -MaxUtility, MaxUtility, depth);
				    if (score > val) {
				    	val=score;
				    	bestMove = successor.moves;
				    }
				  }
		}
		return bestMove;
	}
	
	public double alphaBeta(SquadroBoard state,double alpha,double beta,int depth){
		maxValue(state, alpha, beta, depth);
		minValue(state, alpha, beta, depth);
		if state.isTerminalState(){
			return state.getTerminalUtility()
		}
		
		if (depth <= 0 || time() - startTime > MaxAllowedTimeInSeconds) {
			return evaluationFunc(state);
		}
		
		if (state.blackToMove == IsPlayerBlack ){
			return maxValue(state, alpha, beta, depth); 
		}
		else return minValue(state, alpha, beta, depth);

	}
	
	public double maxValue(SquadroBoard state,double alpha,double beta,int depth) {
		double val = -MaxUtility;
			      for (SquadroBoard successor : state.getSuccessors()) {
			    	  
			        val = Math.max(val, alphaBeta(successor, alpha, beta, depth));
			        if (val >= beta) return val;
			        alpha = Math.max(alpha, val);
			}
			  return val;
	}
	
	
	public double minValue(SquadroBoard state,double alpha,double beta,int depth) {
		double val = MaxUtility;
		for (SquadroBoard successor : state.getSuccessors()) {
			        val = Math.min(val, alphaBeta(successor, alpha, beta, depth - 1))
			        if (val <= alpha) return val;
			        beta = Math.min(beta, val);
		}
			      return val;
	}
	
	
	/**
	def iterativeDeepeningAlphaBeta(state, evaluationFunc):
		  startTime = time()

		  def alphaBetaSearch(state, alpha, beta, depth):
		    def maxValue(state, alpha, beta, depth):
		      val = -MaxUtility
		      for successor in state.getSuccessors():
		        val = max(val, alphaBetaSearch(successor, alpha, beta, depth))
		        if val >= beta: return val
		        alpha = max(alpha, val)
		      return val

		    def minValue(state, alpha, beta, depth):
		      val = MaxUtility
		      for successor in state.getSuccessors():
		        val = min(val, alphaBetaSearch(successor, alpha, beta, depth - 1))
		        if val <= alpha: return val
		        beta = min(beta, val)
		      return val

		    if state.isTerminalState(): return state.getTerminalUtility()
		    if depth <= 0 or time() - startTime > MaxAllowedTimeInSeconds: return evaluationFunc(state)
		    return maxValue(state, alpha, beta, depth) if state.blackToMove == IsPlayerBlack else minValue(state, alpha, beta, depth)

		  bestMove = None
		  for depth in xrange(1, MaxDepth):
		    if time() - startTime > MaxAllowedTimeInSeconds: break
		    val = -MaxUtility
		    for successor in state.getSuccessors():
		      score = alphaBetaSearch(successor, -MaxUtility, MaxUtility, depth)
		      if score > val:
		        val, bestMove = score, successor.moves
		  return bestMove
**/	

}

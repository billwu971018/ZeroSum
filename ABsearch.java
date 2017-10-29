import java.util.*;
import java.lang.Math;

public class ABsearch{

	public static final int DEPTH = 6;

	public static double AlphaBeta(Board board, int depth, double a, double b, boolean maxPlayer){
		if (depth ==0 | board.isGoal()){
			char color; 
			if(maxPlayer){
				color = Board.WHITE;
			}
			else{
				color = Board.BLACK;
			}
			return Strategy.offensiveGiven(board, color);
		}
		if(maxPlayer){
			double bestValue = (double) Integer.MIN_VALUE;
			for (Board it_board : board.getSuccessors(Board.BLACK)) {
				bestValue = Math.max(bestValue, AlphaBeta(it_board, depth-1, a, b, false));
				a = Math.max(a, bestValue);
				if(b <= a){
					break; // b cut off
				}
			}
			return bestValue;

		}
		else{
			double bestValue = (double) Integer.MAX_VALUE;
			for (Board it_board : board.getSuccessors(Board.WHITE)) {
				bestValue = Math.min(bestValue, AlphaBeta(it_board, depth-1, a, b, true));
				b = Math.min(b, bestValue);
				if(b <= a){
					break; // a cut off
				}
			}
			return bestValue;

		}

	}

	public static Board getState(Board board){

		Board retval = new Board();
	    List<Board> firstLevel = new ArrayList<Board>();
	    firstLevel = board.getSuccessors(Board.BLACK);
	    double bestValue = (double)Integer.MIN_VALUE;
	    for(Board curr : firstLevel){
	      double v = AlphaBeta(curr, DEPTH - 1, (double)Integer.MIN_VALUE, (double)Integer.MAX_VALUE, false);
	      curr.value = v;
	      if(v > bestValue){
	        retval = new Board(curr); 
	      }
	    }
	    return retval;
	    }
	}
	
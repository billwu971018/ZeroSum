import java.util.*;
import java.lang.Math;

public class ABsearch{

	public static final int DEPTH = 4;//search depth
	public int expended = 0;

	public double AlphaBeta(Board board, int depth, double a, double b, char mColor, boolean maxPlayer, String heu){
    	expended++;
		if (depth ==0 | board.isGoal()){
			if(heu.equals("o1")){
			return Strategy.offensiveGiven(board, mColor);
		}
			if(heu.equals("o2")){
			return Strategy.offensive(board, mColor, depth);
		}
			if(heu.equals("d1")){
			return Strategy.defensiveGiven(board, mColor);
		}
			return Strategy.defensive(board, mColor, depth);
		}

		if(maxPlayer){
			double bestValue = (double) Integer.MIN_VALUE;
			char nextColor;
			if(mColor == Board.WHITE){
				nextColor = Board.BLACK;
			}
			else{
				nextColor = Board.WHITE;
			}

			for (Board it_board : board.getSuccessors(mColor)) {

				bestValue = Math.max(bestValue, AlphaBeta(it_board, depth-1, a, b, nextColor, false, heu));
				a = Math.max(a, bestValue);
				if(b <= a){
					break; // b cut off
				}
			}
			return bestValue;

		}

		else{
			double bestValue = (double) Integer.MAX_VALUE;
			char nextColor;
			if(mColor == Board.WHITE){
				nextColor = Board.BLACK;
			}
			else{
				nextColor = Board.WHITE;
			}
			for (Board it_board : board.getSuccessors(mColor)) {

				bestValue = Math.min(bestValue, AlphaBeta(it_board, depth-1, a, b, nextColor, true, heu));
				b = Math.min(b, bestValue);
				if(b <= a){
					break; // a cut off
				}
			}
			return bestValue;
		}

	}

	public Board getState(Board board, char mColor, String heu){

		Board retval = new Board();
	    List<Board> firstLevel = new ArrayList<Board>();

	    firstLevel = board.getSuccessors(mColor);

	    double bestValue = (double)Integer.MIN_VALUE;
			char nextColor;
			if(mColor == Board.WHITE){
				nextColor = Board.BLACK;
			}
			else{
				nextColor = Board.WHITE;
			}
			double a = (double)Integer.MIN_VALUE;
			double b = (double)Integer.MAX_VALUE;
	    for(Board curr : firstLevel){
				expended++;
	      double v = AlphaBeta(curr, DEPTH - 1, a, b, nextColor, false, heu);
	      curr.value = v;
	      if(v > bestValue){
	      	//find the max value
	        retval = new Board(curr);
	        bestValue = v;
	      }
	    }

	    return retval;
	    }
	}

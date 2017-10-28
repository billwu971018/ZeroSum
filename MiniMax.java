import java.util.*;
import java.lang.Math;
class MiniMax{

  public static int minimax(Board board, int depth, char mColor){

  	if(depth == 0 | board.isGoal()){
  		return Strategy.defensiveGiven(board, mColor);
  	}
  	// max player
  	if(mColor == Board.BLACK){
  		int bestValue = -9999;
  		for (Board it_board : board.getSuccessors()) {
  			int max = minimax(it_board, depth-1, Board.WHITE);
  			bestValue = Math.max(bestValue, max);

  		}
  		return bestValue;
  	}
  	// min player
  	if(mColor == Board.WHITE){
  		int bestValue = 9999;
  		for (Board it_board : board.getSuccessors()) {
  			int max = minimax(it_board, depth-1, Board.BLACK); // change to next state
  			bestValue = Math.min(bestValue, max);

  		}
  		return bestValue;

  	}
  }



}

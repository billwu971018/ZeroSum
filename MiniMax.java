import java.util.*;
import java.lang.Math;

class MiniMax{
  // public static Board test  = new Board();
  public static int MAX_DEPTH = 3;
  public int expended = 0;
  public double minimax(Board board, int depth, char mColor, Boolean maxPlayer){
      expended++;
    if(depth == 0 | board.isGoal()){
      return Strategy.offensiveGiven(board, mColor);

    }
    // max player
    if(maxPlayer){

      double bestValue = (double)Integer.MIN_VALUE;
      char nextColor;
      if(mColor == Board.WHITE){
        nextColor = Board.BLACK;
      }
      else{
        nextColor = Board.WHITE;
      }
      List<Board> successors = new ArrayList<Board>();
      successors = board.getSuccessors(mColor);
      for (Board it_board : successors) {

        double max = minimax(it_board, depth-1, nextColor, false);
       bestValue = Math.max(bestValue, max);

      }
      return bestValue;

    }
    // min player
    else {

       double bestValue = (double)Integer.MAX_VALUE;
       char nextColor;
       if(mColor == Board.WHITE){
         nextColor = Board.BLACK;
       }
       else{
         nextColor = Board.WHITE;
       }
       List<Board> successors = new ArrayList<Board>();
      successors = board.getSuccessors(mColor);
      for (Board it_board : successors) {

        double max = minimax(it_board, depth-1, nextColor, true); // change to next state
        bestValue = Math.min(bestValue, max);

      }

      return bestValue;

    }

  }

  public Board getState(Board board, char mColor){
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
    for(Board curr : firstLevel){
            expended++;
      if(curr.isGoal()){

        return curr;
      }
      double v = minimax(curr, MAX_DEPTH - 1, nextColor, false);
      curr.value = v;
      if(v > bestValue){
        retval = new Board(curr);
        bestValue = v;
      }
    }
    return retval;
    }

}

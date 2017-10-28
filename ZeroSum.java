import java.util.*;

class ZeroSum {
    public static void main(String[] args){
    Board a = new Board();


    List<Board> s = new ArrayList<Board>();
    s = a.getSuccessors('W');
    for(Board curr : s){
      curr.printBoard();
      System.out.println();
    }

    //System.out.println(Utilities.numRem('W'));
}
}

import java.util.*;

class Utilities{
   public static int numRem(char curr_val){
     int count = 0;
     for(int i = 0; i < 64; i++){
         if(Board.board.get(i).value == curr_val){
           count++;
         }
       }
     return count;
     }
}

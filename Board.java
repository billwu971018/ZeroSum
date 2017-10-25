import java.util.*;

class Board{
   public static List<Node> board = new ArrayList<>();

   public static void initBoard(){
      for(int i = 1; i <= 8; i++){
         for(int j = 1; j <= 8; j++){
           if(i == 1 || i == 2){
             board.add(new Node(j, i, 'B'));
           }
           else if(i == 7 || i == 8){
             board.add(new Node(j, i, 'W'));
           }
           else{
             board.add(new Node(j, i, '_'));
           }
           }
         }
    }


   public static void printBoard(){
     int count = 0;
       for (int i = 1; i <= 8; i++) {
         for(int j = 1; j <= 8; j++) {
            System.out.print(board.get(count).value);
            count++;
          }
         System.out.println();
     }
   }
 }

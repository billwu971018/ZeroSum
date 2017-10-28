import java.util.*;

class Board{
   public static Node[][] board = new Node[8][8];

   // copy constructor
   public Board(Board other){
      for(int i = 0; i < 8; i++){
        for(int j = 0; j < 8; j++){
          this.board[j][i] = new Node(other.board[j][i]);
        }
      }
   }

   // default constructor
   public Board(){
     for(int i = 0; i < 8; i++){
        for(int j = 0; j < 8; j++){
          if(i == 0 || i == 1){
            board[j][i] = new Node(j, i, 'B');
          }
          else if(i == 6 || i == 7){
            board[j][i] = new Node(j, i, 'W');
          }
          else{
            board[j][i] = new Node(j, i, '_');
          }
          }
        }
   }

   public void printBoard(){
     int count = 0;
       for (int i = 0; i < 8; i++) {
         for(int j = 0; j < 8; j++) {
            System.out.print(board[j][i].value);
            count++;
          }
         System.out.println();
     }
   }

   public Boolean isEqual(Board other){
     for(int i = 0; i < 8; i++){
       for(int j = 0; j < 8; j++){
         if(!this.board[j][i].equals(other.board[j][i])){
           return false;
         };
       }
     }
     return true;
   }

   //return the number of remaining chess of color val
   public int numRem(char val){
     if(val != 'W' || val != 'B'){
        return -1; //invalid
     }
     int count = 0;
     for(int i = 0; i < 8; i++){
       for(int j = 0; j < 8; j++){
         if(this.board[j][i].value == val){
           count++;
         }
       }
     }
     return count;
   }

   //return all of the next possible states of Board by moving each color of val
   public List<Board> getSuccessors(char val){
     List<Board> = new ArrayList<Board>();
     for(int i = 0; i < 8; i++){
       for(int j = 0; j < 8; j++){
         
       }
     }
   }
 }

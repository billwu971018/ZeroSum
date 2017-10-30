
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
// implements MouseListener, MouseMotionListener
public class ZeroSum extends JFrame  {
  static JLayeredPane layeredPane;
  static JPanel chessBoard;
  static JLabel chessPiece;
  static int xAdjustment;
  static int yAdjustment;
  
  public static ImageIcon imageIcon_blue = new ImageIcon("chess_blue.png");// load the image to a imageIcon
  public static ImageIcon imageIcon = new ImageIcon("chess.png"); // load the image to a imageIcon
  
  public static Board a = new Board();//test board
  
  public ZeroSum(Board board){
  Dimension boardSize = new Dimension(600, 600);


  //  Use a Layered Pane for this this application
  layeredPane = new JLayeredPane();
  getContentPane().add(layeredPane);
  layeredPane.setPreferredSize(boardSize);
  // layeredPane.addMouseListener(this);
  // layeredPane.addMouseMotionListener(this);

  //Add a chess board to the Layered Pane

  chessBoard = new JPanel();
  layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
  chessBoard.setLayout( new GridLayout(8, 8) );
  chessBoard.setPreferredSize( boardSize );
  chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

  for (int i = 0; i < 64; i++) {
  JPanel square = new JPanel( new BorderLayout() );
  chessBoard.add( square );

  int row = (i / 8) % 2;
  if (row == 0)
  square.setBackground( i % 2 == 0 ? Color.black : Color.white );
  else
  square.setBackground( i % 2 == 0 ? Color.white : Color.black );
  }

  // red chessman

  Image image = imageIcon.getImage(); // transform it
  Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
  imageIcon = new ImageIcon(newimg);  // transform it back

  // blue chessman

  Image image_blue = imageIcon_blue.getImage(); // transform it
  Image newimg_blue = image_blue.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
  imageIcon_blue = new ImageIcon(newimg_blue);  // transform it back

  // adding chessman to the board
  for(int i =  0; i< 16; i++){
    JLabel piece = new JLabel( imageIcon );
    JPanel panel = (JPanel)chessBoard.getComponent(i);
    panel.add(piece);
  }

    for(int i =  48; i< 64; i++){
      JLabel piece = new JLabel( imageIcon_blue );
      JPanel panel = (JPanel)chessBoard.getComponent(i);
      panel.add(piece);
  }



  }
    // mouse operation
 //  public void mousePressed(MouseEvent e){
 //    chessPiece = null;
 //    Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
   
 //    if (c instanceof JPanel) 
 //    return;
   
 //    Point parentLocation = c.getParent().getLocation();
 //    xAdjustment = parentLocation.x - e.getX();
 //    yAdjustment = parentLocation.y - e.getY();
 //    chessPiece = (JLabel)c;
 //    chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
 //    chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
 //    layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
 //  }
 //  //Move the chess piece around
  
 //  public void mouseDragged(MouseEvent me) {
 //    if (chessPiece == null) return;
 //      chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
 // }
 
 //  //Drop the chess piece back onto the chess board
 
 //  public void mouseReleased(MouseEvent e) {
 //    if(chessPiece == null) return;
   
 //    chessPiece.setVisible(false);
 //    Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
   
 //    if (c instanceof JLabel){
 //    Container parent = c.getParent();
 //    parent.remove(0);
 //    parent.add( chessPiece );
 //    }
 //    else {
 //    Container parent = (Container)c;
 //    parent.add( chessPiece );
 //    }
    
 //    chessPiece.setVisible(true);
 //    chessBoard.revalidate();
 //    chessBoard.repaint();

 //    // a = new Board(getCurrBoard());
 //    // System.out.println("before");
 //    // a.printBoard();
    
 //    // int i = 0;
 //    // if(!a.isGoal()){
     
 //    //     a = new Board(ABsearch.getState(a, Board.BLACK, "o2"));
 //    //     testprint(a);
 //    //     System.out.println();
 //    //     System.out.println("after");
 //    //     a.printBoard();

 //    // }
    

 //  }

 //  public void mouseExit(MouseEvent e){
 //    System.out.println("test");
 //  }
 //  public void mouseExited(MouseEvent e){

 //  }
 //  public void mouseEntered(MouseEvent e){

 //  }
 //  public void mouseClicked(MouseEvent e){

 //  }
 //  public void mouseMoved(MouseEvent e){

 //  }
 //  //get the curr boarrd state
 //  // human is black
 //  public static Board getCurrBoard(){
 //    Board board = new Board();
 //    for(int i = 0; i < 8; i++){
 //      for(int j = 0; j < 8; j++){
 //        Component c = chessBoard.findComponentAt((j*75),(i*75));
 //        if(c instanceof JLabel){
 //          JLabel chess = (JLabel)c; 
 //          // human player default white chess
 //          if(chess.getIcon() == imageIcon_blue){
            
 //            board.board[j][i] = new Node(j,i,Board.WHITE);
 //          }
 //          if(chess.getIcon() == imageIcon){
 //            board.board[j][i] = new Node(j,i,Board.BLACK);
 //          }

 //        }
 //      }
 //    }
 //    return board;
 //  }

  public static void selectChess(int x,int y){
    chessPiece = null;
    Component c =  chessBoard.findComponentAt(x, y);

    if (c instanceof JPanel)
    return;

    Point parentLocation = c.getParent().getLocation();
    xAdjustment = parentLocation.x - x;
    yAdjustment = parentLocation.y - y;
    chessPiece = (JLabel)c;
    chessPiece.setLocation(x + xAdjustment, y + yAdjustment);
    chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
    layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
  }

  public static void moveChess(int new_x, int new_y){
     if(chessPiece == null) return;

    chessPiece.setVisible(false);
    Component c =  chessBoard.findComponentAt(new_x, new_y);

    if (c instanceof JLabel){
    Container parent = c.getParent();
    parent.remove(0);
    parent.add( chessPiece );
    }
    else {
    Container parent = (Container)c;
    parent.add( chessPiece );
    }

    chessPiece.setVisible(true);
  }

  public static void testprint(Board board){
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){

        Component currSquare =  chessBoard.findComponentAt((j*75), (i*75));

        // add blue chess

        if(board.board[j][i].value == Board.WHITE ){

          if(currSquare instanceof JLabel){
            JLabel piece = (JLabel) currSquare;
            piece.setIcon(imageIcon_blue);
            chessBoard.revalidate();
            chessBoard.repaint();
          }
          else{
            JLabel piece = new JLabel(imageIcon_blue);
            JPanel panel = (JPanel)chessBoard.getComponent(i*8 + j);
            panel.add(piece);
            chessBoard.revalidate();
            chessBoard.repaint();
          }
        }
        //add red chess
        if(board.board[j][i].value == Board.BLACK){

          if(currSquare instanceof JLabel){

            JLabel piece = (JLabel) currSquare;
            piece.setIcon(imageIcon);
            chessBoard.revalidate();
            chessBoard.repaint();

          }
          else{

            JLabel piece = new JLabel(imageIcon);
            JPanel panel = (JPanel)chessBoard.getComponent(i*8 + j);
            panel.add(piece);
            chessBoard.revalidate();
            chessBoard.repaint();

          }

        }

        if(board.board[j][i].value == '_' && currSquare instanceof JLabel){

            Container parent = currSquare.getParent();
            parent.remove(currSquare);
            chessBoard.revalidate();
            chessBoard.repaint();

        }
      }
    }
  }


  public static void main(String[] args) {

    
    Board a = new Board();

    JFrame frame = new ZeroSum(a);
    frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
    frame.pack();
    frame.setResizable(true);
    frame.setLocationRelativeTo( null );
    frame.setVisible(true);
    frame.setTitle("testestet");
   

    Component currSquare =  chessBoard.findComponentAt(1 * 75, 1*75);
   
    int i = 0;
    while(!a.isGoal()){
      if(i%2 == 0){
        a = new Board(ABsearch.getState(a, Board.WHITE, "o1"));
        testprint(a);
        System.out.println();
        a.printBoard();

      }
      else{
       
        a = new Board(MiniMax.getState(a));
        testprint(a);
        System.out.println();
        a.printBoard();

      }
      i++;
    }
    System.out.println(ABsearch.DEPTH);
    System.out.println(test.MAX_DEPTH);



  }
}



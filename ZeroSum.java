
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
 
public class ZeroSum extends JFrame{
  static JLayeredPane layeredPane;
  static JPanel chessBoard;
  static JLabel chessPiece;
  static int xAdjustment;
  static int yAdjustment;
 
  public ZeroSum(){
  Dimension boardSize = new Dimension(600, 600);
 
  //  Use a Layered Pane for this this application
  layeredPane = new JLayeredPane();
  getContentPane().add(layeredPane);
  layeredPane.setPreferredSize(boardSize);
  layeredPane.addMouseListener(this);
  layeredPane.addMouseMotionListener(this);

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
	  ImageIcon imageIcon = new ImageIcon("chess.png"); // load the image to a imageIcon
	  Image image = imageIcon.getImage(); // transform it
	  Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
	  imageIcon = new ImageIcon(newimg);  // transform it back

	  // blue chessman
	  ImageIcon imageIcon_blue = new ImageIcon("chess_blue.png"); // load the image to a imageIcon
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
 
  public static void main(String[] args) {
	  JFrame frame = new ZeroSum();
	  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
	  frame.pack();
	  frame.setResizable(true);
	  frame.setLocationRelativeTo( null );
	  frame.setVisible(true);
  // Main.test();

 }
}
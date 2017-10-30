import java.util.ArrayList;
import java.util.List;

class Node {

    public int x;//current position for x

    public int y;//current position for y

    public char value; //black 'B' or white 'W'

    public char oValue;

    public boolean hasChess;

    //copy constructor
    public Node(Node other) {
        this.x = other.x;
        this.y = other.y;
        this.value = other.value;
        this.oValue = other.oValue;
    }

    //constructor
    public Node(int x, int y, char value) {
        this.x = x;
        this.y = y;

        this.value = value;

        if(value == Board.WHITE){
            oValue = Board.BLACK;
        }
        else{
            oValue = Board.WHITE;
        }


    }
    //default constructor
    public Node() {
        this.x = x;
        this.y = y;

        this.value = value;
    }


    public boolean equals(Node other) {
        return ((this.x == other.x) && (this.y == other.y) && (this.value == other.value));
    }


}

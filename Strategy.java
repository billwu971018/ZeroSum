import java.lang.Math;
class Strategy{

	public static double defensiveGiven(Board board, char mColor){
		return 2 * board.numRem(mColor) + Math.random();
	}

	public static double offensiveGiven(Board board, char mColor){
		char oColor;
		if(mColor == Board.BLACK){
			oColor = Board.WHITE;
		}
		else{
			oColor = Board.BLACK;
		}
		return 2*(30 - board.numRem(oColor)) + Math.random();
	}

	public static double defensive(Board board, char mColor){
		return -1.0;
	}

	public static double offensive(Board board, char mColor){
		char oColor;
		if(mColor == Board.BLACK){
			oColor = Board.WHITE;
		}
		else{
			oColor = Board.BLACK;
		}
<<<<<<< HEAD
		return 40*(board.numRem(mColor) -1.5 * board.numRem(oColor)) + Math.random() 
		+  1.5* board.maxdistanceScore(mColor) + Math.random();
	}

}
=======
		return board.numRem(mColor) - board.numRem(oColor) + Math.random();
	}

	// public static int chooseStrategy(String myStrategy, Board, ){

	// }
	// public static




}
>>>>>>> 2431b956c0ed93f30b4de42580c62b955a7162b2

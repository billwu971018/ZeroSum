import java.lang.Math;
class Strategy{

	public static double defensiveGiven(Board board, char mColor){
		return 2 * board.numRem(mColor) + Math.random();
	}

	public static double offensiveGiven(Board board, char oColor){
		return 2*(30 - board.numRem(oColor)) + Math.random();
	}

	public static double defensive(Board board, char mColor){
		return -1.0;
	}

	public static double offensive(Board board, char oColor){
		char mColor;
		if(oColor == Board.BLACK){
			mColor = Board.WHITE;
		}
		else{
			mColor = Board.BLACK;
		}
		return 40*(board.numRem(mColor) -1.5 * board.numRem(oColor)) + Math.random() 
		+  1.5* board.maxdistanceScore(mColor) + Math.random();
	}

}
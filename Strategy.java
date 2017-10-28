import java.lang.Math;
class Strategy{

	public static int defensiveGiven(Board board, char mColor){
		return 2 * (board.numRem(mColor)) + Math.radonm();
	}

	public static int offensiveGiven(Board board, char oColor){
		return 2*(30 - board.numRem(oColor)) + random();
	}

	public static int defensive(Board board, char mColor){
		return -1;
	}

	public static int offensive(Board board, char oColor){
		return -1;
	}

	// public static int chooseStrategy(String myStrategy, Board, ){

	// }




}
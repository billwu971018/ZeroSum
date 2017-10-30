import java.lang.Math;
import java.util.*;
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
/**
	public static double defensive(Board board, char mColor){
		return -1.0;
	}
	**/

	public static double offensive(Board board, char mColor, int depth){
		char oColor;
		if(mColor == Board.BLACK){
			oColor = Board.WHITE;
		}
		else{
			oColor = Board.BLACK;
		}
		List<Integer> blackDist = new ArrayList<Integer>();
		List<Integer> whiteDist = new ArrayList<Integer>();
		blackDist = board.getBlackDist();
		whiteDist = board.getWhiteDist();
		int totalMScore = 0;
		if(mColor == Board.BLACK){
		   for(int curr: blackDist){
				 totalMScore = totalMScore + curr * curr;
			 }
	 }
	 else{
		 for(int curr: whiteDist){
			 totalMScore = totalMScore + curr * curr;
		 }
	 }
	 int totalOScore = 0;
	 if(mColor == Board.BLACK){
			for(int curr: whiteDist){
				totalOScore = totalOScore + curr * curr;
			}
	}
	else{
		for(int curr: blackDist){
			totalOScore = totalOScore + curr * curr;
		}
	}
	int maxDist = 0;
	if(mColor == Board.BLACK){
		 Collections.sort(blackDist);
		 Collections.reverse(blackDist);
		 int i = 0;
		 if(!blackDist.isEmpty()){
		 i = blackDist.get(0);
	 }
		 if(i == 6 && depth == 3){
			 //System.out.println("MAXDIST");
			 if(depth == 3)
	 		maxDist = 10000;
	 		if(depth == 2)
	 		maxDist = 1000;
		 }
 }
 else{
	 Collections.sort(whiteDist);
	 Collections.reverse(whiteDist);
	 int i = 0;
	 if(!whiteDist.isEmpty())
	 i = whiteDist.get(0);
	 if(i == 6){
		 //System.out.println("MAXDIST");
		 if(depth == 3)
 		maxDist = 10000;
 		if(depth == 2)
 		maxDist = 1000;
	 }
 }
 int maxDistOp = 0;
 if(mColor == Board.BLACK){
		Collections.sort(whiteDist);
		Collections.reverse(whiteDist);
		int i = 0;
		if(!blackDist.isEmpty()){
		i = blackDist.get(0);
	}
		if(i == 6){
			//System.out.println("MAXDISTOP");
			if(depth == 3)
			maxDist = 10000;
			if(depth == 2)
			maxDist = 1000;
		}
 }
 else{
	Collections.sort(blackDist);
	Collections.reverse(blackDist);
	int i = 0;
	if(!whiteDist.isEmpty())
	i = whiteDist.get(0);
	if(i == 6){
		//System.out.println("MAXDISTOP");
		if(depth == 3)
		maxDist = 10000;
		if(depth == 2)
		maxDist = 1000;
	}
 }
    double retval = 20 * (board.numRem(mColor) - 1.5 * board.numRem(oColor)) + 1.5 * totalMScore - totalOScore + 100 * maxDist - 50 * maxDistOp + Math.random();
		//System.out.println("totalMScore : " + totalMScore);
		//System.out.println("totalOScore : " + totalOScore);
		//System.out.println("o2 score : " + retval);
		return retval;
	}

	public static double defensive(Board board, char mColor, int depth){
		char oColor;
		if(mColor == Board.BLACK){
			oColor = Board.WHITE;
		}
		else{
			oColor = Board.BLACK;
		}
		List<Integer> blackDist = new ArrayList<Integer>();
		List<Integer> whiteDist = new ArrayList<Integer>();
		blackDist = board.getBlackDist();
		whiteDist = board.getWhiteDist();
		int totalMScore = 0;
		if(mColor == Board.BLACK){
		   for(int curr: blackDist){
				 totalMScore = totalMScore + curr * curr;
			 }
	 }
	 else{
		 for(int curr: whiteDist){
			 totalMScore = totalMScore + curr * curr;
		 }
	 }
	 int totalOScore = 0;
	 if(mColor == Board.BLACK){
			for(int curr: whiteDist){
				totalOScore = totalOScore + curr * curr;
			}
	}
	else{
		for(int curr: blackDist){
			totalOScore = totalOScore + curr * curr;
		}
	}
	int maxDist = 0;
	if(mColor == Board.BLACK){
		 Collections.sort(blackDist);
		 Collections.reverse(blackDist);
		 int i = 0;
		 if(!blackDist.isEmpty()){
		 i = blackDist.get(0);
	 }
		 if(i == 6 && depth == 3){
			 //System.out.println("MAXDIST");
			 if(depth == 3)
	 		maxDist = 10000;
	 		if(depth == 2)
	 		maxDist = 1000;
		 }
 }
 else{
	 Collections.sort(whiteDist);
	 Collections.reverse(whiteDist);
	 int i = 0;
	 if(!whiteDist.isEmpty())
	 i = whiteDist.get(0);
	 if(i == 6){
		 //System.out.println("MAXDIST");
		 if(depth == 3)
 		maxDist = 10000;
 		if(depth == 2)
 		maxDist = 1000;
	 }
 }
 int maxDistOp = 0;
 if(mColor == Board.BLACK){
		Collections.sort(whiteDist);
		Collections.reverse(whiteDist);
		int i = 0;
		if(!blackDist.isEmpty()){
		i = blackDist.get(0);
	}
		if(i == 6){
			//System.out.println("MAXDISTOP");
			if(depth == 3)
			maxDist = 10000;
			if(depth == 2)
			maxDist = 1000;
		}
 }
 else{
	Collections.sort(blackDist);
	Collections.reverse(blackDist);
	int i = 0;
	if(!whiteDist.isEmpty())
	i = whiteDist.get(0);
	if(i == 6){
		//System.out.println("MAXDISTOP");
		if(depth == 3)
		maxDist = 10000;
		if(depth == 2)
		maxDist = 1000;
	}
 }
    double retval = 30 * (3 * board.numRem(mColor) - board.numRem(oColor)) + totalMScore - 1.5 * totalOScore + 50 * maxDist - 100 * maxDistOp + Math.random();
		//System.out.println("totalMScore : " + totalMScore);
		//System.out.println("totalOScore : " + totalOScore);
		//System.out.println("o2 score : " + retval);
		return retval;
	}

	// public static int chooseStrategy(String myStrategy, Board, ){

	// }
	// public static




}

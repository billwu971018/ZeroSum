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


	public static double offensive(Board board, char mColor, int depth){

		char oColor;//opponent color
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

		int totalMScore = 0;//my distance score
		int totalOScore = 0;//opponent distance score

		if(mColor == Board.BLACK){
			for(int curr: blackDist){
				totalMScore += curr * curr;
			}
			for(int curr:whiteDist){
				totalOScore += curr * curr;
				}
		 	}
		else{
			for(int curr: whiteDist){
				totalMScore += curr * curr;
			}
			 for(int curr : blackDist){
			 	totalOScore += curr * curr;
			}
		}

		int maxDist = 0; // my max distance to goal state
		int maxDistOp = 0;// my opponent max distance to goal state

		if(mColor == Board.BLACK){

			int winStep = 0;
			if(!blackDist.isEmpty()){
			 	winStep = Collections.max(blackDist);
			}

			if(winStep == 6){
				// winning step only from 6
				if(depth == 3) maxDist = 10000;
		 		if(depth == 2) maxDist = 1000;

			 }

			 //my opponent score
			int owinStep = 0;
		 	if(!whiteDist.isEmpty()){
		 		owinStep = Collections.max(whiteDist);
		 	}
		 	if( owinStep == 6 ){
		 	    if(depth == 3) maxDistOp = 10000;
		 	    if(depth == 2) maxDistOp = 1000;
		 	}
	 	}

		else{

			int winStep = 0;
			if(!whiteDist.isEmpty()) {
			 	winStep = Collections.max(whiteDist);
			}
			if(winStep == 6){
				if(depth == 3) maxDist = 10000;
		 		if(depth == 2) maxDist = 1000;
		 	}
		 	//my opponent score
		 	int owinStep = 0;
		 	if(!blackDist.isEmpty()){
		 		owinStep = Collections.max(blackDist);
		 	}
		 	if( owinStep == 6 ){
		 	    if(depth == 3) maxDistOp = 10000;
		 	    if(depth == 2) maxDistOp = 1000;
		 	}

	 	}

    	double retval = 20 * (board.numRem(mColor) - 1.5 * board.numRem(oColor)) + 1.5 * totalMScore - totalOScore + 100 * maxDist - 50 * maxDistOp + Math.random();
		//System.out.println("totalMScore : " + totalMScore);
		//System.out.println("totalOScore : " + totalOScore);
		System.out.println("o2 score : " + retval);
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

		int totalMScore = 0;//my distance score
		int totalOScore = 0;//opponent distance score

		if(mColor == Board.BLACK){
			for(int curr: blackDist){
				totalMScore += curr * curr;
			}
			for(int curr:whiteDist){
				totalOScore += curr * curr;
				}
		 	}
		else{
			for(int curr: whiteDist){
				totalMScore += curr * curr;
			 }
			 for(int curr : blackDist){
			 	totalOScore += curr * curr;
			 }
		}

		int maxDist = 0; // my max distance to goal state
		int maxDistOp = 0;// my opponent max distance to goal state

		if(mColor == Board.BLACK){

			int winStep = 0;
			if(!blackDist.isEmpty()){
			 	winStep = Collections.max(blackDist);
			}

			if(winStep == 6){
				// winning step only from 6
				if(depth == 3) maxDist = 10000;
		 		if(depth == 2) maxDist = 1000;

			 }

			 //my opponent score
			int owinStep = 0;
		 	if(!whiteDist.isEmpty()){
		 		owinStep = Collections.max(whiteDist);
		 	}
		 	if( owinStep == 6 ){
		 	    if(depth == 3) maxDistOp = 10000;
		 	    if(depth == 2) maxDistOp = 1000;
		 	}
	 	}

		else{

			int winStep = 0;
			if(!whiteDist.isEmpty()) {
			 	winStep = Collections.max(whiteDist);
			}
			if(winStep == 6){
				if(depth == 3) maxDist = 10000;
		 		if(depth == 2) maxDist = 1000;
		 	}
		 	//my opponent score
		 	int owinStep = 0;
		 	if(!blackDist.isEmpty()){
		 		owinStep = Collections.max(blackDist);
		 	}
		 	if( owinStep == 6 ){
		 	    if(depth == 3) maxDistOp = 10000;
		 	    if(depth == 2) maxDistOp = 1000;
		 	}

	 	}


	    double retval = 30 * (6 * board.numRem(mColor) - board.numRem(oColor)) + totalMScore - 1.5 * totalOScore + 50 * maxDist - 100 * maxDistOp + Math.random();
			//System.out.println("totalMScore : " + totalMScore);
			//System.out.println("totalOScore : " + totalOScore);
			//System.out.println("o2 score : " + retval);
		return retval;
	}


}

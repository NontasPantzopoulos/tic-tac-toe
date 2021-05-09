package main.tictactoe.ai;

import java.util.ArrayList;

import main.tictactoe.model.Board;
import main.tictactoe.model.enums.Signs;

public class BestMove {
	
	private BestMove() {
		
	}
	
	public static int[] getBestMove(Board board,Signs sign) {
		int[] bestMove = new int[]{-1, -1};
		Board b = board.getDeepCopy();
		
		Signs opponent;
		if(sign==Signs.X) {
			opponent=Signs.O;
		}else {
			opponent=Signs.X;
		}
		int bestScore=Integer.MIN_VALUE;
		int bchildScore = Integer.MIN_VALUE;
		
		bestScore=best(b,sign);
		ArrayList<Integer> listOfMoves = new ArrayList<>();
		//System.out.println("Best:"+best(b,opponent));
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				if(b.getBoard()[row][col]==Signs.EMPTY.toString()) {
					Board bchild = b.getDeepCopy();
					
					bchild.setSign(row, col, sign);
					
					if(best(bchild,sign)==bestScore) {
						listOfMoves.add(row);
						listOfMoves.add(col);
					}
					
					b.setSign(row, col, Signs.EMPTY);
				}
			}
		}
		
		System.out.println(listOfMoves);
		
		for(int i=0;i<listOfMoves.size();i=i+2) {
			
		}
		
		
		return bestMove;
	}
	
	private static int best(Board board,Signs sign) {
		if(board.getNumOfFullCells()==9 || board.isWin(sign.toString())) {
			return score(board,sign);
		}
		int bestScore = Integer.MIN_VALUE;
		Board newboard = board.getDeepCopy();
		Signs opponent;
		if(sign==Signs.X) {
			opponent=Signs.O;
		}else {
			opponent=Signs.X;
		}
//		System.out.println("Best New board"+newboard);
	
		for(int row=0;row<3;row++) {
			for (int col=0;col<3;col++) {
				if(newboard.getBoard()[row][col]==Signs.EMPTY.toString()) {
					newboard.setSign(row, col, sign);
					
					bestScore = Math.max(score(newboard,sign),(-1*best(newboard.getDeepCopy(),opponent)) );
					System.out.println("MyBestscore:"+bestScore);
					newboard.setSign(row, col, Signs.EMPTY);
				}
			}
		}
		
		
		
		return bestScore;
	}

	private static int score (Board board,Signs sign) {
		//System.out.println(board.toString()+sign.toString());
        if (sign == Signs.X && board.isValid() && board.isWin(Signs.X.toString())) {
        	//System.out.println(1);
            return 1;
        } else if (sign == Signs.X && board.isValid() && board.isWin(Signs.O.toString())) {
        	//System.out.println(-1);
            return -1;
        }else if (sign == Signs.O && board.isValid() && board.isWin(Signs.O.toString())){
        	//System.out.println(1);
        	return 1;
        	
        }else if(sign == Signs.O && board.isValid() && board.isWin(Signs.X.toString())) {
   	
        	//System.out.println(-1);
            return -1;
        }else {
        	//System.out.println(0);
        	return 0;
        }
    }
}

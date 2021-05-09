package main.tictactoe.ai;

import main.tictactoe.model.Board;
import main.tictactoe.model.enums.Signs;

public class AlphaBetaPruning {
	
	private static int maxDepth=9;

	private AlphaBetaPruning() {
		
	}
	
	public static int[] bestMove(Board board, Signs sign,int depth)  {
		int[] bestMove = new int[]{-1, -1};
		int bestValue=Integer.MIN_VALUE;
		Board newBoard = board.getDeepCopy();
		
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {			
				if(newBoard.getBoard()[row][col]==Signs.EMPTY.toString()) {
					newBoard.setSign(row, col, sign);
					
					int moveValue =alphaBetaPruning(sign,newBoard, Integer.MIN_VALUE, Integer.MAX_VALUE, depth);
					newBoard.setSign(row, col, Signs.EMPTY);
					if(moveValue>bestValue) {
						System.out.println(moveValue);
						bestMove[0] = row;
                        bestMove[1] = col;
                        bestValue = moveValue;
					}
				}
			}
		}
		
		return bestMove;
	}
	
	private static int alphaBetaPruning( Signs sign,Board board, int alpha, int beta, int depth) {
		System.out.println("ab"+alpha+" "+beta);
		
		Board myBoard = board.getDeepCopy();
		if (depth++ == maxDepth) {
            return score(sign, board);
        }
		
		if(sign==Signs.X) {
			int max = getMax( myBoard, alpha, beta, depth);
			System.out.println(max);
			
			return max;
		}else {
			int min= getMin( myBoard, alpha, beta, depth);
			System.out.println(min);
			
			return min;
			
		}
		
	}
	
	private static int getMax(Board board,int alpha,int beta,int currentDepth) {
		int highestVal = Integer.MIN_VALUE;
		Board newBoard = board.getDeepCopy();
		
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {			
				if(newBoard.getBoard()[row][col]==Signs.EMPTY.toString()) {
					newBoard.setSign(row, col, Signs.X);
					
					highestVal = Math.max(highestVal, alphaBetaPruning(Signs.O,newBoard, alpha, beta, currentDepth));
					newBoard.setSign(row, col, Signs.EMPTY);
					alpha = Math.max(alpha, highestVal);
                    if (alpha >= beta) {
                    	System.out.println("max:"+highestVal);
                        return highestVal;
                    }
				}
			}
		}
    	System.out.println("max:"+highestVal);

		return highestVal;
	}
	
	private static int getMin(Board board,int alpha,int beta,int currentDepth) {
		int lowestVal = Integer.MAX_VALUE;
		Board newBoard = board.getDeepCopy();
		
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {			
				if(newBoard.getBoard()[row][col]==Signs.EMPTY.toString()) {
					newBoard.setSign(row, col, Signs.O);
					
					lowestVal = Math.min(lowestVal,alphaBetaPruning(Signs.X,newBoard, alpha, beta, currentDepth));
					newBoard.setSign(row, col, Signs.EMPTY);
					beta = Math.min(beta, lowestVal);
                    if (beta <= alpha) {
                    	System.out.println("min:"+lowestVal);
                        return lowestVal;
                    }
				}
			}
		}
		
		System.out.println("min:"+lowestVal);
		return lowestVal;
	}
	
	
	private static int score (Signs sign,Board board) {
		System.out.println(board.toString());
        if (sign == Signs.X && board.isValid() && board.isWin(Signs.X.toString())) {
        	//System.out.println(1);
            return 1;
        } else if (sign == Signs.X && board.isValid() && board.isWin(Signs.O.toString())) {
        	//System.out.println(-1);
            return -1;
        }else if (sign == Signs.O && board.isValid() && board.isWin(Signs.O.toString())){
        	return 1;
        	
        }else if(sign == Signs.O && board.isValid() && board.isWin(Signs.X.toString())) {
   	
        	//System.out.println(0);
            return -1;
        }else {
        	return 0;
        }
    }
	
	

}

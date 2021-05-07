package main.tictactoe.ai;

import main.tictactoe.model.Board;
import main.tictactoe.model.enums.Signs;

public class AlphaBetaPruning {
	
	private static int maxDepth=8;

	private AlphaBetaPruning() {
		
	}
	
	public static int[] bestMove(Board board, Signs sign,int depth) throws CloneNotSupportedException {
		int[] bestMove = new int[]{-1, -1};
		int bestValue=Integer.MIN_VALUE;
		Board newBoard = (Board) board.clone();
		
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {			
				if(newBoard.getBoard()[row][col]==Signs.EMPTY.toString()) {
					newBoard.getBoard()[row][col]=sign.toString();
					
					int moveValue =alphaBetaPruning(sign,newBoard, Integer.MIN_VALUE, Integer.MAX_VALUE, depth);
					if(moveValue>bestValue) {
						bestMove[0] = row;
                        bestMove[1] = col;
                        bestValue = moveValue;
					}
				}
			}
		}
		
		return bestMove;
	}
	
	private static int alphaBetaPruning(Signs sign, Board board, int alpha, int beta, int depth) {
		
		if (depth++ == maxDepth || board.getNumOfFullCells()==9) {
            return score(sign,board);
        }
		try {
		if(sign==Signs.X) {
			
				return getMax(sign, board, alpha, beta, depth);
			
		}else {
			
				return getMin(sign, board, alpha, beta, depth);
			
		}
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return score(sign,board);
		}
	}
	
	private static int getMax(Signs sign,Board board,int alpha,int beta,int currentDepth) throws CloneNotSupportedException {
		int highestVal = Integer.MIN_VALUE;
		Board newBoard = (Board) board.clone();
		
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {			
				if(newBoard.getBoard()[row][col]==Signs.EMPTY.toString()) {
					newBoard.getBoard()[row][col]=sign.toString();
					
					highestVal = Math.max(highestVal, alphaBetaPruning(sign, newBoard, alpha, beta, currentDepth));
					alpha = Math.max(alpha, highestVal);
                    if (alpha >= beta) {
                        return highestVal;
                    }
				}
			}
		}
		return highestVal;
	}
	
	private static int getMin(Signs sign,Board board,int alpha,int beta,int currentDepth) throws CloneNotSupportedException {
		int lowestVal = Integer.MAX_VALUE;
		Board newBoard = (Board) board.clone();
		
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {			
				if(newBoard.getBoard()[row][col]==Signs.EMPTY.toString()) {
					newBoard.getBoard()[row][col]=sign.toString();
					
					lowestVal = Math.min(lowestVal,alphaBetaPruning(sign, newBoard, alpha, beta, currentDepth));
					beta = Math.min(beta, lowestVal);
                    if (beta <= alpha) {
                        return lowestVal;
                    }
				}
			}
		}
		
		
		return lowestVal;
	}
	
	
	private static int score (Signs sign, Board board) {
		//System.out.println(board.toString());
        if (sign == null) {
            throw new IllegalArgumentException("Sign must not be null");
        }
        if (sign==Signs.X && board.isWin(Signs.X.toString())) {
        	//System.out.println(1);
            return 10;
        } else if (sign==Signs.X && board.isWin(Signs.O.toString())) {
        	//System.out.println(-1);
            return -10;
        } else if(sign==Signs.O && board.isWin(Signs.O.toString())) {
        	//System.out.println(1);
        	return 10;
        }else if (sign==Signs.O && board.isWin(Signs.X.toString())) {
        	//System.out.println(-1);
        	return -10;
        }else {
        	//System.out.println(0);
            return 0;
        }
    }
	
	

}

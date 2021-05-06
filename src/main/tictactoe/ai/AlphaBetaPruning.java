package main.tictactoe.ai;

import main.tictactoe.model.Board;
import main.tictactoe.model.enums.Signs;

public class AlphaBetaPruning {
	
	private static int maxDepth=9;

	private AlphaBetaPruning() {
		
	}
	
	public static int[] alphaBetaPruning(String typeOfPlayer,Signs sign, Board board, int alpha, int beta, int depth) {
		int[] bestMove = new int[2];
		if (depth++ == maxDepth || board.getNumOfFullCells()==9 || board.isWin(Signs.X.toString()) || board.isWin(Signs.O.toString())) {
            return bestMove;
        }
		
		if(typeOfPlayer.equals("computer")) {
			int score = getMax("human",sign, board, alpha, beta, depth);
		}else {
			
		}
		
		return bestMove;
	}
	
	private static int getMax(String typeOfPlayer,Signs sign,Board board,int alpha,int beta,int currentDepth) {
		
		
		return 0;
	}
	
	private static int getMin(String typeOfPlayer,Signs sign,Board board,int alpha,int beta,int currentDepth) {
		
		
		
		return 0;
	}
	
	
	private static int score (Signs sign, Board board) {
		System.out.println(board.toString());
        if (sign == null) {
            throw new IllegalArgumentException("Sign must not be null");
        }
        if (sign==Signs.X && board.isWin(Signs.X.toString())) {
        	System.out.println(1);
            return 1;
        } else if (sign==Signs.X && board.isWin(Signs.O.toString())) {
        	System.out.println(-1);
            return -1;
        } else if(sign==Signs.O && board.isWin(Signs.O.toString())) {
        	System.out.println(1);
        	return 1;
        }else if (sign==Signs.O && board.isWin(Signs.X.toString())) {
        	System.out.println(-1);
        	return -1;
        }else {
        	System.out.println(0);
            return 0;
        }
    }
	
	

}

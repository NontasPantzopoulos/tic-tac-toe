package main.tictactoe.ai;


import main.tictactoe.model.Board;
import main.tictactoe.model.enums.Signs;

public class AlphaBetaPruning {
	
	private static int MAX_DEPTH=9;

	private AlphaBetaPruning() {
		
	}
	
	/**
	 * Play moves on the board alternating between playing as X and O analysing 
     * the board each time to return the value of the highest value move for the
     * player. Use variables alpha and beta as the best alternative for the 
     * maximising player (sign) and the best alternative for the minimising player 
     * (opponent) respectively, do not search descendants of nodes if player's 
     * alternatives are better than the node. Return the highest value move when 
     * a terminal node or the maximum search depth is reached.
	 * @param sign The enum value of X or O depending the side of the player
	 * @param board Board to play on and evaluate
	 * @param depth The maximum depth of the game tree to search to
	 * @param alpha The best alternative for the maximising player
	 * @param beta The best alternative for the minimising player
	 * @param isMax Maximising or minimising player
	 * @return Value of the board
	 */
    public static int miniMax(Signs sign,Board board, int depth, int alpha, int beta,
            boolean isMax) {
        int boardVal = evaluateBoard(board,sign);

        // Terminal node (win/lose/draw) or max depth reached.
        if (Math.abs(boardVal) == 1 || depth == 0 
                || board.getNumOfFullCells()==9 || board.isWin(sign.toString())) {
            return boardVal;
        }
        Signs opponent;
		if(sign==Signs.X) {
			opponent=Signs.O;
		}else {
			opponent=Signs.X;
		}

        // Maximising player, find the maximum attainable value.
        if (isMax) {
            int highestVal = Integer.MIN_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board.getBoard()[row][col]==Signs.EMPTY.toString()) {
                        board.setSign(row, col, sign);
                        highestVal = Math.max(highestVal, miniMax(sign,board,
                                depth - 1, alpha, beta, false));
                        board.setSign(row, col, Signs.EMPTY);
                        alpha = Math.max(alpha, highestVal);
                        if (alpha >= beta) {
                            return highestVal;
                        }
                    }
                }
            }
            return highestVal;
            // Minimising player, find the minimum attainable value;
        } else {
            int lowestVal = Integer.MAX_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board.getBoard()[row][col]==Signs.EMPTY.toString()) {
                        board.setSign(row, col, opponent);
                        lowestVal = Math.min(lowestVal, miniMax(sign,board,
                                depth - 1, alpha, beta, true));
                        board.setSign(row, col, Signs.EMPTY);
                        beta = Math.min(beta, lowestVal);
                        if (beta <= alpha) {
                            return lowestVal;
                        }
                    }
                }
            }
            return lowestVal;
        }
    }

    /**
     * Evaluate every legal move on the board and return the best one.
     * @param board Board to evaluate
     * @return Coordinates of best move
     */
    public static int[] getBestMove(Board board,Signs sign) {
        int[] bestMove = new int[]{-1, -1};
        int bestValue = Integer.MIN_VALUE;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getDeepCopy().getBoard()[row][col]==Signs.EMPTY.toString()) {
                	board.setSign(row, col, sign);
                    int moveValue = miniMax(sign,board, MAX_DEPTH, Integer.MIN_VALUE,
                            Integer.MAX_VALUE, false);
                    board.setSign(row, col, Signs.EMPTY);
                    if (moveValue > bestValue) {
                        bestMove[0] = row;
                        bestMove[1] = col;
                        bestValue = moveValue;
                    }
                }
            }
        }
        return bestMove;
    }

    /**
     * Evaluate the given board from the perspective of the X player, return 
     * 1 if a winning board configuration is found, -1 for a losing one and 0 
     * for a draw.
     * @param board Board to evaluate
     * @return value of the board
     */
    private static int evaluateBoard (Board board,Signs sign) {
//		System.out.println(board.toString());
        if (sign == Signs.X && board.isValid() && board.isWin(Signs.X.toString())) {
//        	System.out.println("X is Winner");
            return 1;
        } else if (sign == Signs.X && board.isValid() && board.isWin(Signs.O.toString())) {
//        	System.out.println("O is Winner X is a looser");
            return -1;
        }else if (sign == Signs.O && board.isValid() && board.isWin(Signs.O.toString())){
//        	System.out.println("O is Winner");
        	return 1;  	
        }else if(sign == Signs.O && board.isValid() && board.isWin(Signs.X.toString())) {
//        	System.out.println("X is Winner O is a looser");
            return -1;
        }else {
//        	System.out.println("draw\n\n");
        	return 0;
        }
    }
}

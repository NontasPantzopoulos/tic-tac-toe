package main.tictactoe.model;

import main.tictactoe.model.enums.Signs;
import main.tictactoe.utils.GeneralUtils;

public class PlayerAI implements Runnable{
	private GameEngine ge;
	private int maxPly =8;
	private Signs sign;
	private Player player;
	private boolean play=true;
	private static final long SLEEP_TIME=200;
	
	

	public PlayerAI(GameEngine ge) {
		this.ge = ge;
	}



	@Override
	public void run() {
		GeneralUtils.log("PlayerAI", "Thread started...");
		try {
			aiMoves();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		GeneralUtils.log("PlayerAI", "Thread ended...");
		
	}
	
	private void aiMoves() throws InterruptedException  {
		while(play) {
			if(ge.isGameActive()) {
				//System.out.println(ge.getTurnSign());
				if(ge.getPlayerX().getName().equals("Hal")) {
					this.player = ge.getPlayerX();
					this.sign = Signs.X;
//					alphaBetaPruning(this.sign, this.player, ge.getBoard()[ge.getMoves()], Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, ge.getMoves());
					if(ge.getMoves()==0) {
						alphaBetaPruning(this.sign, ge.getBoard()[ge.getMoves()], Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0);
					}else {
						alphaBetaPruning(this.sign, ge.getBoard()[ge.getMoves()-1], Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, ge.getMoves()-1);
					}
					
					
				}	
				else if(ge.getPlayerO().getName().equals("Hal")) {
					this.player = ge.getPlayerO();
					this.sign = Signs.O;
//					alphaBetaPruning(this.sign, this.player, ge.getBoard()[ge.getMoves()], Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, ge.getMoves());
					if(ge.getMoves()==0) {
						alphaBetaPruning(this.sign, ge.getBoard()[ge.getMoves()], Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0);
					}else {
						alphaBetaPruning(this.sign, ge.getBoard()[ge.getMoves()-1], Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, ge.getMoves()-1);
					}
				}
				
				
				
				
				
				Thread.sleep(SLEEP_TIME);
			}
			
			
			
			
			Thread.sleep(SLEEP_TIME);
		}
	}
	
	
	private int alphaBetaPruning (Signs sign, Board board, double alpha, double beta, int currentPly) {
		GeneralUtils.log("PlayerAI", " alphabeta "+currentPly+" alpha:"+alpha+" beta:"+beta);
        if (currentPly++ == maxPly || !ge.isGameActive()) {
            return score(player, board);
        }

        if (ge.getTurnSign()==sign) {
//        	System.out.println("Max");
//        	return 1;
            return getMax(sign, player, board, alpha, beta, currentPly);
        }else {
//        	System.out.println("Min");
//        	return -1;
            return getMin(sign, player, board, alpha, beta, currentPly);
        }
    }
	
	private int getMax (Signs sign, Player player, Board board, double alpha, double beta, int currentPly) {
//        int indexOfBestMove = -1;
        int bestRow = -1;
        int bestCol = -1;
        String[][] modifiedBoardValues = new String[3][3];
        Board modifiedBoard;
        
        for(int row=0;row<3;row++) {
        	for (int col=0;col<3;col++) {
        		if(board.getBoard()[row][col]==Signs.O.toString()) {
        			modifiedBoardValues[row][col]=Signs.O.toString();
        			continue;
        		}
        		if(board.getBoard()[row][col]==Signs.X.toString()) {
        			modifiedBoardValues[row][col]=Signs.X.toString();
        			continue;
        		}
        		if(board.getBoard()[row][col]==Signs.EMPTY.toString()) {
        			modifiedBoardValues[row][col]=sign.toString();
        			modifiedBoard = new Board(modifiedBoardValues);
        			int score = alphaBetaPruning(sign, modifiedBoard, alpha, beta, currentPly);
        			if (score > alpha) {
                      alpha = score;
                      bestRow = row;
                      bestCol = col;
                      GeneralUtils.log("PlayerAI", "getMax "+row+","+col);
        			}
                    if (alpha >= beta) {
                        break;
                    }
//        			break;
        		}
        	}
        }
        if (bestRow!=-1 || bestCol!=-1) {
            ge.makeMove(bestRow, bestCol);
        }
        return (int)alpha;
        

//        for (Integer theMove : board.getAvailableMoves()) {
//
//            Board modifiedBoard = board.getDeepCopy();
//            modifiedBoard.move(theMove);
//            int score = alphaBetaPruning(player, modifiedBoard, alpha, beta, currentPly);
//
//            if (score > alpha) {
//                alpha = score;
//                indexOfBestMove = theMove;
//            }
//
//            // Pruning.
//            if (alpha >= beta) {
//                break;
//            }
//        }
//
        
    }
	
	private  int getMin (Signs sign,Player player, Board board, double alpha, double beta, int currentPly) {
//        int indexOfBestMove = -1;
        int bestRow = -1;
        int bestCol = -1;
        String[][] modifiedBoardValues = new String[3][3];
        Board modifiedBoard;
        
        for(int row=0;row<3;row++) {
        	for (int col=0;col<3;col++) {
        		if(board.getBoard()[row][col]==Signs.O.toString()) {
        			modifiedBoardValues[row][col]=Signs.O.toString();
        			continue;
        		}
        		if(board.getBoard()[row][col]==Signs.X.toString()) {
        			modifiedBoardValues[row][col]=Signs.X.toString();
        			continue;
        		}
        		if(board.getBoard()[row][col]==Signs.EMPTY.toString()) {
        			modifiedBoardValues[row][col]=sign.toString();
        			modifiedBoard = new Board(modifiedBoardValues);
        			int score = alphaBetaPruning(sign, modifiedBoard, alpha, beta, currentPly);
        			if (score < beta) {
                      beta = score;
                      bestRow = row;
                      bestCol = col;
                      GeneralUtils.log("PlayerAI", "getMin "+row+","+col);
        			}
                    if (alpha >= beta) {
                        break;
                    }
//        			break;
        		}
        	}
        }
        if (bestRow!=-1 || bestCol!=-1) {
            //ge.makeMove(bestRow, bestCol);
        }
        return (int)beta;
        
        
//        for (Integer theMove : board.getAvailableMoves()) {
//
//            Board modifiedBoard = board.getDeepCopy();
//            modifiedBoard.move(theMove);
//
//            int score = alphaBetaPruning(player, modifiedBoard, alpha, beta, currentPly);
//
//            if (score < beta) {
//                beta = score;
//                indexOfBestMove = theMove;
//            }
//
//            // Pruning.
//            if (alpha >= beta) {
//                break;
//            }
//        }
//
//        if (indexOfBestMove != -1) {
//            board.move(indexOfBestMove);
//        }
        
    }
	
	
	
	private int score (Player player, Board board) {
		System.out.println(board.toString());
        if (player == null) {
            throw new IllegalArgumentException("Player not be null");
        }
        if (this.sign==Signs.X && board.isWin(Signs.X.toString())) {
        	System.out.println(1);
            return 1;
        } else if (this.sign==Signs.X && board.isWin(Signs.O.toString())) {
        	System.out.println(-1);
            return -1;
        } else if(this.sign==Signs.O && board.isWin(Signs.O.toString())) {
        	System.out.println(1);
        	return 1;
        }else if (this.sign==Signs.O && board.isWin(Signs.X.toString())) {
        	System.out.println(-1);
        	return -1;
        }else {
        	System.out.println(0);
            return 0;
        }
    }

}

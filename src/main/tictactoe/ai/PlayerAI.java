package main.tictactoe.ai;

import main.tictactoe.model.GameEngine;
import main.tictactoe.model.enums.Signs;
import main.tictactoe.utils.GeneralUtils;

/**
 * The AI thread class
 * It checks if it is his turn every 500 milliseconds 
 * and depending on the side it plays accordingly.
 * The AI is using the alpha beta pruning algorithm. 
 * 
 */
public class PlayerAI implements Runnable{
	private GameEngine ge;
	
	private Signs sign;
	private boolean play=true;
	private static final long SLEEP_TIME=500;
	private int [] aiMove;
	
	

	public PlayerAI(GameEngine ge) {
		this.ge = ge;
		this.aiMove=new int[] {-1,-1};
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
				if(ge.getPlayerX().getName().equals("Hal") && ge.getSign()==Signs.X.toString() && ge.isGameActive()) {
					
					this.sign = Signs.X;
					if(ge.getMoves()==0) {
											
						this.aiMove = AlphaBetaPruning.getBestMove(ge.getBoard()[0].getDeepCopy(), sign);
						if(aiMove[0]!=-1 || aiMove[1]!=-1) {
							System.out.println("AI:"+aiMove[0]+","+aiMove[1]);
							ge.makeMove(aiMove[0], aiMove[1]);
						}
					}else {

						this.aiMove = AlphaBetaPruning.getBestMove(ge.getBoard()[ge.getMoves()-1].getDeepCopy(), sign);
						if(aiMove[0]!=-1 || aiMove[1]!=-1) {
							System.out.println("AI:"+aiMove[0]+","+aiMove[1]);
							ge.makeMove(aiMove[0], aiMove[1]);
						}
					}	
				}	
				else if(ge.getPlayerO().getName().equals("Hal") && ge.getSign()==Signs.O.toString() && ge.isGameActive()) {
					this.sign = Signs.O;
					if(ge.getMoves()==0) {		
						
						this.aiMove = AlphaBetaPruning.getBestMove(ge.getBoard()[0].getDeepCopy(), sign);
						if(aiMove[0]!=-1 || aiMove[1]!=-1) {
							System.out.println("AI:"+aiMove[0]+","+aiMove[1]);
							ge.makeMove(aiMove[0], aiMove[1]);
						}
					}else {
						
						this.aiMove = AlphaBetaPruning.getBestMove(ge.getBoard()[ge.getMoves()-1].getDeepCopy(), sign);
						if(aiMove[0]!=-1 || aiMove[1]!=-1) {
							System.out.println("AI:"+aiMove[0]+","+aiMove[1]);
							ge.makeMove(aiMove[0], aiMove[1]);
						}
					}
					
				}else {
					
					System.out.println("AI not my turn:"+aiMove[0]+","+aiMove[1]);
				}
				Thread.sleep(SLEEP_TIME);
			}
			
			Thread.sleep(SLEEP_TIME);
		}
	}

}

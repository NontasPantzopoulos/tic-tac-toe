package main.tictactoe.ai;

import main.tictactoe.model.Board;
import main.tictactoe.model.GameEngine;
import main.tictactoe.model.Player;
import main.tictactoe.model.enums.Signs;
import main.tictactoe.utils.GeneralUtils;

public class PlayerAI implements Runnable{
	private GameEngine ge;
	
	private Signs sign;
	private boolean play=true;
	private static final long SLEEP_TIME=1000;
	private int [] aiMove;
	
	

	public PlayerAI(GameEngine ge) {
		this.ge = ge;
		this.aiMove=new int[] {-1,-1};
	}



	@Override
	public void run() {
		GeneralUtils.log("PlayerAI", "Thread started...");
		try {
			//ge.setGameActive(true);
			aiMoves();
		} catch (InterruptedException | CloneNotSupportedException e) {
			e.printStackTrace();
		}
		GeneralUtils.log("PlayerAI", "Thread ended...");
		
	}
	
	private void aiMoves() throws InterruptedException, CloneNotSupportedException  {
		while(play) {
			
			
			if(ge.isGameActive()) {
				if(ge.getPlayerX().getName().equals("Hal") && ge.getSign()==Signs.X.toString() && ge.isGameActive()) {
					
					this.sign = Signs.X;
					if(ge.getMoves()==0) {
											
						this.aiMove = MiniMax.getBestMove(ge.getBoard()[0].getDeepCopy(), Signs.X);
						if(aiMove[0]!=-1 || aiMove[1]!=-1) {
							System.out.println("AI:"+aiMove[0]+","+aiMove[1]);
							ge.makeMove(aiMove[0], aiMove[1]);
						}
					}else {

						this.aiMove = MiniMax.getBestMove(ge.getBoard()[ge.getMoves()-1].getDeepCopy(), Signs.X);
						if(aiMove[0]!=-1 || aiMove[1]!=-1) {
							System.out.println("AI:"+aiMove[0]+","+aiMove[1]);
							ge.makeMove(aiMove[0], aiMove[1]);
						}
					}	
				}	
				else if(ge.getPlayerO().getName().equals("Hal") && ge.getSign()==Signs.O.toString() && ge.isGameActive()) {
					this.sign = Signs.O;
					if(ge.getMoves()==0) {		
						
						this.aiMove = MiniMax.getBestMove(ge.getBoard()[0].getDeepCopy(), Signs.O);
						if(aiMove[0]!=-1 || aiMove[1]!=-1) {
							System.out.println("AI:"+aiMove[0]+","+aiMove[1]);
							ge.makeMove(aiMove[0], aiMove[1]);
						}
					}else {
						
						this.aiMove = MiniMax.getBestMove(ge.getBoard()[ge.getMoves()-1].getDeepCopy(), Signs.O);
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

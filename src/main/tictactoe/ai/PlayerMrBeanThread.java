package main.tictactoe.ai;

import main.tictactoe.model.GameEngine;
import main.tictactoe.utils.GeneralUtils;

public class PlayerMrBeanThread implements Runnable{
	private GameEngine ge;
	private boolean play=true;
	
	public PlayerMrBeanThread(GameEngine ge) {
		GeneralUtils.log("PlayerBean", "Player mr Bean Created succesfully.");
		this.ge = ge;
	}

	@Override
	public void run() {
		GeneralUtils.log("PlayerBean", "Thread started...");
		try {
			mrBeanMoves();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GeneralUtils.log("PlayerBean", "Thread ended...");
		
	}
	
	
	private void mrBeanMoves() throws InterruptedException {
		while(play) {
			if(ge.isGameActive()) {
				if(ge.getPlayerX().getName().equals("Mr. Bean") && ge.getMoves()%2 == 0 && ge.isGameActive()) {
					int x = (int) (Math.random()*3);
					int y = (int) (Math.random()*3);
					if(x>=0 && x<=2 && y>=0 && y<=2) {			
						GeneralUtils.log("PlayerBean", "Mr Bean plays now as X at "+x+","+y);
						ge.makeMove(x, y);
					}
					else {
						GeneralUtils.log("PlayerBean", "out of bounds as X at "+x+","+y);
					}
				}	
				else if(ge.getPlayerO().getName().equals("Mr. Bean") && ge.getMoves()%2 == 1 && ge.isGameActive()) {
					int x = (int) (Math.random()*3);
					int y = (int) (Math.random()*3);
					if(x>=0 && x<=2 && y>=0 && y<=2) {	
						GeneralUtils.log("PlayerBean", "Mr Bean plays now as O at "+x+","+y);
						ge.makeMove(x, y);
					}
					else {
						GeneralUtils.log("PlayerBean", "out of bounds as X at "+x+","+y);
					}
				}
				//Thread sleep 100 milliseconds
				Thread.sleep(100);		
			}
			//Thread sleep 100 milliseconds
			Thread.sleep(100);
		}			
	}




	public boolean isPlay() {
		return play;
	}




	public void setPlay(boolean play) {
		this.play = play;
	}
		
		
	
}

package main.tictactoe.model;

import main.tictactoe.utils.GeneralUtils;

public class PlayerAI implements Runnable{
	private GameEngine ge;
	
	

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
		
	}

}

package main.tictactoe.model;

import java.util.Optional;

import main.tictactoe.io.FileHandler;
import main.tictactoe.utils.GeneralUtils;

public class GameEngine {
	private PlayerRoster playerRoster;
	private GameRecord gameRecord;
	private Board board;
	

	public GameEngine() {
		initRoster();
		this.gameRecord = new GameRecord();
		this.board = new Board();
		
	}
	
	private void initRoster() {
		Optional<PlayerRoster> pRoster = Optional.ofNullable(FileHandler.readPlayerRoster());
		if(pRoster.isPresent()) {
			this.playerRoster=pRoster.get();
			GeneralUtils.log("GameEngine", "Found and loaded game file at users profile");
		}else {
			this.playerRoster = new PlayerRoster();
			GeneralUtils.log("GameEngine", "Game file not found at users profile");
		}
	}

	public PlayerRoster getPlayerRoster() {
		return playerRoster;
	}

	public void setPlayerRoster(PlayerRoster playerRoster) {
		this.playerRoster = playerRoster;
	}
	
	
	

}

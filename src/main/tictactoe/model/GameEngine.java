package main.tictactoe.model;

import java.util.Optional;
import java.util.Random;

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
			makeDummyPlayers();
			GeneralUtils.log("GameEngine", "Game file not found at users profile");
		}
	}
	
	private void makeDummyPlayers() {
		for(int i=0;i<10;i++) {
			Player p = new Player();
			p.setName("Player "+i);
			p.setWins((int) (Math.random()*10) + 1);
			p.setDraws((int) (Math.random()*10) + 1);
			p.setLosses((int) (Math.random()*10) + 1);
			this.playerRoster.addPlayer(p);
		}
		FileHandler.writePlayerRoster(playerRoster);
	}

	public PlayerRoster getPlayerRoster() {
		return playerRoster;
	}

	public void setPlayerRoster(PlayerRoster playerRoster) {
		this.playerRoster = playerRoster;
	}

	public GameRecord getGameRecord() {
		return gameRecord;
	}

	public void setGameRecord(GameRecord gameRecord) {
		this.gameRecord = gameRecord;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	
	
	
	

}

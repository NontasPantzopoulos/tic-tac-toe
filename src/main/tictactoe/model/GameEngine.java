package main.tictactoe.model;

import java.util.Optional;
import main.tictactoe.io.FileHandler;
import main.tictactoe.utils.GeneralUtils;

public class GameEngine {
	private PlayerRoster playerRoster;
	private GameRecord gameRecord;
	private Board[] board;
	private Player playerX;
	private Player playerO;
	

	public GameEngine() {
		initRoster();
		this.gameRecord = new GameRecord();
		this.board = new Board[9];
		
	}
	
	private void initRoster() {
		Optional<PlayerRoster> pRoster = Optional.ofNullable(FileHandler.readPlayerRoster());
		if(pRoster.isPresent()) {
			this.playerRoster=pRoster.get();
			GeneralUtils.log("GameEngine", "Found and loaded game file from "+FileHandler.getUserpath());
		}else {
			//If there is no file in user's profile
			this.playerRoster = new PlayerRoster();
			makeDummyPlayers();
			GeneralUtils.log("GameEngine", "Created new PlayerRoster");
		}
	}
	
	/**
	 * This method makes players with random scores and saves the data to the file.
	 */
	private void makeDummyPlayers() {
		for(int i=0;i<4;i++) {
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

	

	public Board[] getBoard() {
		return board;
	}

	public void setBoard(Board[] board) {
		this.board = board;
	}

	public Player getPlayerX() {
		return playerX;
	}

	public void setPlayerX(Player playerX) {
		this.playerX = playerX;
	}

	public Player getPlayerO() {
		return playerO;
	}

	public void setPlayerO(Player playerO) {
		this.playerO = playerO;
	}
	
	public boolean readyToPlay() {
		if(playerX==null || playerO==null) {
			return false;
		}
		return true;
	}
	
	
	
	

}

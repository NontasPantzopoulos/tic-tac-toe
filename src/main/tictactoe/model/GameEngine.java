package main.tictactoe.model;

import java.awt.Toolkit;
import java.time.Instant;
import java.util.Optional;
import main.tictactoe.io.FileHandler;
import main.tictactoe.model.enums.PlayerResult;
import main.tictactoe.model.enums.Signs;
import main.tictactoe.utils.GeneralUtils;

public class GameEngine {
	private PlayerRoster playerRoster;
	private GameRecord gameRecord;
	private Board[] board;
	private Player playerX;
	private Player playerO;
	private int moves=0;
	private boolean gameActive=false;
	

	public GameEngine() {
		initRoster();
		this.gameRecord = new GameRecord();
		this.board = new Board[9];
		for(int i=0;i<this.board.length;i++) {
			this.board[i]= new Board();
		}
		GeneralUtils.log("GameEngine", "GameEngine Initialization");
		
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
		Player p1 = new Player("Mr. Bean");
		Player p2 = new Player("Hal");
		this.playerRoster.addPlayer(p1);
		this.playerRoster.addPlayer(p2);
		for(int i=0;i<2;i++) {
			Player p = new Player();
			p.setName("Player "+i);
			p.setWins((int) (Math.random()*10) + 1);
			p.setDraws((int) (Math.random()*10) + 1);
			p.setLosses((int) (Math.random()*10) + 1);
			this.playerRoster.addPlayer(p);
		}
		FileHandler.writePlayerRoster(playerRoster);
	}
	
	/**
	 * Initializes a new game
	 */
	public void zeroizeGame() {
		initRoster();
		this.gameRecord = new GameRecord();
		this.board = new Board[9];
		for(int i=0;i<this.board.length;i++) {
			this.board[i]= new Board();
		}
		this.playerX=null;
		this.playerO=null;
		this.moves=0;
		this.gameActive=false;
		GeneralUtils.log("GameEngine", "GameEngine Initialization");
	}
	
	/**
	 * If the game has two players instances, then it is ready to play.
	 * @return true or false
	 */
	public boolean readyToPlay() {
		if(playerX==null || playerO==null) {
			return false;
		}
		this.gameActive=true;
		
		return true;
	}
	
	/**
	 * This method is the basic method ..
	 * @param row
	 * @param col
	 */
	public void makeMove(int row, int col) {
		if(moves>8) {
			return;
		}
		if(!gameActive) {
			return;
		}
		
		if(moves==0) {
			String[][] newBoard = new String[3][3];
			for(int rrow=0;rrow<3;rrow++) {
				for(int ccol=0;ccol<3;ccol++) {
					if(ccol==col && rrow==row) {
						newBoard[rrow][ccol]=getSign();
					}
					else {
						newBoard[rrow][ccol]=Signs.EMPTY.toString();
					}
				}
			}
			board[0]=new Board(newBoard);
		}else{
			String[][] stringBoard = board[moves-1].getBoard();
			if(stringBoard[row][col]==Signs.EMPTY.toString()) {
				stringBoard[row][col]=getSign();
				board[moves] = new Board(stringBoard);
			}
			else {
				GeneralUtils.log("GameEngine", "There is already a value to the cell.");
				return;
			}
		}
		GeneralUtils.log("GameEngine", "Move:"+moves+"-"+row+","+col);
		System.out.println(board[moves].toString());
		checkBoard();
		moves++;
	}
	
	private String getSign() {
		if(moves%2 == 0){
			return Signs.X.toString();
		}	
		return Signs.O.toString();
	}
	
	public boolean isGameActive() {
		return gameActive;
	}
	
	private void checkBoard() {
		if(board[moves].isValid()) {
			GeneralUtils.log("GameEngine", "Board:"+moves+" is Valid");
		}else {
			gameActive=false;
		}
		//Game has a winner
		if(board[moves].isWin(getSign())) {
			Toolkit.getDefaultToolkit().beep(); 
			GeneralUtils.log("GameEngine", "Player "+getSign()+" is Winner!");
			if(getSign()=="X") {
				gameRecord.setResultX(PlayerResult.WINNER);
				gameRecord.setResultO(PlayerResult.LOOSER);
				playerX.addWin();
				playerO.addLoss();
				
			}else {
				gameRecord.setResultX(PlayerResult.LOOSER);
				gameRecord.setResultO(PlayerResult.WINNER);
				playerX.addLoss();
				playerO.addWin();
			}
			gameActive=false;
			gameRecord.setTimeOfEnd(Instant.now());
			playerX.addBestGame(gameRecord);
			playerX.addLastGame(gameRecord);
			playerO.addBestGame(gameRecord);
			playerO.addLastGame(gameRecord);
			FileHandler.writePlayerRoster(playerRoster);
		}
		
		//Game ends to draw
		if(board[moves].isValid() && moves==8 && !board[moves].isWin(getSign())) {
			Toolkit.getDefaultToolkit().beep(); 
			gameRecord.setResultX(PlayerResult.DRAW);
			gameRecord.setResultO(PlayerResult.DRAW);
			gameRecord.setTimeOfEnd(Instant.now());
			playerX.addDraw();
			playerO.addDraw();
			playerX.addBestGame(gameRecord);
			playerX.addLastGame(gameRecord);
			playerO.addBestGame(gameRecord);
			playerO.addLastGame(gameRecord);
			FileHandler.writePlayerRoster(playerRoster);
			GeneralUtils.log("GameEngine", "Game result: Draw");
			gameActive=false;
		}
		
	}
	
	
	
	//Getters And Setters

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
		this.gameRecord.setPlayerX(playerX);
	}

	public Player getPlayerO() {
		return playerO;
	}

	public void setPlayerO(Player playerO) {
		this.playerO = playerO;
		this.gameRecord.setPlayerO(playerO);
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}
	

}

package main.tictactoe.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Player implements Serializable{
	private String name;
	private int totalGames;
	private int wins;
	private int losses;
	private int draws;
	private float score;
	private GameRecord[] playersLastGames = new GameRecord[5];
	private GameRecord[] playersBestGames = new GameRecord[5];
	
	/**
	 * Default empty constructor
	 */
	public Player() {
		
	}

	/**
	 * Constructor of the class, which uses the setter method
	 * @param name
	 */
	public Player(String name) {
		setName(name);
	}

	public void addWin() {
		this.wins++;
		this.totalGames++;
		calculateScore();
	}
	public void addLoss() {
		this.losses++;
		this.totalGames++;
	}
	public void addDraw() {
		this.draws++;
		this.totalGames++;
		calculateScore();
	}

	/**
	 * Score calculator
	 */
	private void calculateScore() {
		if(totalGames>0) {
			this.score = (50*(2*wins+draws))/totalGames;
		}else {
			this.score = 0;
		}
		
	}
	
	//Getters and Setters
	
	public String getName() {
		return name;
	}
	/**
	 * This setter removes leading and trailing spaces from the name and ensures that only the first 20 characters are kept.
	 * @param name
	 */
	public void setName(String name) {
		String pname = name.strip();
		if(pname.length()>20) {
			pname = pname.substring(0, 20);
		}
		this.name = pname;
	}

	public int getTotalGames() {
		return totalGames;
	}

//	public void setTotalGames(int totalGames) {
//		this.totalGames = totalGames;
//	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
		this.totalGames+=wins;
		calculateScore();
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
		this.totalGames+=losses;
		calculateScore();
	}

	public int getDraws() {
		return draws;
	}

	public void setDraws(int draws) {
		this.draws = draws;
		this.totalGames+=draws;
		calculateScore();
	}

	

	public GameRecord[] getPlayersLastGames() {
		return playersLastGames;
	}

	public void setPlayersLastGames(GameRecord[] playersLastGames) {
		this.playersLastGames = playersLastGames;
	}

	public GameRecord[] getPlayersBestGames() {
		return playersBestGames;
	}

	public void setPlayersBestGames(GameRecord[] playersBestGames) {
		this.playersBestGames = playersBestGames;
	}

	public float getScore() {
		return score;
	}

//	public void setScore(float score) {
//		this.score = score;
//	}
	
	

}

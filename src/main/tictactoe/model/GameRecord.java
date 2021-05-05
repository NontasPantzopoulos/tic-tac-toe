package main.tictactoe.model;

import java.io.Serializable;
import java.time.Instant;
import main.tictactoe.model.enums.PlayerResult;

/**
 * GameRecord class, which holds each game information
 *
 */
@SuppressWarnings("serial")
public class GameRecord implements Serializable{
	private Player playerX;
	private Player playerO;
	private PlayerResult resultX;
	private PlayerResult resultO;
	private float scoreX=0.0f;
	private float scoreO=0.0f;
	private Instant timeOfStart;
	private Instant timeOfEnd;
	
	//Constructor
	public GameRecord() {
		this.playerX = new Player();
		this.playerO = new Player();
		this.timeOfStart=Instant.now();
		this.timeOfEnd=Instant.now();
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

	public PlayerResult getResultX() {
		return resultX;
	}

	public void setResultX(PlayerResult resultX) {
		this.resultX = resultX;
	}

	public PlayerResult getResultO() {
		return resultO;
	}

	public void setResultO(PlayerResult resultO) {
		this.resultO = resultO;
	}

	public float getScoreX() {
		return scoreX;
	}

	public void setScoreX(float scoreX) {
		this.scoreX = scoreX;
	}

	public float getScoreO() {
		return scoreO;
	}

	public void setScoreO(float scoreO) {
		this.scoreO = scoreO;
	}

	public Instant getTimeOfStart() {
		return timeOfStart;
	}

	public void setTimeOfStart(Instant timeOfStart) {
		this.timeOfStart = timeOfStart;
	}

	public Instant getTimeOfEnd() {
		return timeOfEnd;
	}

	public void setTimeOfEnd(Instant timeOfEnd) {
		this.timeOfEnd = timeOfEnd;
	}

	
	

}

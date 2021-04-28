package main.tictactoe.model;

import java.time.Instant;
import java.util.HashMap;

import main.tictactoe.model.enums.PlayerResult;

public class GameRecord {
	private Player[] players;
	private PlayerResult[] results;
	private float[] scores;
	private Instant timeOfStart;
	private Instant timeOfEnd;
	
	public GameRecord() {
		this.players = new Player[2];
		this.results = new PlayerResult[2];
		this.scores = new float[2];
		this.timeOfStart=Instant.now();
		this.timeOfEnd=Instant.now();
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public PlayerResult[] getResults() {
		return results;
	}

	public void setResults(PlayerResult[] results) {
		this.results = results;
	}

	public float[] getScores() {
		return scores;
	}

	public void setScores(float[] scores) {
		this.scores = scores;
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

package main.tictactoe.controller;

import main.tictactoe.model.GameEngine;

public abstract class AbstractController {
	protected GameEngine ge;

	public AbstractController(GameEngine ge) {
		this.ge = ge;
	}

	protected GameEngine getGe() {
		return ge;
	}

	protected void setGe(GameEngine ge) {
		this.ge = ge;
	}
	

}

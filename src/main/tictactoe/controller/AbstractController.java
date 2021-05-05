package main.tictactoe.controller;

import main.tictactoe.model.GameEngine;
/**
 * This is an abstract controller class which gets the GameEngine instance.
 * All classes extend this class must set the GameEngine object.
 *
 */
public abstract class AbstractController {
	protected GameEngine ge;

	protected AbstractController(GameEngine ge) {
		this.ge = ge;
	}

	protected GameEngine getGe() {
		return ge;
	}

	protected void setGe(GameEngine ge) {
		this.ge = ge;
	}
	

}

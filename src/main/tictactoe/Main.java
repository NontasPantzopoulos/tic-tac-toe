package main.tictactoe;

import main.tictactoe.model.GameEngine;
import main.tictactoe.utils.GeneralUtils;
import main.tictactoe.view.MainWindow;

public class Main {

	public static void main(String[] args) {
		GeneralUtils.log("Main", "App started");	
		GameEngine ge = new GameEngine();
		new MainWindow(ge);
		
	}
}

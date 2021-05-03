package main.tictactoe;

import main.tictactoe.model.Board;
import main.tictactoe.model.GameEngine;
import main.tictactoe.utils.GeneralUtils;
import main.tictactoe.view.MainWindow;

public class Main {

	public static void main(String[] args) {
//		Board b =new Board();
//		System.out.println(b.toString());
		GeneralUtils.log("Main", "App started");	
		GameEngine ge = new GameEngine();
		new MainWindow(ge);
		
	}
}

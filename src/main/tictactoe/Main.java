package main.tictactoe;


import main.tictactoe.ai.AlphaBetaPruning;
import main.tictactoe.ai.PlayerAI;
import main.tictactoe.ai.PlayerMrBeanThread;
import main.tictactoe.model.GameEngine;
import main.tictactoe.utils.GeneralUtils;
import main.tictactoe.view.MainWindow;
import test.AlphaBetaPruningTest;
/**
 * This application is a Java GUI (Swing Based) application for tic-tac-toe game.
 * This is the entry point (main) of the whole application.
 * All comments are in English language because I hate greeklish. Sorry...
 */
public class Main {
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		GeneralUtils.log("Main", "App started");
		//Initializes a GameEngine instance.
		GameEngine ge = new GameEngine();
		//Initializes the main JFrame.
		new MainWindow(ge);
		
		
		//Starts Mr Bean thread
		PlayerMrBeanThread pb =new PlayerMrBeanThread(ge);
		Thread mrBeanThread = new Thread(pb);
		mrBeanThread.setName("mrBeanThread");
		mrBeanThread.start();
		
		//Starts AI (Hal) thread
		PlayerAI ai = new PlayerAI(ge);
		Thread aiThread = new Thread(ai);
		aiThread.setName("AIThread");
		aiThread.start();
		
		
		
	}
}

package main.tictactoe.view;

import javax.swing.JPanel;

import main.tictactoe.model.GameEngine;
/**
 * This is an Abstract Class which inherits all the attributes of a JPanel.
 * All methods have access modifier protected in order to be used only by classes which extend this class.
 *
 */
@SuppressWarnings("serial")
public abstract class AbstractPanel extends JPanel{
	protected GameEngine ge;
	protected MainWindow mainWindow;
	
	/**
	 * Constructor with one argument of GameEngine instance.
	 * @param ge
	 */
	public AbstractPanel(GameEngine ge, MainWindow mainWindow) {
		this.ge = ge;
		this.mainWindow = mainWindow;
	}
	//Getters and Setters.
	protected GameEngine getGe() {
		return ge;
	}

	protected void setGe(GameEngine ge) {
		this.ge = ge;
	}
	protected MainWindow getMainWindow() {
		return mainWindow;
	}
	protected void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	
	
}

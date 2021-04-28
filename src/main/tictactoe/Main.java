package main.tictactoe;

import java.io.File;

import main.tictactoe.utils.GeneralUtils;
import main.tictactoe.view.MainWindow;

public class Main {

	public static void main(String[] args) {
		GeneralUtils.log("Main", "App started");
		
		String path = System.getProperty("user.home") + File.separator;
		
		GeneralUtils.log("Main", "Home Folder is "+path);
		
		new MainWindow();
		
	}
}

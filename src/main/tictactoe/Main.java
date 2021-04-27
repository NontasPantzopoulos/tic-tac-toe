package main.tictactoe;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

import main.tictactoe.utils.GeneralUtils;
import main.tictactoe.utils.ScreenUtils;
import main.tictactoe.view.MainWindow;

public class Main {

	public static void main(String[] args) {
		GeneralUtils.log("Main", "App started");
		
		String path = System.getProperty("user.home") + File.separator;
		GeneralUtils.log("Main", "Home Folder is "+path);
		
		new MainWindow();
		
	}
}

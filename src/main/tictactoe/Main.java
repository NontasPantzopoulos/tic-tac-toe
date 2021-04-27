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

//	private static void createAndShowGUI() {
//        //Create and set up the window.
//		ScreenUtils.setLookAndFeel();
//		
//        JFrame frame = new JFrame("BoxLayoutDemo");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 
//        //Set up the content pane.
//        addComponentsToPane(frame.getContentPane());
//        frame.setSize(1024, 768);
//        
//        frame = ScreenUtils.windowCentered(frame);
//        //Display the window.
//        //frame.pack();
//        frame.setVisible(true);
//    }
    
    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
 
        addAButton("Button 1", pane);
        addAButton("Button 2", pane);
        addAButton("Button 3", pane);
        addAButton("Long-Named Button 4", pane);
        addAButton("5", pane);
    }
 
    private static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }
	
	public static void main(String[] args) {
		GeneralUtils.log("Main", "App started");
		
		String path = System.getProperty("user.home") + File.separator;
		GeneralUtils.log("Main", "Home Folder is "+path);
		
		new MainWindow();
		
		

	}
	
	
    

}

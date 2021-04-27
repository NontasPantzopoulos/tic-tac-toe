package main.tictactoe.utils;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class ScreenUtils {
	
	public static JFrame windowCentered(JFrame frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        return frame;
	}
	
	public static void setLookAndFeel() {
//		GeneralUtils.log("ScreenUtils","Setting Look and Feel:"+UIManager.getSystemLookAndFeelClassName());
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//	    } catch(Exception e) {
//	        System.out.println("Error setting native LAF: " + e);
//	    }
	}

}

package main.tictactoe.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HallOfFame extends JPanel{
	

	public HallOfFame() {
		initComponents();
	}
	
	
	private void initComponents() {
		this.setBackground(Color.YELLOW);
		this.add(new JLabel("HallOfFame"));
		
		
	}


	
	
	
	

}

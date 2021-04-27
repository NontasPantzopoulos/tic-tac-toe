package main.tictactoe.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HallOfFame {
	private JPanel panel;

	public HallOfFame() {
		initComponents();
	}
	
	
	private void initComponents() {
		this.panel = new JPanel();
		this.panel.setBackground(Color.YELLOW);
		this.panel.add(new JLabel("HallOfFame"));
		
		
	}


	public JPanel getPanel() {
		return panel;
	}


	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	
	

}

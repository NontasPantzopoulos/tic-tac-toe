package main.tictactoe.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard {
	private JPanel panel;
	
	
	public GameBoard() {
		initComponents();
	}


	private void initComponents() {
		this.panel = new JPanel();
		this.panel.setBackground(Color.WHITE);
		this.panel.add(new JLabel("GameBoard"));
	}


	public JPanel getPanel() {
		return panel;
	}


	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	

}

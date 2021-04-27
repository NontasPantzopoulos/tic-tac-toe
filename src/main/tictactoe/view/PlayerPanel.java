package main.tictactoe.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.tictactoe.utils.GeneralUtils;

public class PlayerPanel extends JPanel {
	private JPanel panel;
	private JPanel buttonsPanel;
	private JPanel dataPanel;
	

	public PlayerPanel() {
		initComponets();
	}
	
	private void initComponets() {
		this.panel = new JPanel();
		this.panel.setLayout(new BorderLayout());
		this.panel.setBackground(Color.GREEN);
		
		this.buttonsPanel = new JPanel();
		this.buttonsPanel.setBackground(Color.GREEN);
		this.buttonsPanel.add(createButton("Start Game"));
		this.buttonsPanel.add(createButton("SelectPlayer"));
		
		this.dataPanel = new JPanel();
		this.dataPanel.setBackground(Color.GREEN);
		
		
		this.panel.add(buttonsPanel,BorderLayout.NORTH);
		this.panel.add(dataPanel,BorderLayout.CENTER);
		GeneralUtils.log("PlayerPanel", "New PlayerPanel Created");
		
	}
	
	private JButton createButton(String text) {
		JButton b = new JButton(text);
		b.setPreferredSize(new Dimension(110,20));
		return b;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	
	
}

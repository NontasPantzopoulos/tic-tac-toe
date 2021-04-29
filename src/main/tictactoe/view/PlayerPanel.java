package main.tictactoe.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.tictactoe.controller.PlayerPanelController;
import main.tictactoe.model.GameEngine;
import main.tictactoe.utils.GeneralUtils;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel {
	private JPanel buttonsPanel;
	private JPanel dataPanel;
	private GameEngine ge;
	private PlayerPanelController playerPanelController;
	

	public PlayerPanel(GameEngine ge) {
		this.ge=ge;
		playerPanelController = new PlayerPanelController();
		initComponets();
	}
	
	private void initComponets() {
		this.addMouseListener(playerPanelController);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.GREEN);
		
		this.buttonsPanel = new JPanel();
		this.buttonsPanel.setBackground(Color.GREEN);
		this.buttonsPanel.add(createButton("Start Game"));
		this.buttonsPanel.add(createButton("SelectPlayer"));
		
		this.dataPanel = new JPanel();
		this.dataPanel.setBackground(Color.GREEN);
		
		
		this.add(buttonsPanel,BorderLayout.NORTH);
		this.add(dataPanel,BorderLayout.CENTER);
		GeneralUtils.log("PlayerPanel", "New PlayerPanel Created");
		
	}
	
	private JButton createButton(String text) {
		JButton b = new JButton(text);
		b.setName(text);
		b.addActionListener(playerPanelController);
		b.setPreferredSize(new Dimension(110,20));
		return b;
	}

	public JPanel getPanel() {
		return this;
	}

	
	
	
	
}

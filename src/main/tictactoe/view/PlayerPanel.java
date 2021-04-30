package main.tictactoe.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.tictactoe.controller.PlayerPanelController;
import main.tictactoe.model.GameEngine;
import main.tictactoe.model.enums.Signs;
import main.tictactoe.utils.GeneralUtils;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel {
	private JPanel buttonsPanel;
	private JPanel dataPanel;
	private JPanel parentPanel;
	private GameEngine ge;
	private MainWindow parentFrame;
	private PlayerPanelController playerPanelController;
	private Signs sign;
	

	public PlayerPanel(MainWindow parentFrame,JPanel parentPanel,GameEngine ge,Signs sign) {
		this.ge=ge;
		this.playerPanelController = new PlayerPanelController(this.parentFrame,this.parentPanel,this.ge);
		this.sign=sign;
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
		this.dataPanel.setLayout(new BoxLayout(this.dataPanel, BoxLayout.Y_AXIS));
		JLabel signLabel = new JLabel(sign.toString());
		signLabel.setFont(new Font(signLabel.getName(), Font.PLAIN, 100));
		signLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.dataPanel.add(signLabel);
		this.add(buttonsPanel,BorderLayout.NORTH);
		this.add(dataPanel,BorderLayout.CENTER);
		GeneralUtils.log("PlayerPanel", "New PlayerPanel Created");
		
	}
	
	private JButton createButton(String text) {
		if(text.equals("Start Game") && !this.ge.readyToPlay()) {
			JButton b = new JButton(text);
			b.setName(text);
			b.setActionCommand(text);
			b.addActionListener(playerPanelController);
			b.setPreferredSize(new Dimension(110,20));
			b.setEnabled(false);
			return b;
		}
		JButton b = new JButton(text);
		b.setName(text);
		b.setActionCommand(text);
		b.addActionListener(playerPanelController);
		b.setPreferredSize(new Dimension(110,20));
		return b;
	}

	public JPanel getPanel() {
		return this;
	}

	
	
	
	
}

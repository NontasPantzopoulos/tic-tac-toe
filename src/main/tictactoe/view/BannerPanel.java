package main.tictactoe.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.tictactoe.controller.BannerPanelController;
import main.tictactoe.model.GameEngine;
import main.tictactoe.utils.GeneralUtils;

@SuppressWarnings("serial")
public class BannerPanel extends JPanel{
	
	private JPanel leftSubPanel;
	private JPanel middleJPanel;
	private GameEngine ge;
	private BannerPanelController bannerPanelController;

	public BannerPanel(GameEngine ge) {
		this.setGe(ge);
		this.bannerPanelController = new BannerPanelController();
		initComponents();
	}
	
	private void initComponents() {
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
	
		
		this.leftSubPanel = new JPanel();
		this.leftSubPanel.setBackground(Color.WHITE);
		this.leftSubPanel.add(createButton("Quit"));
		this.leftSubPanel.add(createButton("Add Player"));
		
		this.middleJPanel = new JPanel();
		this.middleJPanel.setBackground(Color.WHITE);
		this.middleJPanel.add(createButton("Done"));
		
		this.add(leftSubPanel, BorderLayout.WEST);
		this.add(middleJPanel,BorderLayout.CENTER);
		this.setName("BannerPanel");
		this.addMouseListener(this.bannerPanelController);
		GeneralUtils.log("BannerPanel", "New BannerPanel Created");
	}

	
	private JButton createButton(String text) {
		JButton b = new JButton(text);
		b.setPreferredSize(new Dimension(100,25));
		b.setActionCommand(text);
		b.addActionListener(this.bannerPanelController);
		
		
		return b;
	}

	public GameEngine getGe() {
		return ge;
	}

	public void setGe(GameEngine ge) {
		this.ge = ge;
	}
	
	
	
	
}

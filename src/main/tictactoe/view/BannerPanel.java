package main.tictactoe.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.tictactoe.controller.BannerPanelController;
import main.tictactoe.utils.GeneralUtils;

public class BannerPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2612401090647440592L;
	private JPanel panel; 
	private JPanel leftSubPanel;
	private JPanel middleJPanel;
	private BannerPanelController bannerPanelController;

	public BannerPanel() {
		this.bannerPanelController = new BannerPanelController();
		initComponents();
	}
	
	private void initComponents() {
		this.panel= new JPanel();
		this.panel.setLayout(new BorderLayout());
		this.panel.setBackground(Color.WHITE);
	
		
		this.leftSubPanel = new JPanel();
		this.leftSubPanel.setBackground(Color.WHITE);
		this.leftSubPanel.add(createButton("Quit"));
		this.leftSubPanel.add(createButton("Add Player"));
		
		this.middleJPanel = new JPanel();
		this.middleJPanel.setBackground(Color.WHITE);
		this.middleJPanel.add(createButton("Done"));
		
		this.panel.add(leftSubPanel, BorderLayout.WEST);
		this.panel.add(middleJPanel,BorderLayout.CENTER);
		this.panel.setName("BannerPanel");
		this.panel.addMouseListener(this.bannerPanelController);
		GeneralUtils.log("BannerPanel", "New BannerPanel Created");
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	private JButton createButton(String text) {
		JButton b = new JButton(text);
		b.setPreferredSize(new Dimension(100,25));
		b.setActionCommand(text);
		b.addActionListener(this.bannerPanelController);
		
		
		return b;
	}
	
	
	
	
}

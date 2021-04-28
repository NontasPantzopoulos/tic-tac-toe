package main.tictactoe.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.tictactoe.utils.ScreenUtils;

public class MainWindow extends JFrame{
	
	private JFrame frame;
	private JPanel bannerPanel;
	private JPanel contentsPanel;
	private JPanel contentsLeftPanel;
	private JPanel contentsRightPanel;
	private JPanel contentsMiddlePanel;
	
	private static final String HALLOFFAME = "HALLOFFAME";
	private static final String GAMEBOARD = "GAMEBOARD";
	

	public MainWindow() throws HeadlessException {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            try {
	            	initFrame();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });	
		
	}
	
	private void initFrame() {
		//Optional set LookAndFeel
		//ScreenUtils.setLookAndFeel();
		//Frame title
		this.frame = new JFrame("___Tic-Tac-Toe___");
		//Frame initial size
		this.frame.setSize(1024, 768);
		//Gets the Frame to the center of the screen
		this.frame = ScreenUtils.windowCentered(frame);
		//Sets a layout to the Frame
		this.frame.setLayout(new BorderLayout());
		//Close Operation
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Initializes the BannerPanel
        initBannerPanel(this.frame);
        
        //Initializes the contnent Panel
        initContentPanel(this.frame);

        //frame.pack();
        //Display the window.
        frame.setVisible(true);
        
	}
	
	private void initBannerPanel(JFrame frame) {
		this.bannerPanel = new BannerPanel().getPanel();
        this.frame.getContentPane().add(bannerPanel,BorderLayout.NORTH);
	}
	
	
	private void initContentPanel(JFrame frame) {
		this.contentsPanel = new JPanel();
		this.contentsPanel.setLayout(new BorderLayout());
		this.contentsPanel.setBackground(Color.WHITE);
		
		this.contentsMiddlePanel = new JPanel();
        this.contentsMiddlePanel.setLayout(new CardLayout());
        this.contentsMiddlePanel.add(new GameBoard(),GAMEBOARD);
        this.contentsMiddlePanel.add(new HallOfFame(),HALLOFFAME);
        showCard(GAMEBOARD);
        this.contentsLeftPanel=new PlayerPanel().getPanel();
        this.contentsRightPanel=new PlayerPanel().getPanel();
        
        
        this.contentsPanel.add(this.contentsRightPanel,BorderLayout.EAST);
        this.contentsPanel.add(this.contentsLeftPanel,BorderLayout.WEST);
        this.contentsPanel.add(this.contentsMiddlePanel,BorderLayout.CENTER);
		
		this.frame.getContentPane().add(contentsPanel,BorderLayout.CENTER);
	
	}
	
	public void showCard(String cardname) {
		CardLayout cl = (CardLayout) contentsMiddlePanel.getLayout();
        cl.show(contentsMiddlePanel, cardname);
	}
	
	
	//Getters And Setters

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getBannerPanel() {
		return bannerPanel;
	}

	public void setBannerPanel(JPanel bannerPanel) {
		this.bannerPanel = bannerPanel;
	}

	public JPanel getContentsPanel() {
		return contentsPanel;
	}

	public void setContentsPanel(JPanel contentsPanel) {
		this.contentsPanel = contentsPanel;
	}

	public JPanel getContentsLeftPanel() {
		return contentsLeftPanel;
	}

	public void setContentsLeftPanel(JPanel contentsLeftPanel) {
		this.contentsLeftPanel = contentsLeftPanel;
	}

	public JPanel getContentsRightPanel() {
		return contentsRightPanel;
	}

	public void setContentsRightPanel(JPanel contentsRightPanel) {
		this.contentsRightPanel = contentsRightPanel;
	}

	public JPanel getContentsMiddlePanel() {
		return contentsMiddlePanel;
	}

	public void setContentsMiddlePanel(JPanel contentsMiddlePanel) {
		this.contentsMiddlePanel = contentsMiddlePanel;
	}

	public static String getHalloffame() {
		return HALLOFFAME;
	}

	public static String getGameboard() {
		return GAMEBOARD;
	}
	
	
	
	
	
	
	

	

}

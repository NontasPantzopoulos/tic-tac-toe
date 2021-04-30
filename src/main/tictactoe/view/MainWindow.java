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

import main.tictactoe.model.GameEngine;
import main.tictactoe.model.enums.Signs;
import main.tictactoe.utils.ScreenUtils;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	
	private JFrame frame;
	private JPanel bannerPanel;
	private JPanel contentsPanel;
	private JPanel contentsLeftPanel;
	private JPanel contentsRightPanel;
	private JPanel contentsMiddlePanel;
	private GameEngine ge;
	
	private static final String HOF = "HALLOFFAME";
	private static final String GB = "GAMEBOARD";
	

	public MainWindow(GameEngine ge) throws HeadlessException {
		this.setGe(ge);
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
        
        //Initializes the content Panel
        initContentPanel(this.frame);

        //frame.pack();
        //Display the window.
        frame.setVisible(true);
        
	}
	
	private void initBannerPanel(JFrame frame) {
		this.bannerPanel = new BannerPanel(this,this.ge);
        this.frame.getContentPane().add(bannerPanel,BorderLayout.NORTH);
	}
	
	
	private void initContentPanel(JFrame frame) {
		this.contentsPanel = new JPanel();
		this.contentsPanel.setLayout(new BorderLayout());
		this.contentsPanel.setBackground(Color.WHITE);
		
		this.contentsMiddlePanel = new JPanel();
        this.contentsMiddlePanel.setLayout(new CardLayout());
        this.contentsMiddlePanel.add(new GameBoard(this.ge),GB);
        this.contentsMiddlePanel.add(new HallOfFame(this.ge),HOF);
        showCard(HOF);
        this.contentsLeftPanel=new PlayerPanel(this,this.contentsLeftPanel,this.ge,Signs.X);
        this.contentsRightPanel=new PlayerPanel(this,this.contentsRightPanel,this.ge,Signs.O);
        
        
        this.contentsPanel.add(this.contentsRightPanel,BorderLayout.EAST);
        this.contentsPanel.add(this.contentsLeftPanel,BorderLayout.WEST);
        this.contentsPanel.add(this.contentsMiddlePanel,BorderLayout.CENTER);
		
		this.frame.getContentPane().add(contentsPanel,BorderLayout.CENTER);
	
	}
	
	
	
	public void showCard(String cardname) {
		CardLayout cl = (CardLayout) contentsMiddlePanel.getLayout();
        cl.show(contentsMiddlePanel, cardname);
        if(cardname.equals(GB)) {
        	contentsMiddlePanel.remove(0);
        	contentsMiddlePanel.add(new GameBoard(this.ge),GB);
        	cl.show(contentsMiddlePanel, GB);
        }
        if(cardname.equals(HOF)) {
        	contentsMiddlePanel.remove(1);
        	contentsMiddlePanel.add(new HallOfFame(this.ge),HOF);
        	cl.show(contentsMiddlePanel, HOF);
        }
        contentsMiddlePanel.repaint();
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
		return HOF;
	}

	public static String getGameboard() {
		return GB;
	}


	public GameEngine getGe() {
		return ge;
	}


	public void setGe(GameEngine ge) {
		this.ge = ge;
	}
	
	
	
	
	
	
	

	

}

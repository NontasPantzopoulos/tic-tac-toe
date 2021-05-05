package main.tictactoe.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.tictactoe.model.GameEngine;
import main.tictactoe.model.Player;
import main.tictactoe.utils.GeneralUtils;
import main.tictactoe.view.MainWindow;

/**
 * This is the controller class for the top banner component which has three buttons.
 * Handles the request for the Add Player command.
 * Handles the request for the Quit Button  (Program ends)
 * Handles the request for the Done Button.
 *
 */
public class BannerPanelController extends AbstractController implements ActionListener,MouseListener{
	private MainWindow mainWindow;
	private JPanel parentPanel;
	
	//Constructor
	public BannerPanelController(MainWindow parentFrame,JPanel parentPanel, GameEngine ge) {
		super(ge);
		this.mainWindow=parentFrame;
		this.parentPanel=parentPanel;
	}
	
	/**
	 * Actions coming from BannerPanel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().getClass().equals(JButton.class)) {			
			GeneralUtils.log("BannerPanelController", e.getActionCommand().toString());
			//Gets the source
			String action = e.getActionCommand().toString();
			
			//Depending on the source, does the appropriate work
			switch(action) {
			case "Add Player":
				//Gets the user input
				String selPlayer = (String) JOptionPane.showInputDialog(null,"Name","New Player",JOptionPane.INFORMATION_MESSAGE);
				//If input is null
				if (selPlayer==null || selPlayer=="" || selPlayer.equals("")) {
					JOptionPane.showMessageDialog(null,"Player name should not be null","Error",JOptionPane.ERROR_MESSAGE);
				}
				//if input exceeds 20 characters
				//The actual control (trimming) of 20 chars is done in Player class
				else if(selPlayer.length()>20) {
					JOptionPane.showMessageDialog(null,"The game will save the first 20 characters of the name.","Warning",JOptionPane.WARNING_MESSAGE);
					Player p =new Player(selPlayer);
					ge.getPlayerRoster().addPlayer(p);
					mainWindow.showCard(MainWindow.getHalloffame());
					
				}
				//if all is good
				else {
					Player p =new Player(selPlayer);
					ge.getPlayerRoster().addPlayer(p);
					mainWindow.showCard(MainWindow.getHalloffame());
				}
				
				break;
			case "Done":
				//Shows the HALLOFFAME
				mainWindow.showCard(MainWindow.getHalloffame());
				//Resets the game in GameEngine and in MainWindow
				super.ge.zeroizeGame();
				mainWindow.zeroiseGame();
				
				break;
			case "Quit":
				GeneralUtils.log("BannerPanelController", "Application Closing...");
				//Application is closing
				System.exit(0);
				break;
			default:
				break;
			}
		}
		
		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		GeneralUtils.log("BannerPanelController", "Clicked on"+e.getComponent().getName());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		GeneralUtils.log("BannerPanelController", "Pressed on"+e.getComponent().getName());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
//		GeneralUtils.log("BannerPanelController", "Released on"+e.getComponent().getName());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
//		GeneralUtils.log("BannerPanelController", "Entered on"+e.getComponent().getName());
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
//		GeneralUtils.log("BannerPanelController", "Exited from on"+e.getComponent().getName());
	}

	public GameEngine getGe() {
		return ge;
	}

	public void setGe(GameEngine ge) {
		this.ge = ge;
	}

	public MainWindow getParentFrame() {
		return mainWindow;
	}

	public void setParentFrame(MainWindow parentFrame) {
		this.mainWindow = parentFrame;
	}

	public JPanel getParentPanel() {
		return parentPanel;
	}

	public void setParentPanel(JPanel parentPanel) {
		this.parentPanel = parentPanel;
	}

	

}



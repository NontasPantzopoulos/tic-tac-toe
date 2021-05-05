package main.tictactoe.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import main.tictactoe.model.GameEngine;
import main.tictactoe.utils.GeneralUtils;
import main.tictactoe.view.MainWindow;
import main.tictactoe.view.PlayerPanel;

/**
 * This is the controller class for the PlayerPanel view class.
 */
public class PlayerPanelController extends AbstractController implements ActionListener,MouseListener{
	private MainWindow parentFrame;
	private PlayerPanel parentPanel;
	
	
	//Constructor
	public PlayerPanelController(MainWindow parentFrame,PlayerPanel parentPanel,GameEngine ge) {
		super(ge);
		this.parentFrame = parentFrame;
		this.parentPanel = parentPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//If the action comes from a Button
		if(e.getSource().getClass().equals(JButton.class)) {
			
			//GeneralUtils.log("PlayerPanelController", e.getActionCommand().toString());
			String action = e.getActionCommand().toString();
			switch(action) {
				//Start Game action shows the GameBoard Panel
				case "Start Game":
					parentFrame.showCard(MainWindow.getGameboard());
					GeneralUtils.log("PlayerPanelController", "Start Game Pressed");
					break;
				case "SelectPlayer":
					//calls the selectPlayer method from the PlayerPanel
				try {
					parentPanel.selectPlayer();
				} catch (CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					GeneralUtils.log("PlayerPanelController", "SelectPlayer Pressed");
					break;
				default:
					break;
			}
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}

package main.tictactoe.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.tictactoe.model.GameEngine;
import main.tictactoe.utils.GeneralUtils;
import main.tictactoe.view.MainWindow;

public class PlayerPanelController implements ActionListener,MouseListener{
	private GameEngine ge;
	private MainWindow parentFrame;
	private JPanel parentPanel;
	
	public PlayerPanelController(MainWindow parentFrame,JPanel parentPanel,GameEngine ge) {
		this.ge = ge;
		this.parentFrame = parentFrame;
		this.parentPanel = parentPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource().getClass().equals(JButton.class)) {
			
			GeneralUtils.log("PlayerPanelController", e.getActionCommand().toString());
			String action = e.getActionCommand().toString();
			switch(action) {
				case "Start Game":
					GeneralUtils.log("PlayerPanelController", "Start Game Pressed");
					break;
				case "SelectPlayer":
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

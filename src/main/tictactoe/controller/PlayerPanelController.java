package main.tictactoe.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import main.tictactoe.utils.GeneralUtils;

public class PlayerPanelController implements ActionListener,MouseListener{
	
	
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

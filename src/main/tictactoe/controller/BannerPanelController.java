package main.tictactoe.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import main.tictactoe.utils.GeneralUtils;

public class BannerPanelController implements ActionListener,MouseListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource().getClass().equals(JButton.class)) {
			
			GeneralUtils.log("BannerPanelController", e.getActionCommand().toString());
			String action = e.getActionCommand().toString();
			switch(action) {
			case "Quit":
				GeneralUtils.log("BannerPanelController", "Application Closing...");
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

	

}



package main.tictactoe.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.tictactoe.model.GameEngine;
import main.tictactoe.view.BoardCell;

public class BoardCellController implements ActionListener,MouseListener{
	private BoardCell cell;
	private GameEngine ge;
	
	
	

	public BoardCellController(BoardCell cell, GameEngine ge) {
		this.cell = cell;
		this.ge = ge;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked on cell " + this.cell.toString());
//		if (getModel().inPlay()) {
//			getModel().makeMove(row, col);
//			repaint();
//		}
		
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
		//System.out.println("Mouse entered cell " + this.cell.toString());
		this.cell.highlight();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//System.out.println("Mouse exited on cell " + this.cell.toString());
		this.cell.unHighlight();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

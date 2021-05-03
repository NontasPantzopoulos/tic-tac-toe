package main.tictactoe.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.tictactoe.model.GameEngine;
import main.tictactoe.utils.GeneralUtils;
import main.tictactoe.view.BoardCell;

public class BoardCellController extends AbstractController implements ActionListener,MouseListener{
	private BoardCell cell;
	
	public BoardCellController(BoardCell cell, GameEngine ge) {
		super(ge);
		this.cell = cell;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(!ge.checkGameStatus()) {
			return;
		}
		System.out.println("Mouse clicked on cell " + this.cell.toString());
		ge.makeMove(cell.getRow(), cell.getCol());
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
		if(!ge.checkGameStatus()) {
			return;
		}
		System.out.println("Mouse entered cell " + this.cell.toString());
		this.cell.highlight();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(!ge.checkGameStatus()) {
			return;
		}
		System.out.println("Mouse exited on cell " + this.cell.toString());
		this.cell.unHighlight();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

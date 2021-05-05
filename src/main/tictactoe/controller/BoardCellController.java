package main.tictactoe.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.tictactoe.model.GameEngine;
import main.tictactoe.view.BoardCell;
import main.tictactoe.view.GameBoard;

/**
 * This is the controller class for the BoardCell view class and the GameBoard class.
 */
public class BoardCellController extends AbstractController implements ActionListener,MouseListener{
	private BoardCell cell;
	private GameBoard gb;
	
	//Constructor
	public BoardCellController(BoardCell cell, GameEngine ge,GameBoard gb) {
		super(ge);
		this.gb=gb;
		this.cell = cell;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//prints info to the GameBoard
		gb.printinfo(ge.getPlayInfo());
		
		//If the game is not active, method exits
		if(!ge.isGameActive()) {
			return;
		}
		//if the game is active it calls the makeMove method of GameEngine
		System.out.println("Mouse clicked on cell " + this.cell.toString());
		ge.makeMove(cell.getRow(), cell.getCol());
//		cell.revalidate();
//		cell.repaint();
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
		gb.printinfo(ge.getPlayInfo());
		if(!ge.isGameActive()) {
			return;
		}
		//System.out.println("Mouse entered cell " + this.cell.toString());
		this.cell.highlight();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		gb.printinfo(ge.getPlayInfo());
		
		if(!ge.isGameActive()) {
			return;
		}
		//System.out.println("Mouse exited on cell " + this.cell.toString());
		this.cell.unHighlight();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

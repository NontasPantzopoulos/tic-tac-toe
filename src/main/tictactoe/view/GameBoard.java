package main.tictactoe.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import main.tictactoe.model.GameEngine;

@SuppressWarnings("serial")
public class GameBoard extends AbstractPanel implements InterfacePanel{
	BoardCell[] cells;
	
	public GameBoard(GameEngine ge, MainWindow mainWindow) {
		super(ge,mainWindow);
		this.cells= new BoardCell[9];	
		initComponents();
	}

	@Override
	public void initComponents() {
		
		this.setBackground(Color.WHITE);
		this.setBorder(new EmptyBorder(50, 50, 100, 50) );
		this.setLayout(new GridLayout(3,3));
		
		for (int row=0; row< 3; row++) {
			for (int col=0; col< 3; col++) {
				BoardCell cell = new BoardCell(row, col,super.getGe(),super.getMainWindow());
				this.add(cell);
			}
		}	
	}
	
	/** 
	 * Computes the cell size along with paddings (min Panel dimension / 5) */
	private int cellSize() {
		int minDim = Integer.min(this.getWidth(),this.getHeight());
		
		return minDim/5;
	}

	/** Returns the internal size of the real board */
	private int boardSize() {
		return 3*cellSize();
	}
	
	/**
	 * Returns the upper left corner of the board */
	private Point boardZero() {
		int x= (this.getWidth() - boardSize())/2;
		int y= (this.getHeight() - boardSize())/2;
		return new Point(x,y);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}		
	
	public GameEngine getGe() {
		return ge;
	}

	public void setGe(GameEngine ge) {
		this.ge = ge;
	}
	
}

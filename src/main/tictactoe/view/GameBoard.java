package main.tictactoe.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.tictactoe.controller.BoardCellController;
import main.tictactoe.model.GameEngine;

@SuppressWarnings("serial")
public class GameBoard extends AbstractPanel implements InterfacePanel{
	BoardCell[] cells;
	private JPanel infopanel;
	private JPanel gamepanel;
	private JLabel infoLabel;
	
	public GameBoard(GameEngine ge, MainWindow mainWindow) {
		super(ge,mainWindow);
		this.infopanel=new JPanel();
		this.gamepanel=new JPanel();
		this.infoLabel= new JLabel("");
		this.cells= new BoardCell[9];
		this.addMouseListener(new BoardCellController(new BoardCell(10,10,ge,mainWindow,this),ge,this));
		initComponents();
	}

	@Override
	public void initComponents() {
		this.setLayout(new BorderLayout());
		this.infopanel.add(infoLabel);
		this.infopanel.setPreferredSize(new Dimension(250,50));
		this.gamepanel.setBackground(Color.WHITE);
		this.gamepanel.setBorder(new EmptyBorder(10, 10, 100, 10) );
		this.gamepanel.setLayout(new GridLayout(3,3));
		
		for (int row=0; row< 3; row++) {
			for (int col=0; col< 3; col++) {
				BoardCell cell = new BoardCell(row, col,super.getGe(),super.getMainWindow(),this);
				this.gamepanel.add(cell);
			}
		}	
		this.add(infopanel,BorderLayout.NORTH);
		this.add(gamepanel,BorderLayout.CENTER);
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
	
	public void printinfo(String info) {
		this.infoLabel.setText(info);
		this.infoLabel.repaint();
		this.infoLabel.revalidate();
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

package main.tictactoe.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.tictactoe.model.GameEngine;







@SuppressWarnings("serial")
public class GameBoard extends JPanel{
	private GameEngine ge;
	BoardCell[] cells;
	
	public GameBoard(GameEngine ge) {
		this.setGe(ge);
		this.cells= new BoardCell[9];	
		initComponents();
	}


	private void initComponents() {
		
		this.setBackground(Color.WHITE);
		this.setBorder(new EmptyBorder(50, 50, 100, 50) );
		this.setLayout(new GridLayout(3,3));
		
		for (int row=0; row< 3; row++) {
			for (int col=0; col< 3; col++) {
				BoardCell cell = new BoardCell(row, col,ge);
//				JLabel cell=new JLabel();
//				cell.setText("cell"+row+""+col);
//				cell.setName("cell"+row+""+col);
				this.add(cell);
			}
		}
		
//		this.setLayout(null);
//		setSize(new Dimension(MainWindow.WIDTH-2*MainWindow.PLAYER_WIDTH, MainWindow.HEIGHT-MainWindow.TOP_HEIGHT));
//		
//		for (int row=0; row< 3; row++) {
//			for (int col=0; col< 3; col++) {
//				BoardCell cell = new BoardCell(row, col);
//				cell.setBounds(
//						boardZero().x+col*cellSize()+BoardCell.CELL_PADDING,
//						boardZero().y+row*cellSize()+BoardCell.CELL_PADDING,
//						cellSize()-2*BoardCell.CELL_PADDING,
//						cellSize()-2*BoardCell.CELL_PADDING
//						);
//				this.add(cell);
				//System.out.println(cell.getBounds());
//			}
//		}	
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
		//drawGrid(g);
	}		
	
	
	/** 
	 * Draws the grid lines of the board
	 * @param g Graphics2D implicit object 
	*/
//	public void drawGrid(Graphics g) {
//		Graphics2D g2d = (Graphics2D)g;
//		g2d.setStroke(new BasicStroke(6));
//		for (int i=1; i<=2; i++) {
//			//Draw Vertical Line
//			g2d.drawLine(
//					boardZero().x +i*cellSize(),boardZero().y, 				// i-based x,  	upperLeft.y 
//					boardZero().x+i*cellSize(),boardZero().y+boardSize() 	// i-based x,	boardBottom.y (boardBottom = y + boardSize)
//					);
//			
//			//Draw Horizontal Line
//			g2d.drawLine(
//					boardZero().x,  boardZero().y+i*cellSize(), 			// upperLeft.x, i-based y
//					boardZero().x+boardSize(), boardZero().y+i*cellSize()	// boardRight.x, i-based y (boardRight = x + boardSize)
//					);
//		}
//		
//	}


	public GameEngine getGe() {
		return ge;
	}


	public void setGe(GameEngine ge) {
		this.ge = ge;
	}
	
	


//	public JPanel getPanel() {
//		return panel;
//	}
//
//
//	public void setPanel(JPanel panel) {
//		this.panel = panel;
//	}
	
	

}

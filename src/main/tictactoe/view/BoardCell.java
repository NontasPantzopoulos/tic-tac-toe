package main.tictactoe.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import main.tictactoe.controller.BoardCellController;
import main.tictactoe.model.GameEngine;
import main.tictactoe.model.enums.Signs;
import main.tictactoe.utils.GeneralUtils;


@SuppressWarnings("serial")
public class BoardCell  extends AbstractPanel  {
	public static final int CELL_PADDING = 10;
	int row, col;	
	public boolean highlighted;
	private GameBoard gb;
	

	public BoardCell(int row, int col,GameEngine ge,MainWindow mainWindow,GameBoard gb) {
		super(ge,mainWindow);
		this.setBackground(Color.WHITE);
		this.addMouseListener(new BoardCellController(this, ge,gb));
		this.row = row;
		this.col = col;
		this.highlighted = false;
	}

	public void highlight() {
		if (!highlighted ) {
			highlighted = true;
			
		}
	}

	public void unHighlight() {
		if (highlighted ) {
			highlighted = false;
			
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(!ge.isGameActive()) {
			super.getMainWindow().getBannerPanel().activateDoneButton();
		}else {
			super.getMainWindow().getBannerPanel().deActivateDoneButton();
		}
			
		this.setBorder(new LineBorder(Color.DARK_GRAY, 3));
		String mark = Signs.EMPTY.toString();
		if(ge.getMoves()>0) {
			mark = ge.getBoard()[ge.getMoves()-1].getBoard()[row][col];
		}else {
//			mark = ge.getBoard()[ge.getMoves()].getBoard()[row][col];
			
		}
		
		Graphics2D g2d = (Graphics2D) g;
		int size = 125;

		g2d.setStroke(new BasicStroke(6));
		if (mark == Signs.EMPTY.toString()) {
			if (highlighted) {
				g2d.setColor(Color.LIGHT_GRAY);
				g2d.fillRect(CELL_PADDING, CELL_PADDING, size, size);
			}
		} else if (mark==Signs.X.toString()) {
			g2d.drawLine(CELL_PADDING, CELL_PADDING, CELL_PADDING + size, CELL_PADDING + size);
			g2d.drawLine(CELL_PADDING + size, CELL_PADDING, CELL_PADDING, CELL_PADDING + size);
		} else {
			g2d.drawOval(CELL_PADDING, CELL_PADDING, size, size);
		}

	}

	@Override
	public String toString() {
		return "(" + this.row + "," + this.col + ")";
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}


}

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
import main.tictactoe.utils.GeneralUtils;


@SuppressWarnings("serial")
public class BoardCell  extends JPanel  {
	
	private BoardCellController boardCellController;
	private GameEngine ge;
	public static final int CELL_PADDING = 10;
	int row, col;	
	public boolean highlighted;
	

	public BoardCell(int row, int col,GameEngine ge) {
		this.ge = ge;
		this.boardCellController = new BoardCellController(this, ge);
		this.setBackground(Color.WHITE);
		this.addMouseListener(this.boardCellController);
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
		this.setBorder(new LineBorder(Color.DARK_GRAY, 3));
		String mark = null;
		try {
			mark = ge.getBoard()[ge.getMoves()].getBoard()[row][col];
		}catch (Exception e) {
			mark =null;
			GeneralUtils.log("BoardCell", row+","+col+" has null value");
		}
		
//		String mark = null;
		Graphics2D g2d = (Graphics2D) g;
		int size = 125;
//		int size = this.getSize().width - 2 * CELL_PADDING;
		g2d.setStroke(new BasicStroke(6));
		if (mark == null) {
			if (highlighted) {
				g2d.setColor(Color.LIGHT_GRAY);
				g2d.fillRect(CELL_PADDING, CELL_PADDING, size, size);
			}
			return;
		} else if (mark.equals("X")) {
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


}

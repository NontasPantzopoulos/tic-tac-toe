package main.tictactoe.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class BoardCell  extends JPanel implements MouseListener {

	public static final int CELL_PADDING = 10;

	int row, col;	

	public boolean highlighted;

	public BoardCell(int row, int col) {
		
		this.row = row;
		this.col = col;
		this.highlighted = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse entered cell " + this);
		this.highlight();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Mouse exited on cell " + this);
		this.unHighlight();
	}

	private void highlight() {
		if (!highlighted ) {
			highlighted = true;
			
		}
	}

	private void unHighlight() {
		if (highlighted ) {
			highlighted = false;
			
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBorder(new LineBorder(Color.DARK_GRAY, 1));

		//String mark = getModel().getBoardMark(this.row, this.col);
		String mark = "X";
		Graphics2D g2d = (Graphics2D) g;
		int size = 1024 - 2 * CELL_PADDING;
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

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked on cell " + this);
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
}

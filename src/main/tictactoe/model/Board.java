package main.tictactoe.model;

public final class Board {
	private final String[][] board;

	public Board(String[][] board) {
		this.board = new String[3][3];
	}

	public String[][] getBoard() {
		return board;
	} 
	
	

}

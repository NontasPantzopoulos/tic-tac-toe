package main.tictactoe.model;

import java.util.Arrays;

import main.tictactoe.model.enums.Signs;

public final class Board {
	private final String[][] board;

	public Board() {
		String[][] emptyBoard= new String[3][3];
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				emptyBoard[row][col]=Signs.EMPTY.toString();
			}
		}
		this.board = emptyBoard;
	}
	
	public Board(String[][] b) {
		this.board = b;
	}

	public String[][] getBoard() {
		return board;
	}
	
	public int getNumOfNullCells(){
		int nullcounter = 0;
		for (int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				if(this.board[row][col]==null) {
					nullcounter++;
				}
			}
		}
		return nullcounter;
	}
	
	public int getNumOfFullCells(){
		int fullcounter = 0;
		for (int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				if(this.board[row][col]!=null) {
					fullcounter++;
				}
			}
		}
		return fullcounter;
	}
	
	public int getNumOfX(){
		int xcounter = 0;
		for (int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				if(this.board[row][col]!=null && this.board[row][col].equals("X")) {
					xcounter++;
				}
			}
		}
		return xcounter;
	}
	
	public int getNumOfO(){
		int ocounter = 0;
		for (int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				if(this.board[row][col]!=null && this.board[row][col].equals("O")) {
					ocounter++;
				}
			}
		}
		return ocounter;
	}
	
	public boolean isValid() {
		int xCount=getNumOfX();
		int oCount=getNumOfO();
		if(xCount == oCount || xCount == oCount + 1) {
			// Check if 'O' is winner 
			if(isWin("O")) {
				// Check if 'X' is also winner, then 
                // return false 
				if(isWin("X")) {
					return false;
				}
				// Else return true xCount and yCount are same 
				return (xCount == oCount);
			}
		}
		// If 'X' wins, then count of X must be greater 
		if (isWin("X") && xCount != oCount + 1) {
            return false;
        }
		// If 'O' is not winner, then return true 
		return true;
	}
	
	public boolean isWin(String s) {
		//check first row
		if(this.board[0][0]==s && this.board[0][1]==s && this.board[0][2]==s) {
			return true;
		}
		//check 2nd row
		if(this.board[1][0]==s && this.board[1][1]==s && this.board[1][2]==s) {
			return true;
		}
		//check 3rd row
		if(this.board[2][0]==s && this.board[2][1]==s && this.board[2][2]==s) {
			return true;
		}
		//check first col
		if(this.board[0][0]==s && this.board[1][0]==s && this.board[2][0]==s) {
			return true;
		}
		//check 2nd col
		if(this.board[0][1]==s && this.board[1][1]==s && this.board[2][1]==s) {
			return true;
		}
		//check 3rd col
		if(this.board[0][2]==s && this.board[1][2]==s && this.board[2][2]==s) {
			return true;
		}
		//check first diagonal
		if(this.board[0][0]==s && this.board[1][1]==s && this.board[2][2]==s) {
			return true;
		}
		//check 2nd diagonal
		if(this.board[0][2]==s && this.board[1][1]==s && this.board[2][0]==s) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder boardStr = new StringBuilder();
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				boardStr.append(this.board[row][col]+" ");
			}
			boardStr.append("\n");
		}
		
		return boardStr.toString();
	}

}

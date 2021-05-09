package main.tictactoe.model;

import main.tictactoe.model.enums.Signs;

/**
 * The Board class is an immutable class.
 * It represents the tic tac toe game board logically.
 *
 */
public class Board implements Cloneable{
	private String[][] board;
	
	//Constructor
	public Board() {
		String[][] emptyBoard= new String[3][3];
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				emptyBoard[row][col]=Signs.EMPTY.toString();
			}
		}
		this.board = emptyBoard;
	}
	
	//Getters and Setters
	public Board(String[][] b) {
		this.board = b;
	}

	public String[][] getBoard() {
		return board;
	}
	
	/**
	 * Returns the number of empty cells of a board
	 * @return int
	 */
	public int getNumOfNullCells(){
		int nullcounter = 0;
		for (int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				if(this.board[row][col]==null || this.board[row][col].equals(Signs.EMPTY.toString())) {
					nullcounter++;
				}
			}
		}
		return nullcounter;
	}
	
	/**
	 * Returns the number of filled cells of a board
	 * @return int
	 */
	public int getNumOfFullCells(){
		int fullcounter = 0;
		for (int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				if(this.board[row][col].equals(Signs.O.toString()) || this.board[row][col].equals(Signs.X.toString())) {
					fullcounter++;
				}
			}
		}
		return fullcounter;
	}
	
	/**
	 * Returns the number of X's
	 * @return int
	 */
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
	
	/**
	 * Returns the number of O's
	 * @return int
	 */
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
	
	
	
	/**
	 * Returns true if a Board is valid, according to the regulations of the game
	 * @return boolean
	 */
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
	
	/**
	 * Ths method takes as parameter a String (X or O) and checks if its the winner
	 * @param s
	 * @return boolean
	 */
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
	
	/**
	 * Sets the sign param to the corresponding position
	 * @param row The number of the row
	 * @param col The number of the column
	 * @param sign The Sign X or O
	 */
	public void setSign(int row,int col,Signs sign) {
		this.board[row][col]=sign.toString();
		
	}
	
	/**
	 * Gets a deep copy of the Board
	 * @return a copy of the Board class
	 */
	public Board getDeepCopy () {
        Board board = new Board();

        for (int i = 0; i < board.board.length; i++) {
            board.board[i] = this.board[i].clone();
        }

        
        return board;
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
	
	//Clone method
	@Override
	public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

}

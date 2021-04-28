package main.tictactoe.model.enums;

public enum PlayerResult {
	WINNER("WINNER"),
	LOOSER("LOOSER"),
	DRAW("DRAW");
	
	private String result;

	private PlayerResult(String result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return result;
	}
	
	
	

}

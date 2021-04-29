package main.tictactoe.model.enums;

public enum Signs {
	X("X"),
	O("O");
	
	private String sign;

	private Signs(String result) {
		this.sign = result;
	}
	
	@Override
	public String toString() {
		return sign;
	}

}

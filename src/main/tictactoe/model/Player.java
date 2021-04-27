package main.tictactoe.model;

public class Player {
	private String name;

	
	
	
	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		String pname = name.strip();
		if(pname.length()>20) {
			pname = pname.substring(0, 20);
		}
		this.name = pname;
	}
	
	
	

}

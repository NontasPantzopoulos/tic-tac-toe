package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.tictactoe.model.Board;

public class BoardTest222 {
	private Board b1;

	@Before
	public void setUp() throws Exception {
		String[][] stringB1 = {{"X","_","O"},
								{"X","_","O"},
								{"X","_","O"}};
		b1 = new Board(stringB1);
	}

	@Test
	public void testGetBoard() {
		
//		fail("Not yet implemented");
	}

	@Test
	public void testIsValid() {
		System.out.println("etrexe");
		assertTrue("This should be false", b1.isValid());
//		fail("Not yet implemented");
	}

	@Test
	public void testIsWin() {
//		fail("Not yet implemented");
	}

}

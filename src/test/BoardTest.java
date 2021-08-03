package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.tictactoe.model.Board;

public class BoardTest {
	
	private Board b1;
	private Board b2;
	private Board b3;

	@Before
	public void setUp() throws Exception {
		String[][] stringB1 = {{"X","_","O"},
								{"X","_","O"},
								{"X","_","O"}};
		
		String[][] stringB2 = {{"_","_","O"},
								{"X","X","O"},
								{"X","_","_"}};
		
		String[][] stringB3 = {{"_","_","O"},
								{"X","X","O"},
								{"X","_","O"}};
		
		b1 = new Board(stringB1);
		b2 = new Board(stringB2);
		b3 = new Board(stringB3);
	}

	@Test
	public void testGetNumOfNullCells() {
		assertEquals(3,b1.getNumOfNullCells());
		assertEquals(4,b2.getNumOfNullCells());
		
	}

	@Test
	public void testGetNumOfFullCells() {
		assertEquals(6,b1.getNumOfFullCells());
		assertEquals(5,b2.getNumOfFullCells());
	}

	@Test
	public void testGetNumOfX() {
		assertEquals(3,b1.getNumOfX());
		assertEquals(3,b2.getNumOfX());
		
	}

	@Test
	public void testGetNumOfO() {
		assertEquals(3,b1.getNumOfO());
		assertEquals(2,b2.getNumOfO());
	}

	@Test
	public void testIsValid() {
		assertFalse(b1.isValid());
		assertTrue(b2.isValid());
	}

	@Test
	public void testIsWin() {
		assertTrue(b3.isWin("O") && b3.isValid());
		assertFalse(b3.isWin("X") && b3.isValid());
	}

}

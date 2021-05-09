package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.tictactoe.ai.MiniMax;
import main.tictactoe.model.Board;
import main.tictactoe.model.enums.Signs;

public class MiniMaxTest {
	private Board b;
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testGetBestMove() {
		String[][] stringB3 = {{"X","X","O"},
								{"_","O","_"},
								{"_","_","_"}};
		b = new Board(stringB3);
		int[] bestMove = MiniMax.getBestMove(b,Signs.X);
		System.out.println(bestMove[0]+","+bestMove[1]);
	}

}

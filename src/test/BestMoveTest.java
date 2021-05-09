package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import main.tictactoe.ai.BestMove;
import main.tictactoe.model.Board;
import main.tictactoe.model.enums.Signs;

public class BestMoveTest {
	private Board b;
	@Before
	public void setUp() throws Exception {
		String[][] stringB3 = {{"X","X","O"},
								{"_","O","_"},
								{"X","_","O"}};
		b = new Board(stringB3);
	}

	@Test
	public void testGetBestMove() {
		int[] bestMove = BestMove.getBestMove(b.getDeepCopy(), Signs.X);
		System.out.println(bestMove[0]+","+bestMove[1]);
	}

}

package test;

import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

import main.tictactoe.ai.AlphaBetaPruning;
import main.tictactoe.model.Board;
import main.tictactoe.model.enums.Signs;

public class AlphaBetaPruningTest {
	private Board b3;

	@Before
	public void setUpBeforeClass() throws Exception {
		String[][] stringB3 = {{"X","X","O"},
								{"_","O","_"},
								{"_","_","_"}};
		b3 = new Board(stringB3);
		
	}

	@Test
	public void testBestMove() throws CloneNotSupportedException {
		int[] bestMove = AlphaBetaPruning.bestMove(b3.getDeepCopy(), Signs.X,5);
		System.out.println(bestMove[0]+","+bestMove[1]);
	}

}

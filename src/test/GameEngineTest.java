package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.tictactoe.model.GameEngine;

public class GameEngineTest {
	private GameEngine ge;

	@Before
	public void setUpBeforeClass() throws Exception {
		ge = new GameEngine();
		
	}

	

	@Test
	public void testMakeMove() {
		ge.setPlayerX(ge.getPlayerRoster().findPlayerByName("Player 0"));
		ge.setPlayerO(ge.getPlayerRoster().findPlayerByName("Player 1"));
		System.out.println(ge.getPlayerX().getName());
		System.out.println(ge.getPlayerO().getName());
		ge.setGameActive(true);
		System.out.println(ge.isGameActive());
		System.out.println(ge.getMoves());
		ge.makeMove(0, 0);
		ge.makeMove(0, 1);
		ge.makeMove(0, 2);
		ge.makeMove(1, 0);
		ge.makeMove(1, 1);
		ge.makeMove(1, 2);
		ge.makeMove(2, 0);
		ge.makeMove(2, 1);
		ge.makeMove(2, 2);
		System.out.println(ge.getMoves());
		System.out.println(ge.getPlayInfo());
		assertEquals("Player X is Winner!", ge.getPlayInfo());
	}

	

}

package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.tictactoe.io.FileHandler;
import main.tictactoe.model.Player;
import main.tictactoe.model.PlayerRoster;

public class FileHandlerTest {
	PlayerRoster roster = new PlayerRoster();
	Player p1 = new Player("p1");
	Player p2 = new Player("p2");
	Player p3 = new Player("p3");
	Player p4 = new Player("p4");
	Player p5 = new Player("p5");
	Player p6 = new Player("p6");

	@Before
	public void setUp() throws Exception {
		p1.addWin();
		p1.addWin();
		p1.addWin();
		p1.addDraw();
		p2.addLoss();
		p2.addLoss();
		p2.addDraw();
		p3.addDraw();
		p4.addWin();
		p4.addWin();
		
		
		roster.addPlayer(p1);
		roster.addPlayer(p2);
		roster.addPlayer(p3);
		roster.addPlayer(p4);
		roster.addPlayer(p5);
		roster.addPlayer(p6);
		FileHandler.writePlayerRoster(roster);
	}

	@Test
	public void testReadPlayerRoster() {
		PlayerRoster playerRoster = FileHandler.readPlayerRoster();
		assertEquals("Should have same name",p1.getName(), playerRoster.findPlayerByName("p1").getName());
		assertEquals("Should have same score",p1.getScore(), playerRoster.findPlayerByName("p1").getScore(),0.0f);
		assertEquals("Should have same wins",p1.getWins(), playerRoster.findPlayerByName("p1").getWins());
		assertEquals("Should have same losses",p1.getLosses(), playerRoster.findPlayerByName("p1").getLosses());
		assertEquals("Should have same draws",p1.getDraws(), playerRoster.findPlayerByName("p1").getDraws());
		
		assertEquals("Should have same name",p2.getName(), playerRoster.findPlayerByName("p2").getName());
		assertEquals("Should have same score",p2.getScore(), playerRoster.findPlayerByName("p2").getScore(),0.0f);
		assertEquals("Should have same wins",p2.getWins(), playerRoster.findPlayerByName("p2").getWins());
		assertEquals("Should have same losses",p2.getLosses(), playerRoster.findPlayerByName("p2").getLosses());
		assertEquals("Should have same draws",p2.getDraws(), playerRoster.findPlayerByName("p2").getDraws());
		
		assertEquals("Should have same name",p3.getName(), playerRoster.findPlayerByName("p3").getName());
		assertEquals("Should have same score",p3.getScore(), playerRoster.findPlayerByName("p3").getScore(),0.0f);
		assertEquals("Should have same wins",p3.getWins(), playerRoster.findPlayerByName("p3").getWins());
		assertEquals("Should have same losses",p3.getLosses(), playerRoster.findPlayerByName("p3").getLosses());
		assertEquals("Should have same draws",p3.getDraws(), playerRoster.findPlayerByName("p3").getDraws());
		
		assertEquals("Should have same name",p4.getName(), playerRoster.findPlayerByName("p4").getName());
		assertEquals("Should have same score",p4.getScore(), playerRoster.findPlayerByName("p4").getScore(),0.0f);
		assertEquals("Should have same wins",p4.getWins(), playerRoster.findPlayerByName("p4").getWins());
		assertEquals("Should have same losses",p4.getLosses(), playerRoster.findPlayerByName("p4").getLosses());
		assertEquals("Should have same draws",p4.getDraws(), playerRoster.findPlayerByName("p4").getDraws());
		
		assertEquals("Should have same name",p5.getName(), playerRoster.findPlayerByName("p5").getName());
		assertEquals("Should have same score",p5.getScore(), playerRoster.findPlayerByName("p5").getScore(),0.0f);
		assertEquals("Should have same wins",p5.getWins(), playerRoster.findPlayerByName("p5").getWins());
		assertEquals("Should have same losses",p5.getLosses(), playerRoster.findPlayerByName("p5").getLosses());
		assertEquals("Should have same draws",p5.getDraws(), playerRoster.findPlayerByName("p5").getDraws());
		
		assertEquals("Should have same name",p6.getName(), playerRoster.findPlayerByName("p6").getName());
		assertEquals("Should have same score",p6.getScore(), playerRoster.findPlayerByName("p6").getScore(),0.0f);
		assertEquals("Should have same wins",p6.getWins(), playerRoster.findPlayerByName("p6").getWins());
		assertEquals("Should have same losses",p6.getLosses(), playerRoster.findPlayerByName("p6").getLosses());
		assertEquals("Should have same draws",p6.getDraws(), playerRoster.findPlayerByName("p6").getDraws());
		
	}


}

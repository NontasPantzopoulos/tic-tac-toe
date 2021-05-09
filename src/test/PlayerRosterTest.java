package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.tictactoe.io.FileHandler;
import main.tictactoe.model.Player;
import main.tictactoe.model.PlayerRoster;

public class PlayerRosterTest {
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
		
	}
	
	@Test
	public void addPlayerToRoster() {
		String tempName = "p1";
		Player tempPlayer = new Player(tempName);
		//total games 200
		tempPlayer.setWins(100);
		tempPlayer.setDraws(50);
		tempPlayer.setLosses(50);
		roster.addPlayer(tempPlayer);
		assertNotEquals("Players should not be the same.",tempPlayer,roster.findPlayerByName(tempPlayer.getName()));
		assertNotEquals("Total games should not be the same.",tempPlayer.getTotalGames(),roster.findPlayerByName(tempName));
		
		
	}

	@Test
	public void testFindPlayerNames() {
		ArrayList<String> players = roster.findPlayerNames(); 
		assertNotNull("Should not be null",players);
		players.forEach(x->{
			assertNotNull("Name Should not be null",x);
		});

	}

	@Test
	public void testFindPlayerByName() {
		assertEquals("Should be p1",p1,roster.findPlayerByName("p1"));
		assertEquals("Should be p2",p2,roster.findPlayerByName("p2"));
		assertEquals("Should be p3",p3,roster.findPlayerByName("p3"));
		assertEquals("Should be p4",p4,roster.findPlayerByName("p4"));

	}

	@Test
	public void testFindHallOfFame() {
		int top=3;
		Player[] players = roster.findHallOfFame(top);
		assertEquals("Should be "+top,top,players.length);
		
		for(int i=0;i<players.length;i++) {
			System.out.println("Testing Player:"+players[i].getName()+" Score"+players[i].getScore());
		}
	
	}
	
	@After
	public void deleteFile() {
		FileHandler.deletePlayerRosterFile();
	}
	
	

}

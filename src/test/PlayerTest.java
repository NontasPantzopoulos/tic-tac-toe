package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import main.tictactoe.model.Player;

public class PlayerTest {
	Player p1;
	Player p2;
	Player p3;
	Player p;
	int wins=23;
	int losses=19;
	int draws=43;
	

	@Before
	public void setUp() throws Exception {
		p1 = new Player("   Player1    ");
		p2 = new Player("   The Quick Brown Fox Jumps Over Lazy Dog    ");
		
		p = new Player("MyPlayer");
		p.setWins(wins);
		p.setLosses(losses);
		p.setDraws(draws);
	}

	@Test
	public void testGetName() {
		assertEquals("The name should be Player1","Player1", p1.getName());
		assertEquals("The length of the name should be 20",20, p2.getName().length());
		
	}

	@Test
	public void testSetName() {
		assertNull("P3 Should be null",this.p3);
		this.p3 =new Player("           -AName-            ");
		assertNotNull("p3 Name should not be null",this.p3.getName());
		assertEquals("The Name should be -AName-","-AName-",p3.getName());
	}
	
	@Test
	public void testTotalgames() {
		//wins+losses+draws=23+19+43=85
		assertEquals("Total games should be "+(wins+losses+draws),(wins+losses+draws),p.getTotalGames());
	}
	
	
	@Test
	public void testScores() {	
		float score = (50*(2*wins+draws))/(wins+losses+draws);
		assertEquals("The score should be "+score,score,p.getScore(),0.0f);
	}

}

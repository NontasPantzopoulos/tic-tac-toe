package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.tictactoe.model.Player;

public class PlayerTest {
	Player p1;
	Player p2;
	Player p3;
	

	@Before
	public void setUp() throws Exception {
		p1 = new Player();
		p2 = new Player();
		p1.setName("   Player1    ");
		p2.setName("   The Quick Brown Fox Jumps Over Lazy Dog    ");
	}

	@Test
	public void testGetName() {
		assertEquals("The name should be Player1","Player1", p1.getName());
		assertEquals("The length of the name should be 20",20, p2.getName().length());
		
	}

	@Test
	public void testSetName() {
		assertNull("P3 Should be null",this.p3);
		this.p3 =new Player();
		this.p3.setName("           -AName-            ");
		assertNotNull("p3 Name should not be null",this.p3.getName());
		assertEquals("The Name should be -AName-","-AName-",p3.getName());
	}

}

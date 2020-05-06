import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BowlingGameTest {

	private Game g;
	
	@Before
	public void setUp() {
		g = new Game();
	}

	public void rollMany(int roll, int pins) {
		for(int i = 0; i < roll; i++) {
			g.roll(pins);
		}
	}
	
	public void spare() {
		g.roll(5);
		g.roll(5);
	}
	
	public void rollStrike() {
		g.roll(10);
	}
	

	@Test
	public void testGutterGame() {
		rollMany(20, 0);
		assertEquals(0, g.score());
	}

	@Test
	public void testAllOnes() {
		rollMany(20,1);
		assertEquals(20, g.score());
	}
	
	@Test
	public void testOneSpare() {
		spare(); //spare
		g.roll(3);
		rollMany(17,0);
		assertEquals(16, g.score());
	}
	
	@Test
	public void testOnesStrike() {
		rollStrike();
		g.roll(3);
		g.roll(4);
		rollMany(16, 0);
		assertEquals(24, g.score());
		
	}
	
	@Test
	public void testPerfectGame() {
		rollMany(12,10);
		assertEquals(300, g.score());
	}
	
	@Test
	public void testTwoStrikes() {
		rollStrike();
		rollStrike();
		rollMany(0, 16);
		assertEquals(30, g.score());
	}

	

	

}

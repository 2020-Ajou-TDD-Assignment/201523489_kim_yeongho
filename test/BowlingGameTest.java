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
		g.roll(5);
		g.roll(5); //spare
		g.roll(3);
		rollMany(17,0);
		assertEquals(16, g.score());
	}

}

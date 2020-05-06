import static org.junit.Assert.*;

import org.junit.Before;
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

}

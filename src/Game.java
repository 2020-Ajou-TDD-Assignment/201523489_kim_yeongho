
public class Game {

	
	private int[] rolls = new int[21];
	private int currentRoll = 0;

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}
	
	public int score() {
		int score = 0;
		int rollIndex = 0;
		for( int frame = 0; frame < 10; frame++) {
			if( isStrike(rollIndex) ) { 
				score += 10 + processStrike(rollIndex);
				rollIndex++;
			} else if( isSpare(rollIndex)) { 
				score += 10 + rolls[rollIndex + 2];
				rollIndex += 2;
			} else {
				score += rolls[rollIndex] + rolls[rollIndex + 1];
				rollIndex += 2;
			}
			
		}
		
		return score;
	}
	
	public boolean isSpare(int rollIndex) {
		return rolls[rollIndex] + rolls[rollIndex+1] == 10;
	}
	
	public boolean isStrike(int rollIndex) {
		return rolls[rollIndex] == 10;
	}
	
	public int processStrike(int rollIndex) {
		return rolls[rollIndex + 1] + rolls[rollIndex + 2];
	}



}

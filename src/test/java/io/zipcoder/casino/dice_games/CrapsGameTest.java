package io.zipcoder.casino.dice_games;

import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsGameTest {

	@Test
	public void sumOfDice() {
		CrapsGame game = new CrapsGame();

		for (int i = 0; i < 10; i++) {
			if(game.rollDice())
				System.out.println("win");
			else
				System.out.println("loss");
		}
	}
}

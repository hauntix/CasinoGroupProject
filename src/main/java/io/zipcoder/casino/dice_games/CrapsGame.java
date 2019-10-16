package io.zipcoder.casino.dice_games;

import java.util.Random;

public class CrapsGame extends DiceGame{

	CrapsGame() {
		this.setNumOfDice(2);
	}

	public int sumOfDice() {
		int sum = 0;
		Random random = new Random();
		// max - min range and add 1
		int range = 6-1 +1;


		for (int i = 0; i < this.getNumOfDice(); i++) {
			sum += random.nextInt(range) + 1;
		}

		return sum;
	}
}

package io.zipcoder.casino.dice_games;

import java.util.Random;

public class CrapsGame extends DiceGame{

	CrapsGame(int numOfPlayers) {
		this.setNumOfPlayers(numOfPlayers);
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

	@Override
	public boolean rollDice() {
		int sum = sumOfDice();

		if (sum == 7 || sum == 11)
			return true;
		if(sum ==2 || sum == 3 || sum == 12)
			return false;

		while (true) {
			int y = sumOfDice();
			if (y ==7)
				return false;
			if (y == sum)
				return true;
		}
	}

	@Override
	public void setNumOfPlayers(int numOfPlayers){
		if(numOfPlayers > 4)
			throw new Error("Only 4 players can play at a time");
		else
			super.setNumOfPlayers(numOfPlayers);
	}
}

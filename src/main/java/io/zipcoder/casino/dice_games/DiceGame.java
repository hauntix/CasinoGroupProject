package io.zipcoder.casino.dice_games;

import io.zipcoder.casino.Interfaces.Igame;

public class DiceGame implements Igame {
	private int numOfPlayers = 2;
	private int numOfDice = 2;

	public void setNumOfDice(int numOfDice) {
		this.numOfDice = numOfDice;
	}

	public int getNumOfDice() {
		return numOfDice;
	}

	public boolean rollDice() {
		return false;
	}

	public void startGame() {

	}

	public void endGame() {

	}

	public void setNumOfPlayers(int numofPlayers) {
		this.numOfPlayers = numofPlayers;
	}

	public int getNumOfPlayers() {
		return numOfPlayers;
	}
}

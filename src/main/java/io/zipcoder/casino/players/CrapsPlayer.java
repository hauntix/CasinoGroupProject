package io.zipcoder.casino.players;

public class CrapsPlayer extends Player implements GamblingPlayer {
	private int totalAmount;

	public CrapsPlayer(String name, int startingAmount) {
		super(name);
		this.totalAmount = startingAmount;
	}

	public void startingAmount(int amount) {
		this.totalAmount = amount;
	}

	public void placeBet(int betAmount) {
		this.totalAmount -= betAmount;
	}

	public void increaseAmount(int amount){
		this.totalAmount += amount;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void nextTurn() {

	}
}

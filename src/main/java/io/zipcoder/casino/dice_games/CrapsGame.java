package io.zipcoder.casino.dice_games;

import io.zipcoder.casino.players.CrapsPlayer;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Random;

public class CrapsGame extends DiceGame{
	private ArrayList<CrapsPlayer> crapsPlayers = new ArrayList<CrapsPlayer>();
	private int wagePool;

	public CrapsGame() {
		this.setNumOfDice(2);
	}

	private int sumOfDice() {
		int sum = 0;
		Random random = new Random();
		// max - min range and add 1
		int range = 6-1 +1;


		for (int i = 0; i < this.getNumOfDice(); i++) {
			sum += random.nextInt(range) + 1;
		}

		return sum;
	}

	private boolean setPlayerWager(int player, int wager) {
		if (this.crapsPlayers.get(player).getTotalAmount() < wager)
			return false;
		else {
			this.crapsPlayers.get(player).placeBet(wager);
			this.wagePool += wager;
			return true;
		}
	}

	private void playerWon(int player) {
		int winnings = (int) (wagePool * 1.5);
		this.crapsPlayers.get(player).increaseAmount(winnings);
		Console console = new Console(System.in, System.out);
		console.println(this.crapsPlayers.get(player).getName() + " won! they get: $" + winnings);
		wagePool = 0;
	}

	@Override
	public void startGame(){
		boolean keepPlaying = true;

		Console console = new Console(System.in, System.out);
		String name = console.getStringInput("What's player 1's name? ");
		int startAmount = console.getIntegerInput("How much money is " + name + " starting with? ");
		crapsPlayers.add(new CrapsPlayer(name, startAmount));

		while (keepPlaying) {
			int wager = console.getIntegerInput("How much would " + name + " like to wager? (Current balance: $" + crapsPlayers.get(0).getTotalAmount() + ")");
			if (setPlayerWager(0, wager)) {


				if (rollDice()) {
					playerWon(0);
				} else {
					console.println("Sorry bruh you lost :(");
					wagePool = 0;
				}

				if(crapsPlayers.get(0).getTotalAmount() > 0) {
					int choice = console.getIntegerInput("Would you like to keep playing? (1)Yes (2)No");

					if (choice == 2)
						keepPlaying = false;
				} else {
					console.println("Sorry " + crapsPlayers.get(0).getName() + " you've run out of money to play. go work the streets or something.");
					keepPlaying = false;
				}
			} else {
				console.println("Sorry you don't have enough to place that wager.");
			}
		}

		console.println("Thanks for playing! You're walking away with: $" + crapsPlayers.get(0).getTotalAmount());
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

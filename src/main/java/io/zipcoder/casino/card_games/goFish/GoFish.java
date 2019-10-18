package io.zipcoder.casino.card_games.goFish;

import io.zipcoder.casino.Interfaces.Igame;
import io.zipcoder.casino.utilities.Console;


public class GoFish implements Igame {
	private Console console = new Console(System.in, System.out);
	private GoFishDeck stock;
	private GoFishDeck userHand;
	private GoFishDeck cpHand;
	private boolean win;
	private int userBooks, cpBooks;

	public GoFish() {
		stock = new GoFishDeck();
		stock.fillDeck();
		userHand = new GoFishDeck();
		cpHand = new GoFishDeck();
		win = false;
		userBooks = cpBooks = 0;
	}

	private void initializeStartingHands() {
		for (int i = 0; i < 7; i++) {
			userHand.insertCard(stock.deleteAnyCard());
			cpHand.insertCard(stock.deleteAnyCard());
		}
	}

	private void checkBeginningDeal() {
		int userBegDeal = userHand.checkBookBeginningDeal();
		if (userBegDeal != 0) {
			console.println("Wow! You got extremely lucky and got a book " +
					"on the deal of the value " + userBegDeal +
					"\nThat puts you at 1 Book already!");
			pause();
			userBooks++;
		}

		int cpBegDeal = cpHand.checkBookBeginningDeal();
		if (cpBegDeal != 0) {
			console.println("Wow! The computer got extremely lucky and got a " +
					"book on the deal of the value " + cpBegDeal +
					"\nThat puts the computer at 1 Book already!");
			pause();
			cpBooks++;
		}
	}

	private void userTurn() {
		boolean retryUser;
		do {
			retryUser = false;
			if (!win) {
				GoFishCard drawnCard;
				userHand.sort();
				console.println(userHand.toString());
				int value = console.getIntegerInput("Which value would you like to ask for?");
				while (userHand.getCount(value) == 0) {
					value = console.getIntegerInput("That Value isnt already contained in your deck, " +
							"Please enter another value");
				}
				int hits = cpHand.getCount(value);
				if (hits == 0) {
					 console.println("Go Fish!");
					drawnCard = stock.deleteAnyCard();
					if (drawnCard.getValue() == value) {
						userHand.insertCard(drawnCard);
						retryUser = true;
						 console.println("Drawn Card: " + drawnCard);
						 console.println("Lucky Draw! Go again.");
						pause();
					} else {
						 console.println("Drawn Card: " + drawnCard);
						userHand.insertCard(drawnCard);
						pause();
					}
					int countAfterGoFish = userHand.getCount(drawnCard.getValue());
					if (countAfterGoFish == 4) {
						userBooks++;
						 console.println("With that Go Fish draw you've just completed a Book" +
								" with the value " + drawnCard.getValue() + "\n" +
								"You now have : " + userBooks + " Books\n" +
								"And the computer has : " + cpBooks + " Books");
						pause();
						for (int i = 0; i < 4; i++) {
							userHand.deleteValue(drawnCard.getValue());
						}
					}
					if (retryUser) {
						checkForGameOver();
					}
				} else if (hits >= 1) {
					for (int i = 0; i < hits; i++) {
						userHand.insertCard(cpHand.deleteValue(value));
					}
					 console.println("The Computer had " + hits + " of those cards");
					retryUser = false;
					pause();
					int countAfterSteal = userHand.getCount(value);
					if (countAfterSteal == 4) {
						userBooks++;
						 console.println("You just got a book from stealing the computer's card(s)" +
								" with the value " + value + "\n" +
								"You now have : " + userBooks + " Books\n" +
								"The computer currently has : " + cpBooks + " Books");
						pause();
						for (int i = 0; i < 4; i++) {
							userHand.deleteValue(value);
						}
					}

				}
			}
		} while (retryUser);
	}

	private void compTurn() {
		boolean retryComp;
		do {
			retryComp = false;
			if (!win) {
				GoFishCard drawnCardCp;
				GoFishCard random = cpHand.deleteAnyCard(); //Randomly pulls asking card from computers hand
				cpHand.insertCard(random);
				int Value = random.getValue();
				int cpHits = userHand.getCount(Value);
				if (cpHits == 0) {
					drawnCardCp = stock.deleteAnyCard();

					//Draw same card as asked from stock deck
					if (drawnCardCp.getValue() == Value) {
						cpHand.insertCard(drawnCardCp);
						retryComp = true;
						console.println("Lucky draw for the computer!\n" +
								"They go again.");
						pause();
					} else {
						 console.println("The computer guessed Wrong..\n" +
								"Your turn.");
						cpHand.insertCard(drawnCardCp);
						pause();
					}
					int cpCountAfterGoFish = cpHand.getCount(drawnCardCp.getValue());
					if (cpCountAfterGoFish == 4) //COMPLETED BOOK IN COMPUTER HAND
					{
						cpBooks++;
						 console.println("The computer just got a book off a Go Fish draw" +
								" with the value " + drawnCardCp.getValue() + "\n" +
								"The computer now has : " + cpBooks + " Books\n" +
								"You currently have : " + userBooks + " Books");
						pause();
						for (int i = 0; i < 4; i++) {
							cpHand.deleteValue(drawnCardCp.getValue());
						}
					}
					if (retryComp) {
						checkForGameOver();
					}
				} else if (cpHits >= 1) {
					for (int i = 0; i < cpHits; i++) {
						cpHand.insertCard(userHand.deleteValue(Value));
					}
					 console.println("The computer took " + cpHits + " of your cards!");
					retryComp = false;
					pause();
					int cpCountAfterSteal = cpHand.getCount(Value);
					if (cpCountAfterSteal == 4) {
						cpBooks++;
						 console.println("The computer just got a book from stealing your card(s)" +
								" with the value " + Value + "\n" +
								"The computer now has : " + cpBooks + " Books\n" +
								"You currently have : " + userBooks + " Books");
						pause();
						for (int i = 0; i < 4; i++) {
							cpHand.deleteValue(Value);
						}
					}
				}
			}
		} while (retryComp);
	}

	private void checkForGameOver() {
		win = (stock.getSize() == 0 || userHand.getSize() == 0
				|| cpHand.getSize() == 0);
	}

	private void displayWinner() {
		if (cpBooks > userBooks) {
			 console.println("The computer Won!\n" +
					"Computer Books : " + cpBooks +
					"\nUser Books : " + userBooks);
		} else if (userBooks > cpBooks) {
			 console.println("Congrats YOU Won!\n" +
					"User Books : " + userBooks +
					"\nComputer Books : " + cpBooks);
		} else {
			 console.println("The game was a tie!\n" +
					"You both had " + userBooks + " books.");
		}
	}

	private void pause() {
		console.getStringInput("Press enter to continue...");
	}

	public void startGame() {
		initializeStartingHands();
		checkBeginningDeal();

		do {
			userTurn();
			checkForGameOver();

			compTurn();
			checkForGameOver();

		} while (!win);

		 console.println("Game Over!");
		displayWinner();
	}

	public void endGame() {

	}
}

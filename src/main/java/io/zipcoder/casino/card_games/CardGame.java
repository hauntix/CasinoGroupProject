package io.zipcoder.casino.card_games;

public class CardGame {
	private int amountOfCards = 0;
	private int amountOfCardsDealt = 0;

	public int getAmountOfCardsDealt() {
		return amountOfCardsDealt;
	}

	public void setAmountOfCardsDealt(int amountOfCardsDealt) {
		this.amountOfCardsDealt = amountOfCardsDealt;
	}

	public void setAmountOfCards(int amountOfCards) {
		this.amountOfCards = amountOfCards;
	}

	public int getAmountOfCards() {
		return amountOfCards;
	}
}

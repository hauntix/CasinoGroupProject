package io.zipcoder.casino.players;

public class KlondikePlayer extends Player implements GamblingPlayer {
  private int playerBalance;

  public KlondikePlayer(String name, int startingAmount) {
    super(name);
    this.playerBalance = startingAmount;
  }

  @Override
  public void placeBet(int betAmount) {

  }

  @Override
  public void nextTurn() {

  }
}

package io.zipcoder.casino.players;

public interface GamblingPlayer {
  int totalAmount = 0;

  void placeBet(int betAmount);

  void nextTurn();
}

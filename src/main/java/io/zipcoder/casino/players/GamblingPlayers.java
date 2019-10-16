package io.zipcoder.casino.players;

public interface GamblingPlayers {
  int totalAmount = 0;

  void placeBet(int betAmount);

  void nextTurn();
}

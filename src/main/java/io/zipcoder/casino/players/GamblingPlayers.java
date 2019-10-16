package io.zipcoder.casino.players;

public interface GamblingPlayers extends Players {
  int betAmount = 0;

  void placeBet(int betAmount);

  void nextTurn();
}

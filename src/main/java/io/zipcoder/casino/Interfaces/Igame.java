package io.zipcoder.casino.Interfaces;

public interface Igame {
    boolean isWin = false;
    int numofPlayers = 0;
    void startGame();
    void endGame();
    int setnumofPlayers(int numofPlayers);
}

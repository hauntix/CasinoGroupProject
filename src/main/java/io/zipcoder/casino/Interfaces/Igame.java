package io.zipcoder.casino.Interfaces;

import io.zipcoder.casino.players.Player;

import java.util.ArrayList;

public interface Igame {
    ArrayList<Player> playerList = new ArrayList<Player>();
    boolean isWin = false;
    void startGame();
    void endGame();
}

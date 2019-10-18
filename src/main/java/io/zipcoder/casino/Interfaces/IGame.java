package io.zipcoder.casino.Interfaces;

import io.zipcoder.casino.players.Player;

import java.util.ArrayList;

public interface IGame {
    ArrayList<Player> playerList = new ArrayList<Player>();
    void startGame();
}

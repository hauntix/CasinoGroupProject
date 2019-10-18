package io.zipcoder.casino.Interfaces;

import io.zipcoder.casino.players.GamblingPlayer;

import java.util.ArrayList;

public interface IGamblingGame extends IGame {
    ArrayList<GamblingPlayer> players = new ArrayList<GamblingPlayer>();

}

package klondikeGame;

import io.zipcoder.casino.dice_games.DiceGame;
import io.zipcoder.casino.players.Player;

import java.util.*;

public class Klondike extends DiceGame {

  Klondike() {
    this.setNumOfDice(5);
  }

  Player player = new Player("Bond, James Bond");
  boolean bankerWins = true;
  boolean playerWins = true;
  List<Integer> list = new ArrayList<Integer>();
  int diceRange = 6 - 1 + 1;
  Random random = new Random();


  public int bankerRoll() {
    int bankerSum = 0;

    for (int i = 0; i < this.getNumOfDice(); i++) {
      bankerSum += random.nextInt(diceRange);
    }
    return bankerSum;
  }

  public int playerRoll() {
    int playerSum = 0;

    for (int i = 0; i < this.getNumOfDice(); i++) {
      playerSum += random.nextInt(diceRange);
    }
    return playerSum;
  }

  public boolean winner() {
    if (playerRoll() == bankerRoll()) {
      return bankerWins;
    } else if (playerRoll() < bankerRoll()) {
      return playerWins;
    } else if (playerRoll() > bankerRoll()) {
      return playerWins;
    }
    return bankerWins
  }
}

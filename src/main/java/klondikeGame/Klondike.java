package klondikeGame;

import io.zipcoder.casino.dice_games.DiceGame;
import io.zipcoder.casino.players.GamblingPlayers;
import io.zipcoder.casino.players.Player;

import java.util.*;

import static io.zipcoder.casino.players.GamblingPlayers.betAmount;

public class Klondike extends DiceGame {

  Klondike() {
    this.setNumOfDice(5);
  }

  Player player = new Player("Bond, James Bond");
  boolean bankerWins = true;
  boolean playerWins = true;
  int placeBet = GamblingPlayers.betAmount;
  String chooseWin = "Win";
  String chooseLose = "Lose";
  String chooseBeatTwoAces = "Beat Two Aces";
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

  public boolean play() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Place bet on Win, Lose, or Beat Two Aces");
    String userMarkedBet = scanner.nextLine();
    System.out.println("You placed a bet on " + userMarkedBet);
    System.out.println("Place your bet amount");
    String userBetAmount = scanner.next();
    System.out.println("You bet " + userBetAmount);
    if (userMarkedBet =  playerRoll() == placeBet) {
      return bankerWins;
    } else if ( && playerRoll() < bankerRoll()) {
      return playerWins;
    } else if (playerRoll() > bankerRoll()) {
      return playerWins;
    }
    return bankerWins;
  }
}

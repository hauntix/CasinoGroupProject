package klondikeGame;

import io.zipcoder.casino.Interfaces.IGamblingGame;
import io.zipcoder.casino.dice_games.DiceGame;
import io.zipcoder.casino.players.GamblingPlayer;

import java.util.*;

public class Klondike extends DiceGame implements IGamblingGame, GamblingPlayer {

  Klondike() {
    this.setNumOfDice(5);
  }

  int placeBet = GamblingPlayer.totalAmount;
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

  public String play() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Place bet on Win or Lose");
    String userMarkedBet = scanner.nextLine();
    System.out.println("You placed a bet on " + userMarkedBet);
    System.out.println("Place your bet amount");
    int userBetAmount = scanner.nextInt();
    System.out.println("You bet " + userBetAmount);


    while (totalAmount > placeBet){
      if (totalAmount > userBetAmount){
        return "Let's begin";
      } else {
        return "You don't have enough money cuz";
      }
    }

    String bankerWins = "Nope, try again, you lost " + userBetAmount + "and have " + totalAmount + " left.";
    String playerWins = "Congrats you won "  + (userBetAmount + totalAmount);


    if (userMarkedBet.contains("Win") && playerRoll() > bankerRoll()) {
      return playerWins;
    } else if(userMarkedBet.contains("Win") && playerRoll() < bankerRoll()){
      return bankerWins;
    } else if (userMarkedBet.contains("Lose") && playerRoll() < bankerRoll()) {
      return playerWins;
    } else if (userMarkedBet.contains("Lose") && playerRoll() > bankerRoll()){
      return bankerWins;
    } else if (playerRoll() == bankerRoll() ) {
      return bankerWins;
    } else {
      return "Thanks for playing";
    }


  }

  public void placeBet(int betAmount) {

  }

  public void nextTurn() {


  }
}

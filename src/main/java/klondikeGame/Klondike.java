package klondikeGame;

import io.zipcoder.casino.Interfaces.Igamblinggame;
import io.zipcoder.casino.dice_games.DiceGame;
import io.zipcoder.casino.players.GamblingPlayer;

import java.util.*;

public class Klondike extends DiceGame implements Igamblinggame, GamblingPlayer {

  private int playerBalance;

  public Klondike(int playerBalance){
    this.playerBalance = playerBalance;
  }

  public int getPlayerBalance() {
    return playerBalance;
  }

  public Klondike() {
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

  @Override
  public void startGame() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Place bet on Win or Lose");
    String userMarkedBet = scanner.nextLine();
    System.out.println("You placed a bet on " + userMarkedBet);
    System.out.println("Place your bet amount");
    int userBetAmount = scanner.nextInt();
    System.out.println("You bet " + userBetAmount);
    String continuePlaying = scanner.nextLine();

    while (playerBalance > 0) {
      System.out.println("You have " + playerBalance + ". Let's begin.");
      if (userBetAmount > playerBalance) {
        System.out.println("Get tf outta here broke azz");
        break;
      }
    }

      String playerWins = "Congrats you won " + userBetAmount + "and have a total bank of " + (userBetAmount + GamblingPlayer.totalAmount)
        + ". /n" + "Continue playing? Type 1 for yes, or 2 for no";

      String playerLoses = "Nope, try again, you lost " + userBetAmount + "and have " +
        (GamblingPlayer.totalAmount - userBetAmount) + " left.";

      while (true) {

        if (continuePlaying.contains("2")) {
          break;
        } else if (userMarkedBet.contains("Win") && playerRoll() > bankerRoll()) {
          System.out.println(playerWins + continuePlaying);
        } else if (userMarkedBet.contains("Win") && playerRoll() < bankerRoll()) {
          System.out.println(playerLoses + continuePlaying);
        } else if (userMarkedBet.contains("Lose") && playerRoll() < bankerRoll()) {
          System.out.println(playerWins + continuePlaying);
        } else if (userMarkedBet.contains("Lose") && playerRoll() > bankerRoll()) {
          System.out.println(playerLoses + continuePlaying);
        } else if (playerRoll() == bankerRoll()) {
          System.out.println(playerLoses + continuePlaying);
        } else if (continuePlaying.contains("2")) {
          System.out.println("Thanks for playing! Please check out our other games around the casino and enjoy our speciality juices!");
        } else {
          System.out.println("You don't have enough money cuz");
        }
      }
    }




  public void placeBet(int betAmount) {

  }

  public void nextTurn() {

  }


}

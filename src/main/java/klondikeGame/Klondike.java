package klondikeGame;

import io.zipcoder.casino.dice_games.DiceGame;
import io.zipcoder.casino.players.GamblingPlayers;
import io.zipcoder.casino.players.Player;

import java.util.*;

import static io.zipcoder.casino.players.GamblingPlayers.betAmount;

public class Klondike extends DiceGame implements Igamblinggame, GamblingPlayer {

  Klondike() {
    this.setNumOfDice(5);
  }

  String bankerWins = "Banker Wins";
  String playerWins = "You Win";
  int placeBet = GamblingPlayer.totalAmount;
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

  public String play() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Place bet on Win or Lose");
    String userMarkedBet = scanner.nextLine();
    System.out.println("You placed a bet on " + userMarkedBet);
    System.out.println("Place your bet amount");
    int userBetAmount = scanner.nextInt();
    System.out.println("You bet " + userBetAmount);
    while (totalAmount > 0){
      if (totalAmount < userBetAmount){
        System.out.println("You don't have enough fucking money");
        break;
      }
    }
    if (userMarkedBet.contains("Win") && playerRoll() > bankerRoll()) {
      return "Congrats you win " + (betAmount + totalAmount);
      return playerWins;
    } else if(userMarkedBet.contains("Win") && playerRoll() < bankerRoll()){
      return "Nope, try again, you lost " + betAmount + "and have " + totalAmount + " left.";
      return bankerWins;
    } else if (userMarkedBet.contains("Lose") && playerRoll() < bankerRoll()) {
      return "Congrats you win " + (betAmount + totalAmount);
      return playerWins;
    } else if (userMarkedBet.contains("Lose") && playerRoll() > bankerRoll()){
      return "Nope, try again, you lost " + betAmount + "and have " + totalAmount + " left.";
      return bankerWins;
    } else if (playerRoll() == bankerRoll() ) {
      return "Nope, try again, you lost " + betAmount + "and have " + totalAmount + " left.";
      return bankerWins;
    } else {
      return "Thanks for playing";
    }

  }
}

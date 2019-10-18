package io.zipcoder.casino.dice_games;

import io.zipcoder.casino.players.ChicagoPlayers;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Random;

public class ChicagoGame extends DiceGame {
  private ArrayList<ChicagoPlayers> chicagoPlayers = new ArrayList<>();

  public ChicagoGame(){
    this.setNumOfDice(2);
  }




  private int sumOfDice() {
    int sum = 0;
    Random random = new Random();
    int range = 6-1 +1;
    for (int i = 0; i < this.getNumOfDice(); i++) {
      sum += random.nextInt(range) + 1;
    }
    return sum;
  }


  int[] gameRounds = {2,3,4,5,6,7,8,9,10,11,12};


  @Override
  public void startGame() {


    boolean continuePlaying = true;
    int sum = sumOfDice();
    int playerScore = 0;
    Console console = new Console(System.in, System.out);

    for (int y = 2; y <= gameRounds.length; y++) {

      while (continuePlaying) {

        if (sum == y) {
          playerScore++;
        } else {
          continue;
        }

        int quitGame = console.getIntegerInput("Would you like to continue playing? Type 1 for Yes and 2 for No");
        if (quitGame == 2){
          continuePlaying = false;
        }
      }
    }
  }



}


/* working through logic before



* for loop that iterates through each round until it reaches round 12
                  (rounds go from 2 - 12)
* each round, player and dealer will roll dice
* if either roll equals the round number, earn one point
* if a roll does not equal the round number, no point earned
* person with most points after 11 rounds wins



*/

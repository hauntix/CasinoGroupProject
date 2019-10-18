package io.zipcoder.casino.dice_games;

import io.zipcoder.casino.players.ChicagoPlayers;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

  public void startGame() {


    boolean continuePlaying = true;
    int playerScore = 0;
    Console console = new Console(System.in, System.out);

    System.out.println("Welcome to the game Chicago, let's begin!");
    int startGame = console.getIntegerInput("Ready to start? Type 1 for Yes and 2 for No");
    if (startGame == 1){
      System.out.println("Starting game now!");
    } else {
      System.out.println("See you den hoe");
      continuePlaying = false;
    }

    while (continuePlaying) {


      for (int y = 2; y <= gameRounds.length; y++) {

        System.out.println("Round: " + y);

        if (sumOfDice() == gameRounds[y - 2]) {
          playerScore++;
          System.out.println("You rolled a " + sumOfDice() + " " + "\n" + "Dealer rolled a " + gameRounds[y - 2]);
          console.println("Congrats you won a point!");
          console.getStringInput("Press Enter for Next Round...");

        } else {
          System.out.println("You rolled a " + sumOfDice() + " " + "\n" + "Dealer rolled a " + gameRounds[y - 2]);
          console.println("You lost this round, no point eared.");
          console.getStringInput("Press Enter for Next Round...");
        }


        if (y == 11){
          int endOfGame = console.getIntegerInput("The game reached 11 rounds, you earned " + playerScore +
            " points. Would you like to play another game? Type 1 for Yes and 2 for No");
          if (endOfGame == 2){
            System.out.println("Thanks for playing! You scored " + playerScore +
              " points. Feel free to check out some other games!");
            continuePlaying = false;
          } else {
            startGame();
          }
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

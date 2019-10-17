package io.zipcoder.casino.dice_games;

import io.zipcoder.casino.Interfaces.Igamblinggame;
import io.zipcoder.casino.players.GamblingPlayer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ChicagoGame extends DiceGame implements Igamblinggame, GamblingPlayer {
  private int totalAmount = 0;

  public ChicagoGame(int startingAmount){
    this.totalAmount=startingAmount;
  }

  int[] gameRounds = {2,3,4,5,6,7,8,9,10,11,12};


  for(int x = 3; x <= gameRounds.length; x++){
  }

  @Override
  public int getNumOfDice() {
    return super.getNumOfDice();
  }

  @Override
  public void placeBet(int betAmount) {

  }

  @Override
  public void nextTurn() {

  }


}


/* working through logic before


* for loop that iterates through each round until it reaches round 12
                  (rounds go from 2 - 12)
* each round, player and dealer will roll dice
* if either roll equals the round number, earn one point
* if a roll does not equal the round number, no point earned
* person with most points after 11 rounds wins*/

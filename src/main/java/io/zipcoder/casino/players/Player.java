package io.zipcoder.casino.players;

import io.zipcoder.casino.Interfaces.IGame;

public class Player {
  private String name;

  public Player(String name){
    this.name = name;
  }

  public void playGame(IGame game){

  }

  public String getName(){
    return this.name;
  }

}

package io.zipcoder.casino.players;


public class ChicagoPlayers extends Player {
  private int totalAmount;

  public ChicagoPlayers(String name, int totalAmount){
    super(name);
    this.totalAmount=totalAmount;
  }

  public int moneyLeft(){
    return totalAmount;
  }

}

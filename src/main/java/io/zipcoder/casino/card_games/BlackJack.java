package io.zipcoder.casino.card_games;

import io.zipcoder.casino.Interfaces.Igamblinggame;
import io.zipcoder.casino.players.GamblingPlayer;

import java.util.Scanner;


public class BlackJack extends CardGame implements Igamblinggame, GamblingPlayer {
    public static void main(String[] args) {

        System.out.println("Welcome To Black Jack Remember The House Always Wins");

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        Deck playerDeck = new Deck();

        Deck dealerDeck = new Deck();

       double playerMoney = 100.00;

        Scanner userInput = new Scanner(System.in);

        //Game Loop
        while (playerMoney>0){
            System.out.println("You Have $" + playerMoney + " Place Your Bet");
            double playerBet = userInput.nextDouble();
            if (playerBet>playerMoney){
                System.out.println("You Can't Bet More Then Your Poor Ass Has Get Out");
                break;
            }

            boolean endRound = false;
            //Dealing
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);

            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

           while (true){
               System.out.println("Your Hand is");
               System.out.println(playerDeck.toString());
               System.out.println("Your Hand Equals " + playerDeck.cardsValue());

               System.out.println("Dealer Hand " + dealerDeck.getCard(0).toString()+ " & None Of Your Business");

               System.out.println("Hit(1) or Stand(2)?");
               int response = userInput.nextInt();

               if (response == 1){
                   playerDeck.draw(playingDeck);
                   System.out.println("You drew " + playerDeck.getCard(playerDeck.deckSize()-1).toString());

                   if (playerDeck.cardsValue()>21){
                       System.out.println("BUSTED Your Hand Was " +  playerDeck.cardsValue());
                       playerMoney -= playerBet;
                       endRound=true;
                       break;
                   }

               }
               if (response==2){
                   break;
               }
           }
           //Reveal Dealers Hand
            System.out.println("Dealers Hand" + dealerDeck.toString());
           //Does Dealer Have More Points
            if ((dealerDeck.cardsValue()>playerDeck.cardsValue())&& endRound == false){
                System.out.println("House Always Wins!!");
                playerMoney -= playerBet;
                endRound=true;
            }
            //Dealer Draws 16 Stands 17
            while ((dealerDeck.cardsValue()<17)&& endRound == false){
                dealerDeck.draw(playerDeck);
                System.out.println("Dealer Drew" + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());

            }
            //Display Dealers Hand
            System.out.println("Dealers Hand is " + dealerDeck.cardsValue());
            //Did Dealer Bust?
            if ((dealerDeck.cardsValue()>21)&& endRound==false){
                System.out.println("Dealer Bust You Win!!");
                playerMoney+= playerBet*1.5;
                endRound=true;
            }
            if ((playerDeck.cardsValue() == dealerDeck.cardsValue())&& endRound==false){
                System.out.println("Push");
                endRound = true;
            }

            if ((playerDeck.cardsValue()> dealerDeck.cardsValue())&& endRound==false){
                System.out.println("You Win The Hand");
                playerMoney += playerBet*1.5;
                endRound = true;
            }
            else if (endRound==false){
                System.out.println("You Lose Hand");
                playerMoney -= playerBet;
                endRound = true;
            }
            playerDeck.moveAllToDeck(playingDeck);
            dealerDeck.moveAllToDeck(playingDeck);
            System.out.println("End Of The Hand");



        }
        System.out.println("You Gambled All Your Money Away Idiot");

    }

    public void startGame() {

    }

    public void endGame() {

    }

    public int setnumofPlayers(int numofPlayers) {
        return 0;
    }

    public void placeBet(int betAmount) {

    }

    public void nextTurn() {

    }
}

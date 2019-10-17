package io.zipcoder.casino.card_games;

import java.util.Scanner;

public class GoFish {
    public static void main(String[] args) {
        Deck playingDeck = new Deck();

        playingDeck.createFullDeck();
        playingDeck.shuffle();

        Deck playerDeck = new Deck();
        Deck aiDeck = new Deck();

        Scanner userInput = new Scanner(System.in);

        // Game Loop

        while (playerDeck.deckSize()>0 || aiDeck.deckSize()>0 || playingDeck.deckSize() > 0){

            if (playerDeck.deckSize()<=0|| aiDeck.deckSize()<=0 ||playingDeck.deckSize()<0){
                System.out.println("The Game Is Over Please Come Back Again");
                break;
            }
            boolean endRound = false;

            // Dealing

            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);


            aiDeck.draw(playingDeck);
            aiDeck.draw(playingDeck);
            aiDeck.draw(playingDeck);
            aiDeck.draw(playingDeck);
            aiDeck.draw(playingDeck);
            aiDeck.draw(playingDeck);
            aiDeck.draw(playingDeck);

            while (true){
                System.out.println("You Drew");
                System.out.println(playerDeck.toString());


            }



        }
    }
}

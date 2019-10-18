package io.zipcoder.casino;


import io.zipcoder.casino.card_games.BlackJack;
import io.zipcoder.casino.card_games.goFish.GoFish;
import io.zipcoder.casino.dice_games.ChicagoGame;
import io.zipcoder.casino.dice_games.CrapsGame;
import io.zipcoder.casino.utilities.Console;

public class Casino {
    public static void main(String[] args) {
        int playerBalance;

        Console console = new Console(System.in, System.out);
        int choice;
        console.println("Welcome to 🐰 Casino!");

        playerBalance = console.getIntegerInput("How much money are you starting with?");

        do {
            if(playerBalance != 0) {
                choice = console.getIntegerInput(
                        "Hello! what game would you like to play?\n" +
                                "Choices:\n\t" +
                                "(1)\tBlackJack\n\t" +
                                "(2)\tCraps\n\t" +
                                "(3)\tChicago\n\t" +
                                "(4)\tGo Fish [free to play]\n\t" +
                                "(0)\tLeave");

                switch (choice) {

                    case 0:
                        console.println("Thanks for visitin the 🐰 casino. You left with: $" + playerBalance);
                        break;

                    case 1:
                        BlackJack blackJack = new BlackJack(playerBalance);
                        blackJack.startGame();
                        playerBalance = blackJack.getPlayerBalance();
                        break;

                    case 2:
                        CrapsGame craps = new CrapsGame(playerBalance);
                        craps.startGame();
                        playerBalance = craps.getPlayerBalance(0);
                        break;

                    case 3:
                        ChicagoGame chicago = new ChicagoGame();
                        chicago.startGame();
                        break;

                    case 4:
                        GoFish goFish = new GoFish();
                        goFish.startGame();
                        break;

                    default:
                        console.println("Please choose a valid option");
                }
            } else {
                console.println("Get outta here with ya broke ass");
                choice = 0;
            }
        } while (choice != 0);
    }
}

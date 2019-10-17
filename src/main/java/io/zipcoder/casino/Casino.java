package io.zipcoder.casino;


import io.zipcoder.casino.card_games.BlackJack;
import io.zipcoder.casino.dice_games.CrapsGame;
import io.zipcoder.casino.utilities.Console;

public class Casino {
    public static void main(String[] args) {
        int playerBalance = 0;
        // write your tests before you start fucking with this

        Console console = new Console(System.in, System.out);
        int choice;
        console.println("Welcome to 🐰 Casino!");

        playerBalance = console.getIntegerInput("How much money are you starting with?");

        do {
            choice = console.getIntegerInput(
                    "Hello! what game would you like to play?\n" +
                            "Choices:\n\t" +
                            "(1)\tBlackJack\n\t" +
                            "(2)\tCraps\n\t" +
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
                default:
                    console.println("Please choose a valid option");
            }
        } while (choice != 0);
    }
}

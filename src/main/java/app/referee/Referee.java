package app.referee;

import java.util.Scanner;

import app.player.Player;

public class Referee {
    public Referee() {
    }

    public int startMatch(Player players[], int numberRealPlayer) {
        boolean endGame = false;
        Scanner scanner = new Scanner(System.in);
        int turn = 0;
        int winner = 0;
        while (!endGame) {
            System.out.println();
            Player player = players[(turn % 4) + 1];
            int curPointRollDice;
            System.out.println("Is turn: " + player.getName());
            if (((turn % 4) + 1) <= numberRealPlayer) {
                System.out.println("Press enter to roll");
                scanner.nextLine();
                curPointRollDice = player.getMyDice().rollDice();
                System.out.println("Current Score: " + player.getCurScore());
                System.out.println("Point roll dice: " + curPointRollDice);
                player.addCurScore(curPointRollDice);
                System.out.println("Total Score: " + player.getCurScore());
                if (player.getCurScore() == 21) {
                    endGame = true;
                    winner = (turn % 4) + 1;
                }
            } else {
                curPointRollDice = player.getMyDice().rollDice();
                System.out.println("Current Score: " + player.getCurScore());
                System.out.println("Point roll dice: " + curPointRollDice);
                player.addCurScore(curPointRollDice);
                System.out.println("Total Score: " + player.getCurScore());
                if (player.getCurScore() == 21) {
                    endGame = true;
                    winner = (turn % 4) + 1;
                }
            }
            turn++;
        }
        scanner.close();
        System.out.println();
        System.out.println("Winner: " + players[winner].getName());
        return winner;
    }
}

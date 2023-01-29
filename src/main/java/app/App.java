package app;

import java.util.Scanner;

import app.player.Player;
import app.referee.Referee;

public class App {
    private int numberRealPlayer;

    public int getNumberRealPlayer() {
        return numberRealPlayer;
    }

    public App() {
        Player players[] = new Player[5];
        Referee referee = new Referee();

        System.out.print("Input number of player(<=4 and >=0): ");
        Scanner scanner = new Scanner(System.in);
        int numberPlayer = scanner.nextInt();
        scanner.nextLine();
        while (numberPlayer > 4 || numberPlayer < 0) {
            System.out.print("Input number of player(<=4 and >=0): ");
            numberPlayer = scanner.nextInt();
            scanner.nextLine();
        }
        // scanner.close();
        this.numberRealPlayer = numberPlayer;

        for (int i = 1; i <= 4; i++) {
            if (i <= numberRealPlayer) {
                String name = "";
                System.out.print("Input name player " + i + ": ");
                name = scanner.nextLine();
                players[i] = new Player(i, name);
            } else {
                players[i] = new Player(i, "Bot" + (i - numberPlayer));
            }
        }
        scanner.close();
        int winnerTh = referee.startMatch(players, numberRealPlayer);
        for (int i = 1; i <= 4; i++) {
            if (winnerTh != i && i > numberRealPlayer) {
                players[i].getFeel();
            }
        }
    }

    public static void main(String[] args) {
        new App();
    }

}

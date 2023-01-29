package app.player;

import java.util.Random;

import app.dice.Dice;

public class Player {
    private int playerTh;
    private int curScore = 0;
    private Dice myDice;
    private String Name;
    private String Feel[] = { "Chán quá không chơi nữa!", "Lại thua rồi!", "Game này chán quá!", "Hãy đợi đấy!",
            "Thêm ván nữa đi!" };

    public Player(Integer playerTh, String Name) {
        this.playerTh = playerTh;
        this.Name = Name;
        this.myDice = new Dice(playerTh);
    }

    public void getFeel() {
        Random ran = new Random();
        int indexFeel = ran.nextInt(Feel.length);
        System.out.println(this.getName() + ": " + Feel[indexFeel]);
    }

    public int getCurScore() {
        return curScore;
    }

    public void addCurScore(int curRollDice) {
        this.curScore = (this.curScore + curRollDice) > 21 ? 0 : (this.curScore + curRollDice);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Integer getPlayerTh() {
        return playerTh;
    }

    public Dice getMyDice() {
        return myDice;
    }

    // public void Play() {
    // this.getMyDice().rollDice();
    // // this.addPoint(this.getMyDice().getResCurRollDice());
    // // System.out.println(this.getMyDice().getResCurRollDice() + "==>" +
    // // this.getPoint());
    // // if (this.getPoint() > 21) {
    // // this.resetPoint();
    // // }
    // }

    public static void main(String[] args) {
        // Player player1 = new Player(1);
        // while (player1.getPoint() != 21) {
        // player1.Play();
        // }
    }
}

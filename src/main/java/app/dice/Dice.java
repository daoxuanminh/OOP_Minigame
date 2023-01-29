package app.dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {
    private List<Integer> number = new ArrayList<Integer>();
    private int weightDice;
    private int resRollDice;

    public Integer getResCurRollDice() {
        return resRollDice;
    }

    public Integer rollDice() {
        Random rand = new Random();
        int res = rand.nextInt(100);
        int resRollDice;
        if (res <= 19) {
            resRollDice = (weightDice + 0) % 6;
        } else if (res > 19 && res <= 35) {
            resRollDice = (weightDice + 1) % 6;
        } else if (res > 35 && res <= 51) {
            resRollDice = (weightDice + 2) % 6;
        } else if (res > 51 && res <= 67) {
            resRollDice = (weightDice + 3) % 6;
        } else if (res > 67 && res <= 83) {
            resRollDice = (weightDice + 4) % 6;
        } else {
            resRollDice = (weightDice + 5) % 6;
        }
        this.number.add(res);
        resRollDice = resRollDice == 0 ? 6 : resRollDice;
        this.resRollDice = resRollDice;
        return resRollDice;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public Dice(int weightDice) {
        this.weightDice = weightDice;
    }

    public static void main(String[] args) {
        Dice dice = new Dice(1);
        for (int i = 1; i < 11; i++) {
            dice.rollDice();
            System.out.println(dice.getNumber().get(i - 1) + " ==> " + dice.getResCurRollDice());
        }
    }
}

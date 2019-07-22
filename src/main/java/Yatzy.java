import java.util.Arrays;

import static java.util.Arrays.*;

public class Yatzy {

    private int[] dice;
    private final int[] tallies;

    public Yatzy(int... dice) {
        this.dice = dice;
        this.tallies = countDiceValues();
    }

    public int chance() {
        return stream(dice).sum();
    }

    public int ones() {
        return sumDice(1);
    }

    public int twos() {
        return sumDice(2);
    }

    public int threes() {
        return sumDice(3);
    }

    public int fours() {
        return sumDice(4);
    }

    public int fives() {
        return sumDice(5);
    }

    public int sixes() {
        return sumDice(6);
    }

    private int sumDice(int i) {
        return stream(dice).filter(die -> die == i).map(die -> i).sum();
    }

    public int twoPair() {
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1) {
            if (tallies[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        }

        if (n == 2) {
            return score * 2;
        }

        return 0;
    }

    public int scorePair() {
        for (int i = 5; i >= 0; i--) {
            if (tallies[i] >= 2) {
                return (i + 1) * 2;
            }
        }

        return 0;
    }

    public int fourOfAKind() {
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    public int smallStraight() {
        for (int i = 0; i < 5; i++) {
            if (tallies[i] != 1) {
                return 0;
            }
        }

        return 15;
    }

    public int largeStraight() {
        for (int i = 1; i < 6; i++) {
            if (tallies[i] != 1) {
                return 0;
            }
        }

        return 20;
    }

    public int fullHouse() {
        return scorePair() + threeOfAKind();
    }

    public int threeOfAKind() {
        for (int i = 0; i < 6; i++) {
            if (tallies[i] >= 3) {
                return (i + 1) * 3;
            }
        }
        return 0;
    }

    public int yatzy() {
        for (int i = 0; i != 6; i++)
            if (tallies[i] == 5)
                return 50;
        return 0;
    }

    private int[] countDiceValues() {
        int[] tallies = new int[6];
        for (int die : dice) {
            tallies[die - 1]++;
        }
        return tallies;
    }
}




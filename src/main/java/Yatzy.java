import java.util.stream.IntStream;

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
        return stream(dice)
                .filter(die -> die == i)
                .sum();
    }

    public int scorePair() {
        return IntStream.range(0, 5)
                .map(i -> 5 - i)
                .filter(i -> tallies[i] >= 2)
                .map(i -> (i + 1) * 2)
                .findFirst()
                .orElse(0);
    }

    public int twoPair() {
        return IntStream.range(0, 6)
                .filter(i -> tallies[6 - i - 1] >= 2)
                .map(i -> 6 - i)
                .sum() * 2;
    }

    public int threeOfAKind() {
        return xOfAKind(3);
    }

    public int fourOfAKind() {
        return xOfAKind(4);
    }

    private int xOfAKind(int x) {
        return IntStream.range(0, 6)
                .filter(i -> tallies[i] >= x)
                .map(i -> (i + 1) * x)
                .findFirst()
                .orElse(0);
    }

    public int smallStraight() {
        return straight(0, 5, 15);
    }

    public int largeStraight() {
        return straight(1, 6, 20);
    }

    private int straight(int start, int end, int resultingValue) {
        return IntStream.range(start, end)
                .filter(i -> tallies[i] != 1)
                .map(i -> 0)
                .findFirst()
                .orElse(resultingValue);
    }

    public int fullHouse() {
        return scorePair() + threeOfAKind();
    }

    public int yatzy() {
        return IntStream.range(0, 6)
                .filter(i -> tallies[i] == 5)
                .map(i -> 50)
                .findFirst()
                .orElse(0);
    }

    private int[] countDiceValues() {
        int[] tallies = new int[6];

//        stream(dice).mapToLong(die -> tallies[die - 1]++).mapToInt(i -> i.intValue()).toArray();
//        Arrays.stream(dice).mapToLong(die -> tallies[die - 1]++).toArray(int[]::new);

        for (int die : dice) {
            tallies[die - 1]++;
        }
        return tallies;
    }
}




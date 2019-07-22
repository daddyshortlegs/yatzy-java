public class Yatzy {

    private int[] dice;
    private final int[] tallies;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;

        tallies = countDiceValues();
    }

    public int chance() {
        int sum = 0;
        for (int die : dice) {
            sum += die;
        }
        return sum;
    }

    public int ones() {
        int sum = 0;
        for (int die : dice) {
            if (die == 1) {
                sum += 1;
            }
        }
        return sum;

    }

    public int twos() {
        int sum = 0;
        for (int die : dice) {
            if (die == 2) {
                sum += 2;
            }
        }
        return sum;
    }

    public int threes() {
        int sum = 0;
        for (int die : dice) {
            if (die == 3) {
                sum += 3;
            }
        }
        return sum;
    }


    public int fours() {
        int sum = 0;
        for (int die : dice) {
            if (die == 4) {
                sum += 4;
            }
        }
        return sum;
    }

    public int fives() {
        int sum = 0;
        for (int die : dice) {
            if (die == 5) {
                sum += 5;
            }
        }
        return sum;
    }

    public int sixes() {
        int sum = 0;
        for (int die : dice) {
            if (die == 6) {
                sum += 6;
            }
        }
        return sum;
    }

    public int scorePair() {
        int at;
        for (at = 0; at != 6; at++)
            if (tallies[6 - at - 1] >= 2)
                return (6 - at) * 2;
        return 0;
    }

    public int twoPair() {
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (tallies[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public int threeOfAKind() {
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    public int fourOfAKind() {
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    public int smallStraight() {
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    public int largeStraight() {
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public int fullHouse() {
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }

    public int yatzy() {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die - 1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    private int[] countDiceValues() {
        int[] tallies = new int[6];
        tallies[dice[0] - 1]++;
        tallies[dice[1] - 1]++;
        tallies[dice[2] - 1]++;
        tallies[dice[3] - 1]++;
        tallies[dice[4] - 1]++;
        return tallies;
    }
}




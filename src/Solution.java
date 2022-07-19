import java.util.Hashtable;

public class Solution {

    public static int noOfMines = 0;
    public static final Hashtable<Integer, Integer> solution = new Hashtable<>();

    public static int solve(int x, int y, double minePercentage) {

        for (int i = 1; i <= minePercentage * x * y; i++) {

            int mineCoordinate = Math.round((int) (Math.random() * (x * y)));
            mineCoordinate += (mineCoordinate == 0 ? 1 : 0);

            if (!solution.containsKey(mineCoordinate)) {
                solution.put(mineCoordinate, 9);
            } else {
                i--;
            }

            noOfMines = i;
        }

        for (int k = 1; k <= x * y; k++) {

            solution.putIfAbsent(k, 0);

        }

        for (int k = 1; k <= x * y; k++) {

            if (solution.get(k) != 9) {

                int answer = 0;

                answer += (solution.get(k - x - 1) != null && solution.get(k - x - 1) == 9) && (k % x != 1) ? 1 : 0;
                answer += (solution.get(k - x) != null && solution.get(k - x) == 9) ? 1 : 0;
                answer += (solution.get(k - x + 1) != null && solution.get(k - x + 1) == 9) && (k % x != 0) ? 1 : 0;

                answer += (solution.get(k - 1) != null && solution.get(k - 1) == 9) && (k % x != 1) ? 1 : 0;
                answer += (solution.get(k + 1) != null && solution.get(k + 1) == 9) && (k % x != 0) ? 1 : 0;

                answer += (solution.get(k + x - 1) != null && solution.get(k + x - 1) == 9) && (k % x != 1) ? 1 : 0;
                answer += (solution.get(k + x) != null && solution.get(k + x) == 9) ? 1 : 0;
                answer += (solution.get(k + x + 1) != null && solution.get(k + x + 1) == 9) && (k % x != 0) ? 1 : 0;

                solution.put(k, answer);
            }
        }

        return noOfMines;

    }
}


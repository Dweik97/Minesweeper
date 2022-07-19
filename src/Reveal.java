import java.util.Hashtable;

public class Reveal {

    public static final Hashtable<Integer, Integer> revealed = new Hashtable<>();

    public static void firstReveal(int x, int y) {

        revealed.putAll(Solution.solution);

        int startPoint;

        do {

            startPoint = Math.round((int) (Math.random() * (x * y)));
            startPoint += (startPoint == 0 ? 1 : 0);

        } while (revealed.get(startPoint) == 9 || revealed.get(startPoint) != 0);

        blankReveal(startPoint);

    }

    public static boolean selectReveal(int x, int i, int j, boolean hasLost) {

        if (Solution.solution.get((j - 1) * x + i) != 9){

            if (Solution.solution.get((j - 1) * x + i) == 0){
                blankReveal((j - 1) * x + i);

            } else {
                Reveal.revealed.put((j - 1) * x + i,10);
            }
        }else {

            Game.hasLost = true;
        }
        return hasLost;
    }

    public static void blankReveal(int point) {

        int x = Game.x;

        revealed.put(point, 10);

        if (revealed.get(point - x - 1) != null && revealed.get(point - x - 1) < 9 && (point%x != 1)) {

            revealed.put(point - x - 1, 10);

            if (Solution.solution.get(point - x - 1) == 0) {
                blankReveal(point - x - 1);
            }
        }

        if (revealed.get(point - x) != null && revealed.get(point - x) < 9){

            revealed.put(point - x, 10);

            if (Solution.solution.get(point - x) == 0) {
                blankReveal(point - x);
            }        }
        if (revealed.get(point - x + 1) != null && revealed.get(point - x + 1) < 9 && (point%x != 0)){

            revealed.put(point - x + 1, 10);

            if (Solution.solution.get(point - x + 1) == 0) {
                blankReveal(point - x + 1);
            }        }
        if (revealed.get(point - 1) != null && revealed.get(point - 1) < 9 && (point%x != 1)){

            revealed.put(point - 1, 10);

            if (Solution.solution.get(point - 1) == 0) {
                blankReveal(point - 1);

            }
        }
        if (revealed.get(point + 1) != null && revealed.get(point + 1) < 9 && (point%x != 0)){

            revealed.put(point + 1, 10);

            if (Solution.solution.get(point + 1) == 0) {
                blankReveal(point + 1);
            }        }
        if (revealed.get(point + x - 1) != null && revealed.get(point + x - 1) < 9 && (point%x != 1)){

            revealed.put(point + x - 1, 10);

            if (Solution.solution.get(point + x - 1) == 0) {
                blankReveal(point + x - 1);
            }        }
        if (revealed.get(point + x) != null && revealed.get(point + x) < 9){

            revealed.put(point + x, 10);

            if (Solution.solution.get(point + x) == 0) {
                blankReveal(point + x);
            }        }
        if (revealed.get(point + x + 1) != null && revealed.get(point + x + 1) < 9 && (point%x != 0)){

            revealed.put(point + x + 1, 10);

            if (Solution.solution.get(point + x + 1) == 0) {
                blankReveal(point + x + 1);
            }        }
    }
}
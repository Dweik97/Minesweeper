import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {

    public static int i, j, x, y, noOfMines, noOfFlags;
    public static boolean hasLost, hasWon;
    public static String difficulty;
    public static String flag;

    public static Scanner myScan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(Colour.yellow_bold("\nWelcome to Minesweeper. Please fill in the following options to start the game."));
        System.out.print(" - Field width: ");
        x = checkDimensions();
        System.out.print(" - Field height: ");
        y = checkDimensions();
        System.out.print(" - Difficulty (Beginner (default) [1], Intermediate [2], Expert [3]): ");
        difficulty = myScan.next();
        myScan.nextLine();

        double minePercentage = switch (difficulty) {
            case ("2") -> 0.25;
            case ("3") -> 0.35;
            default -> 0.15;
        };

        noOfMines = Solution.solve(x, y, minePercentage);
        Reveal.firstReveal(x, y);

        do {

            noOfFlags = 0;

            for (Integer key : Reveal.revealed.keySet()) {
                if (Reveal.revealed.get(key) == 11) {
                    noOfFlags++;
                }
            }

            int minesLeft = noOfMines - noOfFlags;

            if (minesLeft == 0) {
                checkWin();
                if(hasWon) {
                    break;
                }
            }

            System.out.print(Colour.red("\nFlags left: " + minesLeft + "\n"));
            Grid.generateGrid(x, y, hasLost, hasWon);
            System.out.print(Colour.yellow("\nNext move (Row-Column-Flag[f]/Reveal[r]): "));

            myScan.useDelimiter("-");
            j = myScan.nextInt();
            i = myScan.nextInt();
            myScan.reset();
            flag = myScan.next();
            myScan.nextLine();

            if (flag.equals("-f")) {

                Reveal.revealed.put((j - 1) * x + i, 11);

            } else {

                Reveal.selectReveal(x, i, j, hasLost);
            }

            if (hasLost) {

                System.out.println(Colour.red_bold("\nSolution"));
                Grid.generateGrid(x, y, true, false);
                System.out.print(Colour.red("\nYou stepped on a mine.. ouch..\n"));
                break;

            }

        } while (true);
    }

    public static int checkDimensions (){

        int input = 4;

        do {
            if (input <= 3) {
                System.out.print(Colour.red("   Invalid input. Please enter an integer greater than 3 to continue: "));
            }
            while (!myScan.hasNextInt()) {
                System.out.print(Colour.red("   Invalid input. Please enter an integer greater than 3 to continue: "));
                myScan.next();
            }
            input = myScan.nextInt();
        } while (input <= 3);

        return input;
    }

//    public static boolean checkMove () {
//
//        boolean result = false;
//
//        String move = "\\D-\\D-[A-Za-z]";
//        String move1 = "1-1-f";
//        if (move.matches(move1)) {
//            result = true;
//        }
//
//        return result;
//    }

    public static void checkWin() {

        for (Integer key : Solution.solution.keySet()) {

            if (Solution.solution.get(key) == 9) {

                if (Reveal.revealed.get(key) == 11) {

                    hasWon = true;

                }else{

                    hasWon = false;
                    break;
                }
            }
        }

        if (hasWon) {

            System.out.println(Colour.green_bold("\nSolution"));
            Grid.generateGrid(x, y, false, true);
            System.out.print(Colour.green("\nFantastic! You \"safely\" found all the mines!\n"));

        }
    }

}
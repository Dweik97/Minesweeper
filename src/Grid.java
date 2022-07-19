public class Grid {

    public static void generateGrid(int x, int y, boolean hasLost, boolean hasWon) {

        System.out.print("   ");

        for (int i = 1; i <= x; i++) {

            System.out.print(Colour.blue_bold((i > 1 ? "  " : " ") + i + (i < 10 ? " " : "")));

        }

        for (int j = 1; j <= y; j++) {

            System.out.print("\n" + Colour.blue_bold(String.valueOf(j)) + (j < 10 ? "  " : " "));

            for (int i = 1; i <= x; i++) {

                if (!hasLost && !hasWon) {

                    if (Reveal.revealed.get((j - 1) * x + i) > 9) {

                        if (Solution.solution.get((j - 1) * x + i) == 0) {
                            System.out.print(Colour.blue_bold(" .  "));

                        } else if (Reveal.revealed.get((j - 1) * x + i) == 11) {

                            System.out.print(Colour.red("  🚩   "));

                        } else {

                            System.out.print("[" + (Solution.solution.get((j - 1) * x + i) + "] "));
                        }

                    } else

                        System.out.print("    ");

                }
                else if (hasWon) {

                    if (Reveal.revealed.get((j - 1) * x + i) == 11) {

                        if (Solution.solution.get((j - 1) * x + i) == 9) {
                            System.out.print(Colour.green_bold(" 🚩   "));

                        }
                    } else if (Solution.solution.get((j - 1) * x + i) == 0) {

                        System.out.print(Colour.blue_bold(" .  "));
                    } else {

                        System.out.print("[" + (Solution.solution.get((j - 1) * x + i) + "] "));
                    }
                }
                else{

                    if (Solution.solution.get((j - 1) * x + i) == 9) {

                        if (Reveal.revealed.get((j - 1) * x + i) == 11) {
                            System.out.print(Colour.green_bold(" 🚩   "));

                        }else {
                            System.out.print(Colour.red_bold(" *  "));
                        }
                    }else if (Solution.solution.get((j - 1) * x + i) == 0)

                        System.out.print(Reveal.revealed.get((j - 1) * x + i) == 11? (Colour.red_bold(" .  ")) : Colour.blue_bold(" .  "));
                    else {

                        System.out.print(Reveal.revealed.get((j - 1) * x + i) == 11? (Colour.red_bold("[" + (Solution.solution.get((j - 1) * x + i) + "] "))) : ("[" + (Solution.solution.get((j - 1) * x + i) + "] ")));

                    }
                }
            }
        }
    }
}
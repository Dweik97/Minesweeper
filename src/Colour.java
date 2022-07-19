public class Colour {

    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    private static final String RESET = "\u001b[0m";

    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    public static String black(String text) {return BLACK + text + RESET;}
    public static String red(String text) {return RED + text + RESET;}
    public static String green(String text) {return GREEN + text + RESET;}
    public static String yellow(String text) {return YELLOW + text + RESET;}
    public static String blue(String text) {return BLUE + text + RESET;}
    public static String cyan(String text) {return CYAN + text + RESET;}
    public static String white(String text) {return WHITE + text + RESET;}
    public static String black_bold(String text) {return BLACK_BOLD + text + RESET;}
    public static String red_bold(String text) {return RED_BOLD + text + RESET;}
    public static String green_bold(String text) {return GREEN_BOLD + text + RESET;}
    public static String yellow_bold(String text) {return YELLOW_BOLD + text + RESET;}
    public static String blue_bold(String text) {return BLUE_BOLD + text + RESET;}
    public static String cyan_bold(String text) {return CYAN_BOLD + text + RESET;}
    public static String white_bold(String text) {return WHITE_BOLD + text + RESET;}

}

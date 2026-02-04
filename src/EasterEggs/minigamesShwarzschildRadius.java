package src.EasterEggs;

import java.util.Scanner;

public class minigamesShwarzschildRadius {
    // Schwarzschild Radius
    public static double R;
    // Speed of light
    public static double c = 299.792d;
    // Newtonian gravitational constant
    public static double G = 6.674d;

    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String PURPLE = "\u001B[35m";
    public static final String WHITE = "\u001B[37m";
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String BLACK = "\u001B[30m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(BLACK_BACKGROUND +
                "\nInput the mass in KG of the object to calculate the size, which leads it to collapse into a black hole(in double, example: 200): \n");
        String m = scanner.nextLine();
        Double M = Double.parseDouble(m);
        R = (2 * G * M) / (Math.pow(c, 2));
        R = Math.round(R * 1000.0d) / 1000.0d;

        System.out
                .println("\nThe entity weighing " + PURPLE + m + WHITE
                        + " kg would collapse into a black hole, if it's radius was " + PURPLE_BACKGROUND + BLACK + R
                        + BLACK_BACKGROUND + WHITE + " meters");
    }
}

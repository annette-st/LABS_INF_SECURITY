import java.util.Random;

public class PasswordGenerator_part1 {

    // VALUES:
    // P = 10^-5
    // V = 10 passwords / a day
    // T = 5 days

    // SYMBOL GROUPS:
    // 1. Numbers (0-9)
    // 2. Latin lower-case letters (a-z)

    public static void main(String[] args) {

        // A = 26 + 10 = 36
        // S = V * T / P = 10 * 5 / 10^-4 = 500 000
        // S = A^L => 500 000 = 36 ^ 4
        // System.out.println((long)Math.pow(36, 4)); // 1679616 => L = 4

        int length = 4;

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            boolean part = new Random().nextBoolean();
            if (part) {
                password.append((char) randomSymbol(97, 122)); // in area of (a - z)
            } else {
                password.append((char) randomSymbol(48, 57)); // in area of (0 - 9)
            }
        }
        System.out.println("Completed! Your generated password is " + password);
    }

    public static int randomSymbol(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return new Random().nextInt((max - min) + 1) + min;
    }

}


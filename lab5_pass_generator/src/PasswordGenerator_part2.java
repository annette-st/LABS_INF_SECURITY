import java.io.Console;
import java.util.Arrays;

public class PasswordGenerator_part2 {
    public static void main(String[] args) {

        String worship = "worship";
        String outreach = "outreach";
        String luck = "luck";

        char[] resultArray = new char[5];

        if (outreach.charAt(0) == 'z') {
            resultArray[0] = 'a';
            resultArray[1] = 'a';
        } else {
            resultArray[0] = (char)((int) outreach.charAt(0) + 1);
            resultArray[1] = (char)((int) outreach.charAt(0) + 1);
        }

        if (outreach.charAt(4) == 'a') {
            resultArray[2] = 'z';
        } else {
            resultArray[2] = (char)((int) outreach.charAt(4) - 1);
        }

        if (luck.length() % 2 != 0) {
            if (luck.charAt(3) == 'z') {
                resultArray[3] = 'a';
            } else {
                resultArray[3] = (char)((int) luck.charAt(2) + 1);
            }
        } else {
            if (luck.charAt(luck.length() / 2 - 1) == 'a') {
                resultArray[3] = 'z';
            } else {
                resultArray[3] = (char)((int) luck.charAt(luck.length() / 2 - 1) - 1);
            }
        }
        int l5 = worship.length() + outreach.length() - 4;
        if (l5 <= 26) {
            resultArray[4] = (char)(l5);
        } else {
            resultArray[4] = (char)(l5 % 26);
        }

        String password = new String(resultArray);

   //     System.out.println(password);

    PasswordGenerator_part2.passwordValidator();

    }

    public static void passwordValidator() {
        Console console = System.console();
        console.printf("Please enter your password: ");
        char[] passwordChars = console.readPassword();
        String passwordString = new String(passwordChars);

        console.printf(passwordString + "\n");
    }

}

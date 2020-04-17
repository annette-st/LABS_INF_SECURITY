import java.util.ArrayList;

public class BackpackAlgorythm {
    private String word;
    private int[] openKey;
    private int m;
    private int n;

    public BackpackAlgorythm(String word, int[] vector, int m, int n) {
        this.word = word;
        this.openKey = vector;
        this.m = m;
        this.n = n;
    }

    public String encrypt() {
        int[] closedKey = new int[this.openKey.length];
        for (int i = 0; i < this.openKey.length; i++) {
            closedKey[i] = this.openKey[i] * this.n % this.m;
        }
        StringBuilder encryptedWord = new StringBuilder();
        String b = Integer.toBinaryString(this.word.charAt(0));
        for (int i = 0; i < this.word.length(); i++) {
            char curr = this.word.charAt(i);
            String binaryString = Integer.toBinaryString(curr);
            int sum = 0;
            for (int j = 0; j < binaryString.length(); j++) {
                if (binaryString.charAt(j) == 49) {
                    sum += closedKey[j];
                }
            }
            encryptedWord.append(sum).append(' ');
        }
        return encryptedWord.toString();
    }

    public String decrypt(String s) {
        String[] str = s.split(" ");
        int[] array = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            int curr = Integer.parseInt(str[i]);
            array[i] = curr * 271 % this.m;
            //System.out.println("decrypt: " + array[i]);
        }
        StringBuilder dWord = new StringBuilder();

        for (int q = 0; q < array.length; q++) {
            //System.out.println("VALUE NUMBER " + q + " = " + array[q]);
            int[] bincode = new int[7];
            int testValue = array[q];
            int[] testArray = new int[10];
            int i = 0;
            for (int a : testArray) {
                a = 0;
            }
            int diff = testValue;
            int sum = 0;

            for (int j = this.openKey.length - 1; j >= 0; j--) {
                if (diff >= this.openKey[j]) {
                    sum += this.openKey[j];
                    testArray[i] = this.openKey[j];
                    i++;
                    bincode[j] = 1;

                    diff = diff - this.openKey[j];
                }
            }
            // System.out.println("sum values: ");
            int e = 0;
            for (int a : testArray) {
                //System.out.println(e + ": " + a);
                e++;
            }
            StringBuilder binChar = new StringBuilder();

            for (int a : bincode) {
                binChar.append(a);
            }
            String res = binChar.toString();
            int parseInt = Integer.parseInt(res, 2);
            char c = (char)parseInt;
            dWord.append(c);
        }

        return dWord.toString();
    }
}

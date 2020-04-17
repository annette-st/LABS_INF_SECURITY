public class Main {
    public static void main(String[] args) {
        String word = "fGjdfdGot";

        int[] privateKey = {2, 3, 6, 13, 27, 52, 105, 210};
        int m = 420;
        int n = 31; // n-1 = 271 || 31 * 271 mod 420 = 1 (расширенный алгоритм Евклида)

        BackpackAlgorythm backpackAlgorythm = new BackpackAlgorythm(word, privateKey, m, n);
        String s = backpackAlgorythm.encrypt();
        System.out.println("RESULTS");
        System.out.println("Word: " + word);
        System.out.println("Encryption: " + s);
        System.out.println("Descryption: " + backpackAlgorythm.decrypt(s));




    }
}

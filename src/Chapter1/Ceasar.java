package Chapter1;

public class Ceasar {

    public static String Encode(String M, int K) {
        String res = "";
        for (int i = 0; i < M.length(); i ++) {
            res += (char)((((int)M.charAt(i) - 65) + K) % 26 + 65);
        }
        return res;
    }

    public static void main(String[] args) {
        String M = "STILLWATERSRUNDE";
        int K = 17;
        System.out.println("Input: M = "  + M + " , " + "K = " + K);
        System.out.println("Output: C = " + Encode(M, K));
    }
}

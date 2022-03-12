public class Ceasar {

    public static String Encode(String M, int K) {
        String res = "";
        for (int i = 0; i < M.length(); i ++) {
            if (((int)M.charAt(i) + K) > 90) {
                res += (String.valueOf((char)((int)M.charAt(i) + K - 26)));
            }
            else
                res += (String.valueOf((char)((int)M.charAt(i) + K)));
        }
        return res;
    }

    public static void main(String[] args) {
        String M = "BETTERSAFETHANSO";
        int K = 25;
        System.out.println(Encode(M, K));
    }
}

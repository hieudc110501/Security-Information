import java.util.ArrayList;
import java.util.List;

public class Vigenere {

    static int[][] matrix = new int[26][26];

    //create AdjMatrix
    public static void AdjMarix() {
        for (int i = 0; i < 26; i ++) {
            for (int j = 0; j < 26; j ++) {
                matrix[i][j] = (i + j) % 26 + 65;
            }
        }
    }

    //normal key
    public static String NormalKey(String M, String K) {
        int x = M.length() / K.length();
        while (x > 0) {
            if (x == 1) {
                K += K.substring(0, M.length() - K.length());
            }
            else {
                K += K;
            }
            x--;
        }
        return K;
    }

    //auto key
    public static String AutoKey(String M, String K) {
        StringBuffer res = new StringBuffer();
        res.append(K);
        res.append(M.substring(0, M.length() - K.length()));
        return res.toString();
    }

    //check matrix and encode
    public static String Encode(String M, String K) {
        String res = "";
        for (int i = 0; i < K.length(); i ++) {
            res += (char)matrix[(int)(M.charAt(i) - 65)][(int)(K.charAt(i) - 65)];
        }
        return res;
    }
    public static void main(String[] args) {
            String M = "MONEYMAKESTHE";
        String K = "YOUREON";
        AdjMarix();
        System.out.println("Normal Key: " + Encode(M, NormalKey(M, K)));
        System.out.println("Auto Key: " + Encode(M, AutoKey(M, K)));
    }
}

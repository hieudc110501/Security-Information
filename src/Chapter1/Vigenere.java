package Chapter1;

import java.util.ArrayList;
import java.util.List;

public class Vigenere {
    //Lặp khóa
    public static String NormalKey(String M, String K) {
        int x = M.length() / K.length();
        //kiểm tra len(M) gấp len(K)
        while (x > 0) {
            //gấp 1 lần chỉ cộng thêm phần thiếu
            if (x == 1) {
                K += K.substring(0, M.length() - K.length());
            }
            //gấp nhiều lần thì cộng cả K
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

    //mã hóa
    public static String Encode1(String M, String K) {
        String res = "";
        for (int i = 0; i < K.length(); i ++) {
            res += (char) (((int)M.charAt(i) + (int)K.charAt(i)) % 26 + 65);
        }
        return res;
    }

    public static void main(String[] args) {
        String M = "THETRUTHWILLO";
        String K = "THEGRASS";
        System.out.println("Input: M = " + M + " , " + "K = " + K);
        System.out.println("Lap Key: " + Encode1(M, NormalKey(M, K)));
        System.out.println("Auto Key: " + Encode1(M, AutoKey(M, K)));
    }
}

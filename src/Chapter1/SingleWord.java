import java.util.*;

public class SingleWord {
    static HashMap<String, String> map = new HashMap<>();
    static String AlphaBet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void Encode(String M, String K) {
        for (int i = 0; i < K.length(); i ++) {
            String key = String.valueOf(AlphaBet.charAt(i));
            String value = String.valueOf(K.charAt(i));
            map.put(key, value);

        }
        String arr = "";
        for (int i = 0; i < M.length(); i ++) {
            arr += map.get(String.valueOf(M.charAt(i)));
        }
        System.out.println(arr);
    }
    public static void main(String[] args) {
        String M = "TIMEISMONEYTIMEI";
        String K = "KGOXPMUHCAYTJQWZRIVESFLDNB";
        Encode(M, K);
    }
}

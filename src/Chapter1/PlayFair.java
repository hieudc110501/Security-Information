import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.String.*;

public class PlayFair {
    //create pair class to save two values
    static class pair {
        int i;
        int j;

        public pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static List<List<String>> matrix = new ArrayList<>();
    static HashMap<String, pair> map = new HashMap<>();
    static List<String> arr = new ArrayList<>();

    public static void AddMatrix(String K, String AlphaBet ) {
        //add all difference elements K and AlphaBet into StringBuffer
        StringBuffer arr = new StringBuffer();
        for (int i = 0; i < K.length(); i ++) {
            if (!arr.toString().contains(String.valueOf(K.charAt(i)))) {
                arr.append(String.valueOf(K.charAt(i)));
            }
        }
        for (int i = 0; i < AlphaBet.length(); i ++) {
            if (!arr.toString().contains(String.valueOf(AlphaBet.charAt(i)))) {
                arr.append(String.valueOf(AlphaBet.charAt(i)));
            }
        }

        //add StringBuffer into matrix 5x5
        List<String> arr1 = new ArrayList<>();
        int count = 1, col = 0, row = 0;
        for (int i = 0; i < arr.length(); i ++) {
            map.put(String.valueOf(arr.charAt(i)), new pair(row, col));
            arr1.add(String.valueOf(arr.charAt(i)));
            col++;
            if (count % 5 == 0) {
                matrix.add(arr1);
                arr1 = new ArrayList<>();
                row ++;
                col = 0;
            }
            count ++;
        }
    }

    public static List<String> SubM(String M) {
        //Add char M into List
        List<String> M1 = new ArrayList<>();
        for (int i = 0; i < M.length(); i ++) {
            M1.add(valueOf(M.charAt(i)));
        }

        //Encode M
        int k = 0;
        while (k < M1.size() - 1) {
            if (!M1.get(k).equals(M1.get(k + 1))) {
                arr.add(String.valueOf(M1.get(k)));
                arr.add(String.valueOf(M1.get(k+1)));
                k += 2;
            }
            else {
                arr.add(M1.get(k));
                arr.add("X");
                k++;
            }
        }
        if (k % 2 != 0) arr.add(M1.get(M1.size()-1));
        if (arr.size() % 2 != 0) {
            arr.add("X");
        }
        return arr;
    }

    public static void Encode(List<String> listM) {
        StringBuffer arr = new StringBuffer();
        for (int i = 0; i < listM.size(); i += 2) {
            int x1 = map.get(listM.get(i)).i;
            int y1 = map.get(listM.get(i)).j;
            int x2 = map.get(listM.get(i+1)).i;
            int y2 = map.get(listM.get(i+1)).j;
            if (x1 == x2){
                arr.append(matrix.get(x1).get((y1+1) % 5)).append(matrix.get(x1).get((y2+1) % 5));
            }
            else if (y1 == y2){
                arr.append(matrix.get((x1+1) % 5).get(y1)).append(matrix.get((x2+1) % 5).get(y2));
            }
            else {
                arr.append(matrix.get(x1).get(y2)).append(matrix.get(x2).get(y1));
            }
            arr.append(" ");
        }
        System.out.println(arr);
    }

    public static void main(String[] args) {
        String M = "BEAUTYISONLYSK";
        String K = "BEAUTY";
        String AlphaBet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        AddMatrix(K, AlphaBet);
        System.out.println(matrix);
        List<String> listM = SubM(M);
        System.out.println(listM);
        Encode(listM);
    }
}

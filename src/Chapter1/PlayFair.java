package Chapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.String.*;

public class PlayFair {
    //tạo pair để tọa độ
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

    //thêm K và kí tự thiếu vào ma trận 5x5
    public static void AddMatrix(String K, String AlphaBet ) {
        StringBuffer array = new StringBuffer();
        // thêm K vào arr chỉ thêm những chữ chưa có
        for (int i = 0; i < K.length(); i ++) {
            if (!array.toString().contains(String.valueOf(K.charAt(i)))) {
                array.append(String.valueOf(K.charAt(i)));
            }
        }
        //thêm AlphaBet vào arr chỉ thêm những chữ chưa có
        for (int i = 0; i < AlphaBet.length(); i ++) {
            if (!array.toString().contains(String.valueOf(AlphaBet.charAt(i)))) {
                array.append(String.valueOf(AlphaBet.charAt(i)));
            }
        }

        //add StringBuffer into matrix 5x5
        List<String> array1 = new ArrayList<>();
        int count = 1, col = 0, row = 0;
        for (int i = 0; i < array.length(); i ++) {
            // thêm kí tự vào map với tọa độ
            map.put(String.valueOf(array.charAt(i)), new pair(row, col));
            array1.add(String.valueOf(array.charAt(i)));
            col++;
            //thêm đủ 1 hàng thì reset col = 0, row + 1
            if (count % 5 == 0) {
                matrix.add(array1);
                array1 = new ArrayList<>();
                row ++;
                col = 0;
            }
            count ++;
        }
    }

    // kiểm tra M
    public static void SubM(String M) {
        //thêm M vào
        List<String> M1 = new ArrayList<>();
        for (int i = 0; i < M.length(); i ++) {
            M1.add(valueOf(M.charAt(i)));
        }

        int k = 0;
        boolean check = true;
        while (k < M1.size() - 1) {
            //nếu 2 kí tự cạnh nhau khác nhau thì thêm vào arr
            if (!M1.get(k).equals(M1.get(k + 1))) {
                arr.add(String.valueOf(M1.get(k)));
                arr.add(String.valueOf(M1.get(k+1)));
                k += 2;
            }
            //nếu giống thì cộng thêm X
            else {
                arr.add(M1.get(k));
                arr.add("X");
                k++;
                check = false;
            }
        }
        if ((k + M1.size()) % 2 != 0) {
            arr.add(M1.get(M1.size()-1));
            arr.add("X");
        }
    }

    //mã hóa
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
        System.out.println("Output: C = " + arr);
    }

    public static void main(String[] args) {
        String M = "ACLEANFASTISB";
        String K = "EASTO";
        System.out.println("Input: " + "M = " + M + "   " + "K = " + K);
        String AlphaBet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        AddMatrix(K, AlphaBet);
        for (int i = 0; i < 5; i ++) {
            System.out.println(matrix.get(i));
        }
        SubM(M);
        System.out.println(arr);
        Encode(arr);
    }
}

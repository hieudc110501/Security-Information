import java.util.ArrayList;
import java.util.List;

public class RailFence {
    static String M = "CHAOCACBANHOCMONANTOANBAOMATTHONGZ";
    static int K = 6;
    static int row = K;
    static boolean check = false;
    static String[][] matrix = new String[K][K];
    public static void addMatrix() {
        int count = 0;
        for (int i = 0; i < K; i ++) {
            for (int j = 0; j < K; j ++) {
                if (count < M.length()) {
                    matrix[i][j] = String.valueOf(M.charAt(count));
                    count++;
                }
                else {
                    matrix[i][j] = "X";
                    check = true;
                }
            }
            if (check) {
                row = i + 1;
                break;
            }
        }
    }
    public static void Encode(String[][] matrix) {
        String arr = "";
        for (int i = 0; i < K; i ++) {
            for (int j = 0; j < row; j ++) {
                arr += matrix[j][i];
            }
        }
        System.out.println(arr);
    }
    public static void main(String[] args) {
        addMatrix();
        Encode(matrix);
    }

}

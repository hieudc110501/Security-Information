package Chapter3;

import java.util.ArrayList;
import java.util.HashMap;

public class DES {

    static String L, R;
    static String C, D;
    static int[][] matrixIP = {
                    {58, 50, 42, 34, 26, 18, 10, 2},
                    {60, 52, 44, 36, 28, 20, 12, 4 },
                    {62, 54, 46, 38, 30, 22, 14, 6 },
                    {64, 56, 48, 40, 32, 24, 16, 8},
                    {57, 49, 41, 33, 25, 17, 9, 1 },
                    {59, 51, 43, 35, 27, 19, 11, 3 },
                    {61, 53, 45, 37, 29, 21, 13, 5 },
                    {63, 55, 47, 39, 31, 23, 15, 7 },
                    };
    static int[][] matrixE = {
            {32, 1, 2, 3, 4, 5},
            {4, 5, 6, 7, 8, 9 },
            {8, 9, 10, 11, 12, 13},
            {12, 13, 14, 15, 16, 17 },
            {16, 17, 18, 19, 20, 21 },
            {20, 21, 22, 23, 24, 25 },
            {24, 25, 26, 27, 28, 29 },
            {28, 29, 30, 31, 32, 1},
            };

    static int[][] Sbox1 = {
            {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
            {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
            {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
            {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
            };

    static int[][] Sbox2 = {
            {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 },
            {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5  },
            {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
            {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}
            };

    static int[][] Sbox3 = {
            {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 },
            {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 },
            {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
            {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12, }
    };
    static int[][] Sbox4 = {
            {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 },
            {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9  },
            {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
            {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}
    };
    static int[][] Sbox5 = {
            {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 },
            {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 },
            {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
            {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
    };
    static int[][] Sbox6 = {
            {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
            {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 },
            {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
            {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
    };
    static int[][] Sbox7 = {
            {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 },
            {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
            {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
            {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}
    };
    static int[][] Sbox8 = {
            {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 },
            {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2  },
            {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
            {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
    };

    static int[][] matrixP = {
            {16, 7, 20, 21},
            {29, 12, 28, 17},
            {1, 15, 23, 26},
            {5, 18, 31, 10},
            {2, 8, 24, 14},
            {32, 27, 3, 9},
            {19, 13, 30, 6},
            {22, 11, 4, 25}
    };

    static int[][] matrixPC1 = {
            {57, 49, 41, 33, 25, 17, 9},
            {1, 58, 50, 42, 34, 26, 18 },
            {10, 2, 59, 51, 43, 35, 27 },
            {19, 11, 3, 60, 52, 44, 36},
            {63, 55, 47, 39, 31, 23, 15},
            {7, 62, 54, 46, 38, 30, 22 },
            {14, 6, 61, 53, 45, 37, 29 },
            {21, 13, 5, 28, 20, 12, 4 },
    };

    static int[][] matrixPC2 = {
            {14, 17, 11, 24, 1, 5},
            {3, 28, 15, 6, 21, 10 },
            {23, 19, 12, 4, 26, 8},
            {16, 7, 27, 20, 13, 2},
            {41, 52, 31, 37, 47, 55},
            {30, 40, 51, 45, 33, 48 },
            {44, 49, 39, 56, 34, 53 },
            {46, 42, 50, 36, 29, 32 },
    };

    static int[][] matrixIP1 = {
            {40, 8, 48, 16, 56, 24, 64, 32 },
            {39, 7, 47, 15, 55, 23, 63, 31 },
            {38, 6, 46, 14, 54, 22, 62, 30},
            {37, 5, 45, 13, 53, 21, 61, 29},
            {36, 4, 44, 12, 52, 20, 60, 28},
            {35, 3, 43, 11, 51, 19, 59, 27},
            {34, 2, 42, 10, 50, 18, 58, 26},
            {33, 1, 41, 9, 49, 17, 57, 25},
    };

    //Convert Hexa to Binary
    public static String CovertHexaToBinary(String hexa) {
        HashMap<Character, String> hashMap = new HashMap<>();
        hashMap.put('0', "0000");
        hashMap.put('1', "0001");
        hashMap.put('2', "0010");
        hashMap.put('3', "0011");
        hashMap.put('4', "0100");
        hashMap.put('5', "0101");
        hashMap.put('6', "0110");
        hashMap.put('7', "0111");
        hashMap.put('8', "1000");
        hashMap.put('9', "1001");
        hashMap.put('A', "1010");
        hashMap.put('B', "1011");
        hashMap.put('C', "1100");
        hashMap.put('D', "1101");
        hashMap.put('E', "1110");
        hashMap.put('F', "1111");

        String res = "";
        hexa = hexa.toUpperCase();
        for (int i = 0; i < hexa.length(); i ++) {
            if (hashMap.containsKey(hexa.charAt(i))) {
                res += hashMap.get(hexa.charAt(i));
            }
        }
        return res;
    }

    //Convert Binary to Hexa
    public static String ConvertBinarytoHexa(String binary) {
        String hexa = "";
        for (int i = 0; i < binary.length(); i += 4) {
            String x = binary.substring(i, i+4);
            int a = Integer.parseInt(x, 2);
            hexa += Integer.toHexString(a).toUpperCase();
        }
        return hexa;
    }

    //Hoanvi
    public static String HoanVi(String hexa, int row, int col, int[][] matrix) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < hexa.length(); i ++) {
            map.put(i+1, String.valueOf(hexa.charAt(i)));
        }
        String res = "";
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (map.containsKey(matrix[i][j])) {
                    res += map.get(matrix[i][j]);
                }
            }
        }
        return res;
    }

    //Sinh khóa
    //1.Viết hàm K1 = PC1(K) thực hiện hoán vị PC1
    public static String HoanViPC1(String K) {
        return HoanVi(K, 8, 7, matrixPC1);
    }

    //2.Viết hàm SPLIT_KEY(K1, C, D) tách chuỗi số 56 bit (K1) thành 2 nửa 28 bit trái (C) và phải (D)
    public static void SPLIT_KEY(String K1) {
        C = K1.substring(0, 28);
        D = K1.substring(28, 56);
    }

    //3. Viết hàm ShiftLeft(x, s) dịch vòng trái s bit đối với chuỗi số 28 bit (x)
    public static String ShiftLeft(String x, int s) {
        String k = x.substring(s, x.length());
        k += x.substring(0, s);
        return k;
    }

    //4. Viết hàm Ks = PC2(C, D, s) thực hiện hoán vị PC2
    public static ArrayList<String> HoanViPC2() {
        ArrayList<String> K = new ArrayList<>();
        for (int i = 1; i <= 16; i ++) {
            //System.out.println("C" + (i-1) + " = " + ConvertBinarytoHexa(C)  + ",   D" + (i-1) + " = " + ConvertBinarytoHexa(D));
            if (i == 1 || i == 2 || i == 9 || i == 16) {
                C = ShiftLeft(C, 1);
                D = ShiftLeft(D, 1);
            }
            else {
                C = ShiftLeft(C, 2);
                D = ShiftLeft(D, 2);
            }
            String x = C + D;
            String res = HoanVi(x, 8, 6, matrixPC2);
            //System.out.println("K" + (i) + " = " + ConvertBinarytoHexa(res));
            K.add(res);
        }
        return K;
    }

    //Mã hóa
    //1. Viết hàm y = IP(x) thực hiện hoán vị IP
    public static String HoanViIP(String hexa) {
        return HoanVi(hexa, 8, 8, matrixIP);
    }

    //2. Viết hàm SPLIT(x, L, R) tách chuỗi số 64 bit (x) thành 2 nửa 32 bit trái (L) và phải (R)
    public static void SPLIT(String x) {
        L = x.substring(0, 32);
        R = x.substring(32, 64);
    }

    //3. Viết hàm R1 = E(R) mở rộng chuỗi số 32 bit (R) thành chuỗi số 48 bit (R1) theo ma trận mở rộng E.
    public static String HoanViMR(String R) {
        return HoanVi(R, 8, 6, matrixE);
    }

    //4. Viết hàm XR1K = XOR(R1, Ks) thực hiện phép XOR bit hai chuỗi số 48 bit R1 và Ks.
    public static String XOR(String R1, String Ks) {
        String res = "";
        for (int i = 0; i < R1.length(); i ++) {
            if (String.valueOf(R1.charAt(i)).equals(String.valueOf(Ks.charAt(i)))) {
                res += "0";
            }
            else {
                res += "1";
            }
        }
        return res;
    }

    //5. Viết hàm SXR1K = SUB(XR1K) thực hiện phép thế byte bằng bảng S-box cho chuỗi số 48 bit XR1K.
    public static String SUB(String XR1K) {
        String res = "";
        int[] x = new int[8];
        int[] y = new int[8];
        for (int i = 0; i < 8; i ++) {
            String s = XR1K.substring(6*i, 6*(i+1));
            int row = Integer.parseInt(s.substring(0,1) + s.substring(5,6), 2);
            int col = Integer.parseInt( s.substring(1,5), 2);
            x[i] = row;
            y[i] = col;
        }
        res += CovertHexaToBinary(Integer.toHexString(Sbox1[x[0]][y[0]]));
        res += CovertHexaToBinary(Integer.toHexString(Sbox2[x[1]][y[1]]));
        res += CovertHexaToBinary(Integer.toHexString(Sbox3[x[2]][y[2]]));
        res += CovertHexaToBinary(Integer.toHexString(Sbox4[x[3]][y[3]]));
        res += CovertHexaToBinary(Integer.toHexString(Sbox5[x[4]][y[4]]));
        res += CovertHexaToBinary(Integer.toHexString(Sbox6[x[5]][y[5]]));
        res += CovertHexaToBinary(Integer.toHexString(Sbox7[x[6]][y[6]]));
        res += CovertHexaToBinary(Integer.toHexString(Sbox8[x[7]][y[7]]));
        return res;
    }

    //6. Viết hàm F = P(SXR1K) thực hiện hoán vị P
    public static String HoanViP(String SXR1K) {
        return HoanVi(SXR1K, 8, 4, matrixP);
    }

    // Hoán vị IP-1
    public static String HoanViIP1(String LR) {
        return HoanVi(LR, 8, 8, matrixIP1);
    }

    public static void main(String[] args) {
        String K = "B35F59255E3BCB54";
        String M = "32D604E6C4504149";
        System.out.println("Input: ");
        System.out.println("K: " + K);
        System.out.println("M: " + M);

        String convertK = CovertHexaToBinary(K);
        String convertM = CovertHexaToBinary(M);

        //Phần sinh khóa
        //1.Tính hoán vị PC1 đối với khóa K
        String K1 = HoanViPC1(convertK);
        SPLIT_KEY(K1);

        //2 & 3.Tính các giá trị dịch vòng Ci, Di, Tính khóa Ki cho vòng lặp thứ i
        ArrayList<String> Ki = HoanViPC2();

        //Phần mã hóa
        //4.Tính hoán vị IP đối với bản tin M
        String M1 = HoanViIP(convertM);
        SPLIT(M1);

        for (int i = 0; i < 16; i ++) {
            //5.Tính hàm mở rộng nửa phải E[R0]
            String ER = HoanViMR(R);

            //6.Thực hiên XOR ER0 với khoa K1
            String A = XOR(ER, Ki.get(i));

            //7.Thực hiện phép thế S-box đối với B
            String B = SUB(A);

            //8.Thực hiện hoán vị P đối với SB
            String F = HoanViP(B);

            //đổi
            String L1 = R;
            R = XOR(L, F);
            L = L1;
            //System.out.println("L" + i + "=" + ConvertBinarytoHexa(L) + " " + "R" + i + "=" + ConvertBinarytoHexa(R));

        }

        //11.Thực hiện hoán vị cuối cùng IP-1
        String L16R16 = R + L ;
        String C = HoanViIP1(L16R16);
        C = ConvertBinarytoHexa(C);
        System.out.println("Output: ");
        System.out.println("C = " + C);
    }
}

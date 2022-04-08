package Chapter3;

import java.util.*;

public class AES {
    static String[][] Sbox = {
            {"63", "7C", "77", "7B", "F2", "6B", "6F", "C5", "30", "01", "67", "2B", "FE", "D7", "AB", "76"},
            {"CA", "82", "C9", "7D", "FA", "59", "47", "F0", "AD", "D4", "A2", "AF", "9C", "A4", "72", "C0"},
            {"B7", "FD", "93", "26", "36", "3F", "F7", "CC", "34", "A5", "E5", "F1", "71", "D8", "31", "15"},
            {"04", "C7", "23", "C3", "18", "96", "05", "9A", "07", "12", "80", "E2", "EB", "27", "B2", "75"},
            {"09", "83", "2C", "1A", "1B", "6E", "5A", "A0", "52", "3B", "D6", "B3", "29", "E3", "2F", "84"},
            {"53", "D1", "00", "ED", "20", "FC", "B1", "5B", "6A", "CB", "BE", "39", "4A", "4C", "58", "CF"},
            {"D0", "EF", "AA", "FB", "43", "4D", "33", "85", "45", "F9", "02", "7F", "50", "3C", "9F", "A8"},
            {"51", "A3", "40", "8F", "92", "9D", "38", "F5", "BC", "B6", "DA", "21", "10", "FF", "F3", "D2"},
            {"CD", "0C", "13", "EC", "5F", "97", "44", "17", "C4", "A7", "7E", "3D", "64", "5D", "19", "73"},
            {"60", "81", "4F", "DC", "22", "2A", "90", "88", "46", "EE", "B8", "14", "DE", "5E", "0B", "DB"},
            {"E0", "32", "3A", "0A", "49", "06", "24", "5C", "C2", "D3", "AC", "62", "91", "95", "E4", "79"},
            {"E7", "C8", "37", "6D", "8D", "D5", "4E", "A9", "6C", "56", "F4", "EA", "65", "7A", "AE", "08"},
            {"BA", "78", "25", "2E", "1C", "A6", "B4", "C6", "E8", "DD", "74", "1F", "4B", "BD", "8B", "8A"},
            {"70", "3E", "B5", "66", "48", "03", "F6", "0E", "61", "35", "57", "B9", "86", "C1", "1D", "9E"},
            {"E1", "F8", "98", "11", "69", "D9", "8E", "94", "9B", "1E", "87", "E9", "CE", "55", "28", "DF"},
            {"8C", "A1", "89", "0D", "BF", "E6", "42", "68", "41", "99", "2D", "0F", "B0", "54", "BB", "16"},
    };

    static String[][] mixC = {
            {"02", "03", "01", "01"},
            {"01", "02", "03", "01"},
            {"01", "01", "02", "03"},
            {"03", "01", "01", "02"},
    };

    static String[] Rcon = {"01", "02", "04", "08", "10", "20", "40", "80", "1b", "36"};

    static String M = "4AEB5D62EC3B55DBF5D5A87708E2FF1E".toUpperCase();
    static String K = "6704C20E086B3F537AE5721F486DC559".toUpperCase();
    static String[][] matrixM = addMatrix(M);
    static String[][] matrixK = addMatrix(K);
    static ArrayList<String> Key = new ArrayList<>();

    //add String into matrix
    public static String[][] addMatrix(String a) {
        String[][] matrix = new String[4][4];
        int k = 0;
        for (int i = 0; i < 4; i ++) {
            for (int j = 0; j < 4; j ++) {
                matrix[j][i] = a.substring(k, k+2);
                k += 2;
            }
        }
        return matrix;
    }

    //Convert Hexa to Binary
    public static String ConvertHexaToBinary(String hexa) {
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

    // Phần sinh khóa
    // RotWord dịch 1 byte về bên trái
    public static String RotWord(String a) {
        String res = "";
        res += a.substring(2,a.length());
        res += a.substring(0,2);
        return res;
    }

    //Sinh 10 khóa
    public static void SinhKhoa(String a) {
        String w0 = a.substring(0,8);
        String w1 = a.substring(8, 16);
        String w2 = a.substring(16, 24);
        String w3 = a.substring(24, 32);
        int count = 0;
        while(count < 10) {
            String gx = RotWord(w3); //dịch trái
            gx = SUBBYTE(gx); //subbyte bằng ma trận Sbox
            gx = XOR(gx.substring(0,2),Rcon[count]) + gx.substring(2,w3.length()); // cộng với Rcon
            String w4 = XOR(gx, w0);
            String w5 = XOR(w4, w1);
            String w6 = XOR(w5, w2);
            String w7 = XOR(w6, w3);
            Key.add(w4 + w5 + w6 + w7); //thêm key
            w3 = w7; w0 = w4; w1 = w5; w2 = w6;
            count ++;
        }
    }

    //0.Subbyte matrix
    public static void SUBBYTEMatrix(String[][] matrix) {
        for (int i = 0; i < 4; i ++) {
            for (int j =0 ; j < 4; j ++) {
                int x = Integer.parseInt(matrix[i][j].substring(0, 1), 16);
                int y = Integer.parseInt(matrix[i][j].substring(1, 2), 16);
                matrix[i][j] = Sbox[x][y];
            }
        }
    }

    //1. Viết hàm y = SUBBYTE(state) thực hiện việc thế byte.
    public static String SUBBYTE(String a) {
        String res = "";
        for (int i = 0; i < a.length(); i += 2) {
            int x = Integer.parseInt(a.substring(i,i+1), 16);
            int y = Integer.parseInt(a.substring(i+1,i+2), 16);
            res += Sbox[x][y];
        }
        return res;
    }

    //2. Viết hàm y = SHIFTROW(state) thực hiện việc dịch hàng.
    public static void reverse(int x, int y, String a[]) {
        if (x >= 0 && x < a.length && y >= 0 && y < a.length) {
            while (x < y) {
                String tmp = a[x];
                a[x] = a[y];
                a[y] = tmp;
                x++;
                y--;
            }
        }
    }

    public static void SHIFTROW(String[][] matrix) {
        for (int i = 1; i < matrix.length; i ++) {
            reverse(0, i-1, matrix[i]);
            reverse(i, matrix[i].length-1, matrix[i]);
            reverse(0, matrix[i].length-1, matrix[i]);
        }
    }

    //3. Viết hàm y = MIXCOLUMN(state) thực hiện việc nhân ma trận.
    public static void MIXCOLUMN(String[][] matrix) {
        String[][] res = new String[4][4];
        for (int i = 0; i < 4; i++) {
            int k = 0;
            for (int j = 0; j < 4; j ++) {
                String r1 = MULTI(mixC[i][0], matrix[0][k]);
                String r2 = MULTI(mixC[i][1], matrix[1][k]);
                String r3 = MULTI(mixC[i][2], matrix[2][k]);
                String r4 = MULTI(mixC[i][3], matrix[3][k]);
                String x = XOR(XOR(r1, r2), XOR(r3, r4));
                res[i][j] = ConvertBinarytoHexa(x);
                k++;
            }
        }
        for (int i = 0; i < 4; i ++) {
            for (int j = 0; j < 4; j ++) {
                matrix[i][j] = res[i][j];
            }
        }
    }

    //4.Viết hàm y = ADDROUNDKEY(state, K) thực hiện việc cộng ma trận.
    public static void ADDROUNDKEY(String[][] matrix) {
        for (int i = 0; i < 4; i ++) {
            for (int j = 0; j < 4; j++) {
                matrixM[i][j] = XOR(matrixM[i][j], matrix[i][j]);
            }
        }
    }

    //XOR
    public static String XOR(String a, String b) {
        a = ConvertHexaToBinary(a);
        b = ConvertHexaToBinary(b);
        String res = "";
        for (int i = 0; i < a.length(); i ++) {
            if (String.valueOf(a.charAt(i)).equals(String.valueOf(b.charAt(i)))) {
                res += "0";
            }
            else {
                res += "1";
            }
        }
        return ConvertBinarytoHexa(res);
    }

    //MULTI
    public static String MULTI(String a, String b) {
        String x = ConvertHexaToBinary(b);
        String mx = "00011011";
        //nếu a = 02 thì dịch trái và kiểm tra xem có lớn hơn 2^8 không
        if (a.equals("02")) {
            x += "0";
            String d = x.substring(0,1);
            String c = ConvertBinarytoHexa(x.substring(1,9));
            if (d.equals("1")) {
                x = XOR(x.substring(1,9), mx);
            }
            else {
                x = x.substring(1,9);
            }
        }
        //nếu a = 03,  a * 03 = a xor a * 02
        else if(a.equals("03")) {
            String y = MULTI("02", b);
            x = XOR(x, y);
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println("Input: ");
        System.out.println("M = " + M);
        System.out.println("K = " + K);

        //Sinh khóa
        SinhKhoa(K);
        //System.out.println("10 khóa được sinh : " + Key);

        //lần đầu cộng M với K
        ADDROUNDKEY(matrixK);

        //chạy 9 lần
        for (int i = 0; i < 9; i ++) {
            SUBBYTEMatrix(matrixM);
            SHIFTROW(matrixM);
            MIXCOLUMN(matrixM);
            ADDROUNDKEY(addMatrix(Key.get(i)));
        }

        //chạy lần cuối không có MIXCOLUMN
        SUBBYTEMatrix(matrixM);
        SHIFTROW(matrixM);
        ADDROUNDKEY(addMatrix(Key.get(9)));

        //In ra kết quả
        String result = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j ++) {
                result += matrixM[j][i];
            }
        }
        System.out.println("Output: ");
        System.out.println("C = " + result);
    }
}

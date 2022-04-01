package Chapter3;

import Chapter2.HaBac;
import Chapter2.NghichDaoEuclidMoRong;

public class RSA {
    public static int gcd(int a, int b) {
        for (int i = 2; i <= a && i <= b; i ++) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
    public static void SinhKhoa(int p, int q, int e, int M) {
        NghichDaoEuclidMoRong res = new NghichDaoEuclidMoRong();
        int n = p * q;
        int fiN = (p - 1) * (q - 1);
        int d = res.Result(e, fiN);
        System.out.println("PU = " + "{" + e + "," + n + "}");
        System.out.println("PR = " + "{" + d + "," + n + "}");

        HaBac res1 = new HaBac();
        int C = res1.HaBac(M, e, n);
        System.out.println("C = " + M + "^" + e + " mod " + n + " = " + C);
        M = res1.HaBac(C, d, n);
        System.out.println("M = " + C + "^" + d + " mod " + n + " = " + C);
    }
    public static void main(String[] args) {
        int p = 17, q = 11, e = 7;
        int M = 88;
        SinhKhoa(p, q, e, M);
    }
}

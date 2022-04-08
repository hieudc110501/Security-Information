package Chapter4;

import Chapter2.HaBac;
import Chapter2.NghichDaoEuclidMoRong;

public class ElGamal {

    public static void Xuly(int q, int a, int xA, int M, int k) {
        HaBac res = new HaBac();
        NghichDaoEuclidMoRong euclidMoRong = new NghichDaoEuclidMoRong();
        //Tao Khoa: yA = a^xA mod q
        int yA = res.HaBac(a, xA, q);
        System.out.println("PU = " + "{" + q + ", " + a + ", " + yA + "}");

        //Gui tin nhan
        //K1 = yA^k mod q
        int K1 = res.HaBac(yA, k, q);
        //C1 = a^k mod q
        int C1 = res.HaBac(a, k, q);
        //C2 = K1 * M % q
        int C2 = (K1 * M) % q;
        System.out.println("Ban Ma: {C1,C2) = " + "{" + C1 + "," + C2 + "}");

        //Gia ma tu tin nhan
        //K2 = C1^xA mod q
        int K2 = res.HaBac(C1, xA, q);
        //M1 = (C2 * K2^-1) mod q
        int M1 = (C2 * euclidMoRong.Result(K2,q)) % q;
        System.out.println("Ban ro: M = " + M1);
    }

    public static void main(String[] args) {
        int q = 7349, a = 3, xA = 366, M = 333, k = 32;
        Xuly(q, a, xA, M, k);
    }
}

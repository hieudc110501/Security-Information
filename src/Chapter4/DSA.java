package Chapter4;

import Chapter2.HaBac;
import Chapter2.NghichDaoEuclidMoRong;

public class DSA {

    public static void Xuly(int HM, int p, int q, int h, int xA, int k) {
        HaBac res = new HaBac();
        NghichDaoEuclidMoRong euclidMoRong = new NghichDaoEuclidMoRong();
        //Khoa cong khai
        int g = res.HaBac(h, (p-1)/q, p);
        int y = res.HaBac(g, xA, p);
        System.out.println("Khoa cong khai: y = " + y);

        //Chu ky so
        int r = y % q;
        // (k^-1)*(HM + xA * r) mod q
        int s = euclidMoRong.Result(k, q) *  ((HM + xA * r) % q);
        System.out.println("Chu ki so: {r,s} = " + "{" + r + "," + s + "}");

        //Xac minh chu ki
        //w = s^-1 mod q
        int w = euclidMoRong.Result(s, q);
        int u1 = (HM * w) % q;
        int u2 = (r * w) % q;
        //v = ((g^u1 * g^u2) mod p) mod q
        int v = (res.HaBac(g, u1, p) * res.HaBac(g, u2, p)) % q;
        if (v == r)
            System.out.println("Xac minh dung");
        else
            System.out.println("Xac minh sai");
    }
    public static void main(String[] args) {
        int HM = 25, p = 59, q = 29, h = 10, xA = 2, k = 3;
        Xuly(HM, p, q, h, xA, k);
    }
}

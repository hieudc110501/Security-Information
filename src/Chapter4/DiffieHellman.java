package Chapter4;

import Chapter2.HaBac;

public class DiffieHellman {
    public static void Xuly(int q, int a, int xA, int xB) {
        int yA, yB;
        HaBac res = new HaBac();
        //yA = a^xA mod q
        //yB = a^xB mod q
        yA = res.HaBac(a, xA, q);
        yB = res.HaBac(a, xB, q);
        //kA = yB^xA mod q
        //kB = yA^xB mod q
        System.out.println("yA = " + yA + " , " + "KA = " + res.HaBac(yB, xA, q));
        System.out.println("yB = " + yB + " , " + "KB = " + res.HaBac(yA, xB, q));
    }
    public static void main(String[] args) {
        int q = 7523, a = 5;
        int xA = 387, xB = 247;
        System.out.println("q = " + q + ", a = " + a + ", xA = " + xA + ", xB = " + xB);
        Xuly(q, a, xA, xB);
    }
}

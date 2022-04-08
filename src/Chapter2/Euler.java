package Chapter2;

import javax.xml.transform.Result;

public class Euler {

    //gcd
    public static int gcd(int a, int b) {
        int res = 1;
        for (int i = 2; i < a && i < b; i ++) {
            if (a % i == 0 && b % i == 0)
                res = i;
        }
        return res;
    }

    public static void Result(int a, int m, int n) {
        DLEuler euler = new DLEuler();
        //a vs n cung la nguyen to a^fiN = 1 mod n
        if (gcd(a,n)  == 1) {
            int du = m % (euler.FiN(n));
            HaBac res = new HaBac();
            System.out.println(a + "^" + m + " mod " + n + " = " + a + "^" + du + " mod " + n + " = " + res.HaBac(a,du,n));
        }
        //a vs n cung la nguyen a^fiN+1 = a mod n
        else {
            int du =  m % (euler.FiN(n)+1);
            int thuong = m / (euler.FiN(n)+1);
            HaBac res = new HaBac();
            System.out.println(a + "^" + m + " mod " + n + " = " + a + "^" + (du+thuong) + " mod " + n + " = " + res.HaBac(a,du+thuong,n));
        }
    }

    public static void main(String[] args) {
        Result(38, 2934, 220);
    }
}

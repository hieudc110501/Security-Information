package Chapter2;

public class Fermat {

    //check snt
    public static boolean check(int a) {
        for (int i = 2; i < Math.sqrt(a); i++) {
            if (a % i == 0)
                 return false;
        }
        return true;
    }

    //tính
    public static void Xuly(int a, int m, int n) {
        // nếu n là số nguyên tố
        if (check(n)) {
            // a không chia hết cho n
            if (a % n != 0) {
                //TH1: n-1 , a^(n-1) mod n = 1
                int du = m % (n-1);
                HaBac res = new HaBac();
                System.out.println(a + "^" + m + " mod " + n + " = " + a + "^" + du + " mod " + n + " = " + res.HaBac(a, du, n));
            }
            // a chia hết cho n
            else {
                //TH2: n, a^(n) mod n = a
                int du = m % n;
                HaBac res = new HaBac();
                System.out.println(a + "^" + m + " mod " + n + " = " + a + "^" + du + " mod " + n + " = " + res.HaBac(a, du, n));
            }
        }
    }

    public static void main(String[] args) {
        int a = 239, m = 6653, n = 6653;
        Xuly(a, m, n);
    }
}

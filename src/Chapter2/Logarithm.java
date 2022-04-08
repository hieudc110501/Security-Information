package Chapter2;

public class Logarithm {

    public static void Xuly(int a, int b, int n) {
        CanNguyenThuy cnt = new CanNguyenThuy();
        if (!cnt.checkCNT(a, n))
            System.out.println("Vo nghiem");
        else {
            HaBac res = new HaBac();
            // a^i mod n == b => K
            for (int i = 1; i < n; i ++) {
                if (res.HaBac(a, i, n) == b) {
                    System.out.println("k = " + i);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a = 2, b = 7, n = 11;
        Xuly(a, b, n);
    }
}

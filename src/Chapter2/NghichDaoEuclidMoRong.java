package Chapter2;

public class NghichDaoEuclidMoRong {

    //ucln
    public static int gcd(int a, int b) {
        int res = 1;
        for (int i = 2; i <= a && i <= b; i ++) {
            if (a % i == 0 && b % i == 0) {
                res = i;
            }
        }
        return res;
    }

    //check số nguyên tố
    public static boolean check(int m) {
        for (int i = 2; i < Math.sqrt(m); i ++) {
            if (m % i == 0)
                return false;
        }
        return true;
    }

    //số nguyên tố cùng nhau
    public static boolean checkAll(int a, int m) {
        return (!check(a) && !check(m)) ? true : false;
    }

    //cách 1
    public static int Result(int a, int n) {

        int r2 = n, r1 = a; //r2 là phần tử i-2, r1 là phần tử i-1
        int x2 = 1, x1 = 0, y2 = 0, y1 = 1; //x,y tương tự
        int r = 1, q, x, y;
        if (r2 != 0 && r1 != 0)
        while (r != 0) {
            r = r2 % r1;
            q = r2 / r1;
            r2 = r1; r1 = r; //tăng i

            x = x2 - q * x1;
            y = y2 - q * y1;
            x2 = x1; x1 = x; //tăng i
            y2 = y1; y1 = y; //tăng i

            // a^-1 mod n => x*n + y*a = gcd(a,n)
            if ((x * n + y * a) == gcd(a,n)) {
                return (y > 0) ? y : y+n;
            }
        }
        return 0;
    }

    //cách 2
    public static int Result2(int a, int n) {
        for (int i = 0; i < n; i ++) {
            if ((n * i + 1) % (a % n) == 0) {
                return (n * i + 1) / (a % n);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int a = 2183, n = 29;
        if (!checkAll(a, n))
            System.out.println(a + "^-1" + " mod " + n  + " = " + Result(a,n));
        else
            System.out.println("Khong the " + a + "^-1" + " mod " + n);
    }
}

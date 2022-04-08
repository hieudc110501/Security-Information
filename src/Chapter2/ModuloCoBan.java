package Chapter2;

public class ModuloCoBan {
    public static void Xuly(int a, int b,int x,int y,int n) {
        HaBac res = new HaBac();
        NghichDaoEuclidMoRong euclidMoRong = new NghichDaoEuclidMoRong();
        int a1 = res.HaBac(a, x, n);
        int b1 = res.HaBac(b, y, n);

        System.out.println("A1 = (" + a + "^" + x + " + " + b + "^" + y + ") mod " + n + " = " + (a1 % n + b1 % n));
        System.out.println("A2 = (" + a + "^" + x + " - " + b + "^" + y + ") mod " + n + " = " + (a1 % n - b1 % n));
        System.out.println("A3 = (" + a + "^" + x + " * " + b + "^" + y + ") mod " + n + " = " + ((a1 % n) * (b1 % n)));
        System.out.println("A4 = (" + b + "^" + y + ")" + "^-1 = " + " mod " + n + " = " + euclidMoRong.Result(b1, n));
        System.out.println("A5 = (" + a + "^" + x + " / " + b + "^" + y + ") = " + (a1 * b1 % n));

    }
    public static void main(String[] args) {
        int a = 31, b = 67, x = 375, y = 539, n = 211;
        Xuly(a,b,x,y,n);
    }
}

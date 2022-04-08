package Chapter2;

public class CanNguyenThuy {

    static int c = 0;

    //tìm các ước của fiN
    public static int[] uoc(int n) {
        DLEuler dlEuler = new DLEuler();
        n = DLEuler.FiN(n);
        int a[] = new int[n/2];
        for (int i = 1; i < n; i ++) {
            if (n % i == 0) {
                a[c++] = i;
            }
        }
        return a;
    }

    //Kiểm tra có phải là căn nguyên thủy không
    public static boolean checkCNT(int a, int n) {
        int[] x = uoc(n);
        HaBac res = new HaBac();
        for (int i = 0; i < c; i ++) {
            // nếu a^xi mod n = 1 tại vị trí i != c thì không phải
            if (res.HaBac(a, x[i], n) == 1) {
                return false;
            }
        }
        return true;
    }

    public static void print(int a, int n) {
        if (checkCNT(a, n) == false)
            System.out.println(a + " khong phai la can nguyen thuy cua " + n);
        else
            System.out.println(a + " la can nguyen thuy cua " + n);
    }

    public static void main(String[] args) {
        int a = 2, n = 7;
        print(a, n);
    }
}

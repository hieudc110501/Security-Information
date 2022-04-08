package Chapter2;

public class SoDuTrungHoa {

    // sàn nguyên tố
    public static int[] snt(int n) {
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) check[i] = true;
        check[0] = check[1] = false;
        for (int i = 2; i < Math.sqrt(n); i++) {
            for (int j = i * i; j < n; j += i) {
                check[j] = false;
            }
        }
        int sz = 0;
        for (boolean x : check) if (x) sz++;

        int a[] = new int[sz];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (check[i]) a[j++] = i;
        }
        return a;
    }

    // Xử lí
    public static void Xyly(int b, int k, int n) {
        // tìm m
        int[] snt = snt(n);
        int[] m = new int[10];
        int i = 0;
        int count = 0;
        int n1 = n;
        while (n1 != 0 && i < snt.length) {
            if (n1 % snt[i] == 0) {
                n1 /= snt[i];
                m[count++] = snt[i];
            }
            else {
                i++;
            }
        }

        // tìm a
        int[] a = new int[10];
        HaBac res = new HaBac();
        for (int j = 0; j < count; j ++) {
            a[j] = res.HaBac(b, k, m[j]);
        }

        // tính A
        // M[i] = n / m[i]
        // c[i] = M[i] * M^-1 mod m[i]
        // A = (a[1] * c[1] + ... + a[i] * c[i]) mod M
        int A = 0;
        NghichDaoEuclidMoRong euclidMoRong = new NghichDaoEuclidMoRong();
        for (int j = 0; j < count; j ++) {
            int M = n / m[j];
            int c = M * euclidMoRong.Result(M, m[j]);
            A += a[j] * c;
        }
        System.out.println(b + "^" + k + " mod " + n + " = " + A + " mod " + n + " = " + (A % n));
    }


    public static void main(String[] args) {
        int a = 241, k = 59, n = 63307;
        Xyly(a, k, n);
    }
}

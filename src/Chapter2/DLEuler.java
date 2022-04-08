package Chapter2;

public class DLEuler {
    // check số nguyên tố
    public static boolean checknt(int a) {
        for (int i = 2; i < Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

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

    public static int FiN(int n) {
        int res = 1;
        if (checknt(n)) return n - 1;
        else {
            int[] a = snt(n);
            int i = 0;
            int c = 0;
            while (n != 0 && i < a.length) {
                if (n % a[i] == 0) {
                    c++;
                    n /= a[i];
                } else {
                    if (c != 0) {
                        if (c == 1) {
                            res *= (a[i] - 1);
                        } else {
                            res *= (Math.pow(a[i], c) - Math.pow(a[i], c - 1));
                        }
                        c = 0;
                    }
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(FiN(23));
    }
}

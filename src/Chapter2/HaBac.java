package Chapter2;

import java.math.BigInteger;
import java.util.*;

public class HaBac {

    static class pair {
        int key;
        int value;

        public pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static int HaBac(int a, int m, int n) {
        int thuong = m, du = m % 2;

        Stack<pair> stack = new Stack<>();

        while (thuong > 1) {
            stack.push(new pair(thuong, du));
            thuong /= 2;
            du = thuong % 2;
        }
        long mod1 = a % n;
        long mod = a % n;
        for (int i = stack.size() - 1; i >= 0; i --) {
            mod = (long) ( Math.pow(mod, 2) * Math.pow(mod1, stack.get(i).value)) % n;
        }
        return (int) mod;
    }

    public static void main(String[] args) {
        int a = 1962, m = 422, n = 7207;
        System.out.println(a + "^" + m  + " mod " + n + " = " + HaBac(300,15,30));
    }
}

package Chapter2;

public class GPTSoDuTrungHoa {
    public static void Xuly(int m1, int m2, int m3, int a1, int a2, int a3) {
        int M = m1 * m2 * m3;
        int M1 = m2 * m3, M2 = m1 * m3, M3 = m1 * m2;
        NghichDaoEuclidMoRong euclidMoRong = new NghichDaoEuclidMoRong();
        //Ci = Mi * Mi^-1 mod mi
        int c1 = M1 * euclidMoRong.Result(M1, m1);
        int c2 = M2 * euclidMoRong.Result(M2, m2);
        int c3 = M3 * euclidMoRong.Result(M3, m3);
        System.out.println(M1 + " " + M2 + " " + M3);
        System.out.println(c1 + " " + c2 + " " + c3);
        int A = a1 * c1 + a2 * c2 + a3 * c3;
        // x = A mod M
        System.out.println("x = " + A + " mod " + M + " = " + (A % M));
    }
    public static void main(String[] args) {
        int m1 = 19, m2 = 11, m3 = 13, a1 = 5, a2 = 5, a3 = 6;
        Xuly(m1, m2, m3, a1, a2, a3);
    }
}

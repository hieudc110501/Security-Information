package Chapter3;

public class test4 {
    public static void main(String[] args) {
        String s = "01011100100000101011010110010111";
        String res = "";
        for (int i = 0; i < s.length(); i ++) {
            res += String.valueOf(s.charAt(i))  + "\n";
        }
        System.out.println(res);
    }
}

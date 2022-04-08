package Chapter3;

public class test2 {

    public static void main(String[] args) {
        String s = "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "1\n" +
                "1\n" +
                "0\n" +
                "0\n" +
                "1\n" +
                "1\n" +
                "0\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "1\n" +
                "0\n" +
                "0\n" +
                "1\n" +
                "1\n" +
                "0\n" +
                "0\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n";
        String res = "";
        for (int i = 0; i < s.length(); i ++) {
            if (String.valueOf(s.charAt(i)).equals("\n")) {
                res += "";
            }
            else
                res += String.valueOf(s.charAt(i));

        }
        System.out.println(res);
    }
}

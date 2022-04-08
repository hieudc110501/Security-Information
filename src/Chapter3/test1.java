package Chapter3;

public class test1 {
    public static void main(String[] args) {
        String s = "\n" +
                "63\t7c\t77\t7b\tf2\t6b\t6f\tc5\t30\t01\t67\t2b\tfe\td7\tab\t76\n" +
                "ca\t82\tc9\t7d\tfa\t59\t47\tf0\tad\td4\ta2\taf\t9c\ta4\t72\tc0\n" +
                "b7\tfd\t93\t26\t36\t3f\tf7\tcc\t34\ta5\te5\tf1\t71\td8\t31\t15\n" +
                "04\tc7\t23\tc3\t18\t96\t05\t9a\t07\t12\t80\te2\teb\t27\tb2\t75\n" +
                "09\t83\t2c\t1a\t1b\t6e\t5a\ta0\t52\t3b\td6\tb3\t29\te3\t2f\t84\n" +
                "53\td1\t00\ted\t20\tfc\tb1\t5b\t6a\tcb\tbe\t39\t4a\t4c\t58\tcf\n" +
                "d0\tef\taa\tfb\t43\t4d\t33\t85\t45\tf9\t02\t7f\t50\t3c\t9f\ta8\n" +
                "51\ta3\t40\t8f\t92\t9d\t38\tf5\tbc\tb6\tda\t21\t10\tff\tf3\td2\n" +
                "cd\t0c\t13\tec\t5f\t97\t44\t17\tc4\ta7\t7e\t3d\t64\t5d\t19\t73\n" +
                "60\t81\t4f\tdc\t22\t2a\t90\t88\t46\tee\tb8\t14\tde\t5e\t0b\tdb\n" +
                "e0\t32\t3a\t0a\t49\t06\t24\t5c\tc2\td3\tac\t62\t91\t95\te4\t79\n" +
                "e7\tc8\t37\t6d\t8d\td5\t4e\ta9\t6c\t56\tf4\tea\t65\t7a\tae\t08\n" +
                "ba\t78\t25\t2e\t1c\ta6\tb4\tc6\te8\tdd\t74\t1f\t4b\tbd\t8b\t8a\n" +
                "70\t3e\tb5\t66\t48\t03\tf6\t0e\t61\t35\t57\tb9\t86\tc1\t1d\t9e\n" +
                "e1\tf8\t98\t11\t69\td9\t8e\t94\t9b\t1e\t87\te9\tce\t55\t28\tdf\n" +
                "8c\ta1\t89\t0d\tbf\te6\t42\t68\t41\t99\t2d\t0f\tb0\t54\tbb\t16";
        String res = "";
        char x = '"';
        boolean check = false;
        for (int i = 0; i < s.length(); i ++) {
            if (!check) res += x;
            if (String.valueOf(s.charAt(i)).equals("\t")) {
                res += x + ", ";
                check = false;
            }
            else {
                check = true;
                res += String.valueOf(s.charAt(i)).toUpperCase();
            }

            if (String.valueOf(s.charAt(i)).equals("\n"))
            {
                res += x;
            }
        }
        System.out.println(res);
    }
}

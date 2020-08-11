import java.util.*;

public class ScratchBook {
    public static void main(String[] args) {

        System.out.println(Character.toLowerCase('9'));


        StringBuilder s = new StringBuilder().append("d,c");
        s.replace(0,0, "p");
        System.out.println(s.toString());
        s.replace(0,1, "q");
        System.out.println(s.toString());
        System.out.println(s.toString().split(","));
        StringBuffer p = new StringBuffer("1111111");
        p.replace(6, 7, "0");
        System.out.println(p.toString());


        HashSet<Integer> set = new HashSet<Integer>();
        set.add(4);
        set.remove(4);
        set.contains(4);
        boolean[] dp = new boolean[5];
        Arrays.fill(dp, false);
        String name = "Pradeep";
        System.out.println(name.substring(0, 2));
    }
}

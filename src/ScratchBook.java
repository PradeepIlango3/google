import java.util.*;

public class ScratchBook {
    public static void main(String[] args) {

        //Stack
        Stack<Integer> stack = new Stack<Integer>();

        //LinkedList
        System.out.println("LinkedList:");
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.addFirst(3);
        list.removeFirst();
        System.out.println("size: "+list.size());
        System.out.println(list);
    }
}

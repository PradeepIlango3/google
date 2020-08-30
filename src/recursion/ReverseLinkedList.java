package recursion;

public class ReverseLinkedList {

    public static void reverse (LinkedList list) {
        list.head = reverse(list.head);
    }

    private static LinkedList.Node reverse(LinkedList.Node node) {
        if (node == null || node.next == null) return node;
        else {
            LinkedList.Node next = node.next;
            node.next = next.next;
            next.next = node;
            node.next = reverse(node.next);
            return next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        ReverseLinkedList.reverse(list);
        list.print();
        list.reverse();
        list.print();
        list.reverseR();
        list.print();
    }
}

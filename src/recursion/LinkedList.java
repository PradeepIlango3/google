package recursion;

public class LinkedList {
    Node head;

    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public void add(int val) {
        Node node = new Node(val);
        if (head == null) head = node;
        else {
            node.next = head;
            head = node;
        }
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void reverseR() {
         reverseR(head);
    }

    private void reverseR(Node node) {
        if (node == null) {
            return;
        } else if (node.next == null) {
            head = node;
            node.next = null;
        } else {
            reverseR(node.next);
            node.next.next = node;
            node.next = null;
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        System.out.println("List is:");
        Node temp =  head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

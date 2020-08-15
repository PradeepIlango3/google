package MyPackage;
public class Stack<T> {

    Node head;

    private static class Node<T> {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    public void push(T a) {
        Node<T> node = new Node<>(a);
        node.next = head;
        head = node;
    }

    public T pop() {
        if (head == null) return null;
        else {
            Node temp = head;
            head = head.next;
            return (T) temp.data;
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("Stack is empty");
        } else {
            Node temp = head;
            while(temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(15);
        stack.push(50);
        stack.push(25);
        stack.print();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.print();
    }
}

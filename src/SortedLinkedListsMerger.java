
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SortedLinkedListsMerger {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (head == null) {
                    head = l1;
                    tail = l1;
                } else {
                    tail.next = l1;
                    tail = tail.next;
                }
                l1 = l1.next;
            } else {
                if (head == null) {
                    head = l2;
                    tail = l2;
                } else {
                    tail.next = l2;
                    tail = tail.next;
                }
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            if (head == null) {
                head = l1;
            } else {
                tail.next = l1;
            }
        } else if (l2 != null) {
            if (head == null) {
                head = l2;
            } else {
                tail.next = l2;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listA = null;
        ListNode node = new ListNode(1);
        ListNode tailA = null;
        listA = node;
        tailA = node;
        node = new ListNode(2);
        tailA.next = node;
        tailA = tailA.next;
        node = new ListNode(3);
        tailA.next = node;
        tailA = tailA.next;
        ListNode listB = null;
        node = new ListNode(1);
        ListNode tailB = null;
        listB = node;
        tailB = node;
        node = new ListNode(3);
        tailB.next = node;
        tailB = tailB.next;
        node = new ListNode(4);
        tailB.next = node;
        tailB = tailB.next;
        ListNode result = SortedLinkedListsMerger.mergeTwoLists(listA, listB);
        System.out.println("Sorted List :");
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

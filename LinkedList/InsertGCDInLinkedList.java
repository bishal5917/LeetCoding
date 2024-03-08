package LinkedList;

public class InsertGCDInLinkedList {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // lets iterate while calculating and adding gcd
        ListNode curr = head;
        ListNode next = head.next;
        while (next != null) {
            int gcd = gcd(curr.val, next.val);
            ListNode newNode = new ListNode(gcd, null);
            curr.next = newNode;
            newNode.next = next;
            curr = newNode.next;
            next = curr.next;
        }
        return head;
    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a == b) {
            return a;
        }
        if (a > b) {
            return gcd(a - b, b);
        }
        return gcd(a, b - a);
    }

    public static void main(String[] args) {
        InsertGCDInLinkedList obj = new InsertGCDInLinkedList();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(18);
        ll.addAtTail(6);
        ll.addAtTail(10);
        ll.addAtTail(3);
        ll.printList();
        obj.insertGreatestCommonDivisors(ll.head);
        ll.printList();
    }
}

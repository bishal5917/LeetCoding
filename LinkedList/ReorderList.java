package LinkedList;

public class ReorderList {

    public void reorderList(ListNode head) {
        // Now lets just find the middle of the linked list
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode preSlow = null;
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // disconnecting the first half
        preSlow.next = null;
        ListNode left = head;
        ListNode right = reverseHalf(slow);
        ListNode preLeft = null;
        // now using two pointers approach
        while (left != null && right != null) {
            preLeft = left;
            ListNode nextLeft = left.next;
            ListNode nextRight = right.next;
            left.next = right;
            right.next = nextLeft;
            left = nextLeft;
            right = nextRight;
        }
        // now add the last right if itsnot null(In even case,it remains)
        preLeft.next.next = right;
    }

    private ListNode reverseHalf(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            ListNode nextOne = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextOne;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReorderList obj = new ReorderList();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(1);
        ll.addAtTail(2);
        ll.addAtTail(3);
        ll.addAtTail(4);
        ll.addAtTail(5);
        ll.addAtTail(6);
        ll.addAtTail(7);
        ll.printList();
        obj.reorderList(ll.head);
        ll.printList();
    }
}

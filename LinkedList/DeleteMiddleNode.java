package LinkedList;

public class DeleteMiddleNode {

    public ListNode deleteMiddle(ListNode head) {
        // first we gotta find the middle of the linked list
        // using fast and slow pointers
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return null;
        }
        ListNode preSlow = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(preSlow.val);
        System.out.println(slow.val);
        // Now remove the slow one
        preSlow.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        DeleteMiddleNode obj = new DeleteMiddleNode();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(1);
        ll.addAtTail(3);
        ll.addAtTail(4);
        ll.addAtTail(7);
        ll.addAtTail(1);
        ll.addAtTail(2);
        ll.addAtTail(6);
        ll.printList();
        obj.deleteMiddle(ll.head);
        ll.printList();
    }
}

package LinkedList;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        // Lets first find the length of the linked list
        if (head == null) {
            return head;
        }
        int len = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            len += 1;
        }
        // now make it circular
        curr.next = head;
        // find the actual rotations needed
        int rot = k % len;
        int steps = len - rot;
        int c = 0;
        System.out.println(rot);
        // Now go steps from the head
        curr = head;
        ListNode prev = null;
        while (c != steps) {
            prev = curr;
            curr = curr.next;
            c += 1;
        }
        System.out.println(prev.val);
        System.out.println(curr.val);
        // Now disconnect
        prev.next = null;
        head = curr;
        return head;
    }

    public static void main(String[] args) {
        RotateList obj = new RotateList();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(1);
        ll.addAtTail(2);
        ll.addAtTail(3);
        ll.addAtTail(4);
        ll.addAtTail(5);
        ll.printList();
        obj.rotateRight(ll.head, 2);
        ll.printList();
    }
}

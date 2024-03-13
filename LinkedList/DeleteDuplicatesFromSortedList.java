package LinkedList;

public class DeleteDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        // Lets iterate and keep checking using two pointers
        ListNode slow = head;
        ListNode fast = head.next;
        // we will need preslow to remove duplicates in between
        ListNode preSlow = null;
        while (fast != null) {
            if (slow.val == fast.val) {
                // go till we found the same values
                while (fast != null && fast.val == slow.val) {
                    fast = fast.next;
                }
                // System.out.println(preSlow.val);
                // System.out.println(fast.val);
                if (preSlow != null) {
                    preSlow.next = fast;
                } else {
                    // if preslow is null then head was duplicated,so make new head
                    head = fast;
                }
                // set new slow and fast values
                slow = fast;
                if (fast != null) {
                    fast = fast.next;
                }
            } else {
                // else just go forward
                preSlow = slow;
                slow = slow.next;
                fast = fast.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicatesFromSortedList obj = new DeleteDuplicatesFromSortedList();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(1);
        ll.addAtTail(2);
        ll.addAtTail(3);
        ll.addAtTail(3);
        ll.addAtTail(4);
        ll.addAtTail(4);
        ll.addAtTail(5);
        ll.printList();
        obj.deleteDuplicates(ll.head);
        ll.printList();
    }
}

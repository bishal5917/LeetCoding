package LinkedList;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEndTwoPass(ListNode head, int n) {
        // Lets first do a two pass approach
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len += 1;
            curr = curr.next;
        }
        int fromSt = len - n;
        if (head == null) {
            return head;
        }
        if (fromSt == 0) {
            // means remove the head
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        curr = head;
        while (curr != null && curr.next != null) {
            if (fromSt == 1) {
                ListNode another = curr.next.next;
                curr.next = another;
            }
            fromSt -= 1;
            curr = curr.next;
        }
        return head;
    }

    public ListNode removeNthFromEndOnePass(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        // Lets first do a one pass approach
        // using two pointers
        ListNode slow = head;
        ListNode fast = head;
        int c = 0;
        while (c != n && fast != null) {
            fast = fast.next;
            c += 1;
        }
        if (fast == null) {
            // means gotta remove the head
            // return slow.next;
            return slow.next;
        }
        // now go till the fast next is null
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // And remove that one node
        ListNode another = slow.next.next;
        slow.next = another;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd obj = new RemoveNthNodeFromEnd();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(1);
        ll.addAtTail(2);
        ll.addAtTail(3);
        ll.addAtTail(4);
        ll.addAtTail(5);
        ll.printList();
        obj.removeNthFromEndOnePass(ll.head, 2);
        ll.printList();
        obj.removeNthFromEndTwoPass(ll.head, 2);
        ll.printList();
    }
}

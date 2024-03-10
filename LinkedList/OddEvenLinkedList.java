package LinkedList;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddCurr = oddHead;
        ListNode evenCurr = evenHead;
        while (evenCurr != null && evenCurr.next != null) {
            oddCurr.next = evenCurr.next;
            oddCurr = evenCurr.next;
            evenCurr.next = oddCurr.next;
            evenCurr = oddCurr.next;
        }
        // at last connect the even portion with the odd one
        oddCurr.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList obj = new OddEvenLinkedList();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(1);
        ll.addAtTail(2);
        ll.addAtTail(3);
        ll.addAtTail(4);
        ll.addAtTail(5);
        ll.addAtTail(6);
        ll.addAtTail(7);
        ll.addAtTail(8);
        ll.printList();
        obj.oddEvenList(ll.head);
        ll.printList();
    }
}

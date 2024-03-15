package LinkedList;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        // Lets use a dummy node that points to the next
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // Now lets keep swapping
        ListNode first = head;
        ListNode second = head.next;
        ListNode prev = null;
        while (first != null && second != null) {
            ListNode nextOne = second.next;
            second.next = first;
            first.next = nextOne;
            if (first == head) {
                head = second;
                dummy.next = second;
            }
            prev = first;
            first = nextOne;
            if (first != null) {
                second = first.next;
            } else {
                second = null;
            }
            if (prev != null) {
                if (second == null) {
                    // if second is null,no reversing will happen
                    prev.next = first;
                } else {
                    prev.next = second;
                }
            }
        }
        System.out.println(dummy.next.next.next.val);
        return dummy.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs obj = new SwapNodesInPairs();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(1);
        ll.addAtTail(2);
        ll.addAtTail(3);
        ll.addAtTail(4);
        ll.printList();
        obj.swapPairs(ll.head);
        ll.printList();
    }
}

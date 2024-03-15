package LinkedList;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }
        // first lets find the left and right index
        int idx = 1;
        ListNode curr = head;
        ListNode leftNode = null;
        ListNode rightNode = null;
        while (curr != null) {
            if (idx == left - 1) {
                leftNode = curr;
            }
            if (idx == right) {
                rightNode = curr;
            }
            idx += 1;
            curr = curr.next;
        }
        // set the current and last,we will need it later
        if (leftNode == null) {
            curr = head;
        } else {
            curr = leftNode.next;
        }
        ListNode last = rightNode.next;
        // Now reverse the list from leftNode.next to the rightNode
        ListNode prev = null;
        int reversedCount = 0;
        while (curr != null && reversedCount <= (right - left)) {
            ListNode nextOne = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextOne;
            reversedCount += 1;
        }
        // Now connect again
        if (leftNode == null) {
            head = prev;
        } else {
            leftNode.next = prev;
        }
        // Now connect the last of the reversed to the right
        ListNode temp = prev;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = last;
        return head;
    }

    public static void main(String[] args) {
        ReverseLinkedListII obj = new ReverseLinkedListII();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(1);
        ll.addAtTail(2);
        ll.addAtTail(3);
        ll.addAtTail(4);
        ll.addAtTail(5);
        ll.printList();
        obj.reverseBetween(ll.head, 2, 5);
        ll.printList();
    }
}
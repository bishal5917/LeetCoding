package LinkedList;

public class DoubleNumber {
    int carry = 0;
    ListNode start = null;
    ListNode curr = start;

    // Lets just do this using recursion
    public ListNode doubleIt(ListNode head) {
        doubleNodeHelper(head);
        if (carry > 0) {
            ListNode lastOne = new ListNode(carry);
            curr.next = lastOne;
            curr = lastOne;
        }
        System.out.println(start.val);
        System.out.println(curr.val);
        // reverse and return finally
        return reverseList(start);
    }

    private void doubleNodeHelper(ListNode head) {
        if (head == null) {
            return;
        }
        doubleNodeHelper(head.next);
        int sum = head.val * 2 + carry;
        int ans = sum % 10;
        carry = sum / 10;
        ListNode newOne = new ListNode(ans);
        if (start == null) {
            start = newOne;
            curr = start;
        } else {
            curr.next = newOne;
            curr = newOne;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return prev;
    }

    public static void main(String[] args) {
        DoubleNumber obj = new DoubleNumber();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(9);
        ll.addAtTail(9);
        ll.addAtTail(9);
        obj.doubleIt(ll.head);
    }
}
package LinkedList;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        // return reverseLinkedListRecursiveHelper(head, head);
        return reverseLinkedListIterativeHelper(head);
    }

    private ListNode reverseLinkedListIterativeHelper(ListNode head) {
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

    private ListNode reverseLinkedListRecursiveHelper(ListNode head, ListNode curr) {
        if (head == null) {
            return head;
        }
        if (curr.next == null) {
            head = curr;
            return head;
        }
        ListNode prev = curr.next;
        reverseLinkedListRecursiveHelper(head, curr.next);
        System.out.println(curr.val + "" + prev.val);
        prev.next = curr;
        curr.next = null;
        return head;
    }

    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(1);
        ll.addAtTail(2);
        ll.addAtTail(3);
        ll.addAtTail(4);
        ll.addAtTail(5);
        ll.printList();
        obj.reverseList(ll.head);
        ll.printList();
    }

}

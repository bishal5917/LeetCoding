package LinkedList;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head, MyLinkedList list) {
        ListNode i = head;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode j = head.next;

        while (j != null) {
            if (i.val == j.val) {
                ListNode temp = j.next;
                i.next = j.next;
                j = temp;
            } else {
                i = j;
                j = j.next;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(1);
        ll.addAtTail(1);
        ll.addAtTail(2);
        ll.addAtTail(3);
        ll.addAtTail(3);
        RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();
        obj.deleteDuplicates(ll.head, ll);
        ll.printList();
    }
}

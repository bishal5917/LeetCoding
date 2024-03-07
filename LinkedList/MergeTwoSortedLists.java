package LinkedList;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode i = list1;
        ListNode j = list2;
        ListNode dummy = new ListNode();
        ListNode merged = dummy;
        while (i != null && j != null) {
            if (i.val <= j.val) {
                merged.next = i;
                merged = merged.next;
                i = i.next;
            } else {
                merged.next = j;
                merged = merged.next;
                j = j.next;
            }
        }
        while (i != null) {
            merged.next = i;
            merged = merged.next;
            i = i.next;
        }
        while (j != null) {
            merged.next = j;
            merged = merged.next;
            j = j.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MyLinkedList llA = new MyLinkedList();
        llA.addAtTail(1);
        llA.addAtTail(2);
        llA.addAtTail(4);
        MyLinkedList llB = new MyLinkedList();
        llB.addAtTail(0);
        llB.addAtTail(3);
        llB.addAtTail(4);
        MergeTwoSortedLists obj = new MergeTwoSortedLists();
        obj.mergeTwoLists(llA.head, llB.head);
        llA.printList();
        llB.printList();
    }
}

package LinkedList;

public class MergeInBetweenLinkedLists {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // lets first remove the a and b node
        int count = 0;
        ListNode curr = list1;
        ListNode aNode = null;
        ListNode bNode = null;
        while (curr != null) {
            if (count == a - 1) {
                aNode = curr;
            }
            if (count == b) {
                bNode = curr;
            }
            curr = curr.next;
            count += 1;
        }
        System.out.println(aNode.val);
        System.out.println(bNode.val);
        // Now connect the aNode to the head of list2
        aNode.next = list2;
        // And connect the last of the list2 to bnode's next
        ListNode temp = list2;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = bNode.next;
        return list1;
    }

    public static void main(String[] args) {
        MergeInBetweenLinkedLists obj = new MergeInBetweenLinkedLists();
        MyLinkedList la = new MyLinkedList();
        la.addAtTail(10);
        la.addAtTail(1);
        la.addAtTail(13);
        la.addAtTail(6);
        la.addAtTail(9);
        la.addAtTail(5);
        MyLinkedList lb = new MyLinkedList();
        lb.addAtTail(1000000);
        lb.addAtTail(1000001);
        lb.addAtTail(1000002);
        la.printList();
        obj.mergeInBetween(la.head, 3, 4, lb.head);
        la.printList();
    }
}

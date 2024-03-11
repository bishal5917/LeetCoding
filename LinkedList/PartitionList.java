package LinkedList;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        // Lets just do a two pass approach
        ListNode leftHead = null;
        ListNode rightHead = null;
        ListNode leftSt = leftHead;
        ListNode rightSt = rightHead;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                if (leftHead == null) {
                    leftHead = curr;
                    leftSt = curr;
                } else {
                    leftSt.next = curr;
                    leftSt = curr;
                }
            } else {
                if (rightHead == null) {
                    rightHead = curr;
                    rightSt = curr;
                } else {
                    rightSt.next = curr;
                    rightSt = curr;
                }
            }
            curr = curr.next;
        }
        // Now connect last of left to the right head
        if (leftHead == null) {
            return rightHead;
        }
        if (rightHead == null) {
            return leftHead;
        }
        leftSt.next = rightHead;
        rightSt.next = null;
        System.out.println(leftHead.val);
        System.out.println(leftSt.val);
        System.out.println(rightHead.val);
        System.out.println(rightSt.val);
        printList(leftHead);
        return leftHead;
    }

    private void printList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(" --> ");
            } else {
                System.out.println();
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        PartitionList obj = new PartitionList();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(1);
        ll.addAtTail(4);
        ll.addAtTail(3);
        ll.addAtTail(2);
        ll.addAtTail(5);
        ll.addAtTail(2);
        ll.printList();
        obj.partition(ll.head, 2);
    }
}

package LinkedList;

import java.util.Arrays;

public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        // first lets find the grouping
        ListNode[] heads = new ListNode[k];
        if (head == null) {
            return heads;
        }
        // now lets find the length of the linked list
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len += 1;
            curr = curr.next;
        }
        // Now lets calculate numbers in group and extras
        int numInGroups = len / k;
        int extra = len % k;
        int idx = 0;
        int groupedCount = 1;
        System.out.println(numInGroups);
        System.out.println(extra);
        curr = head;
        heads[idx++] = curr;
        while (curr.next != null) {
            // add that to head
            if (extra > 0) {
                if (groupedCount == numInGroups + 1) {
                    // means till that index is found
                    ListNode nextOne = curr.next;
                    curr.next = null;
                    curr = nextOne;
                    extra -= 1;
                    heads[idx++] = nextOne;
                    groupedCount = 1;
                } else {
                    curr = curr.next;
                    groupedCount += 1;
                }
            } else {
                if (groupedCount == numInGroups) {
                    ListNode nextOne = curr.next;
                    curr.next = null;
                    curr = nextOne;
                    heads[idx++] = nextOne;
                    groupedCount = 1;
                } else {
                    curr = curr.next;
                    groupedCount += 1;
                }
            }
        }
        return heads;
    }

    public static void main(String[] args) {
        SplitLinkedListInParts obj = new SplitLinkedListInParts();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(1);
        ll.addAtTail(2);
        ll.addAtTail(3);
        ll.addAtTail(4);
        ll.addAtTail(5);
        ll.addAtTail(6);
        ll.addAtTail(7);
        ll.addAtTail(8);
        ll.addAtTail(9);
        ll.addAtTail(10);
        ListNode[] ans = obj.splitListToParts(ll.head, 3);
        System.out.println(Arrays.asList(ans));
        // Lets print each values of the node to check
        for (ListNode n : ans) {
            if (n == null) {
                return;
            }
            System.out.println(n.val);
        }
    }
}
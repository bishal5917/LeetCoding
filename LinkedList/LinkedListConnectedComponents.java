package LinkedList;

import java.util.HashSet;

public class LinkedListConnectedComponents {

    public int numComponents(ListNode head, int[] nums) {
        int count = 0;
        HashSet<Integer> numSet = new HashSet<>();
        // add to numSet to retrieve in constant time
        for (int num : nums) {
            numSet.add(num);
        }
        ListNode curr = head;
        while (curr != null) {
            if (numSet.contains(curr.val)) {
                while (curr != null && numSet.contains(curr.val)) {
                    curr = curr.next;
                }
                count += 1;
            } else {
                while (curr != null && !numSet.contains(curr.val)) {
                    curr = curr.next;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LinkedListConnectedComponents obj = new LinkedListConnectedComponents();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(0);
        ll.addAtTail(1);
        ll.addAtTail(2);
        ll.addAtTail(3);
        ll.addAtTail(4);
        int[] nums = { 0, 3, 1, 4 };
        System.out.println(obj.numComponents(ll.head, nums));
    }
}

package LinkedList;

import java.util.HashSet;

public class DeleteNodesFromLinkedListPresentInArray {

    public ListNode modifiedList(int[] nums, ListNode head) {
        // Lets put the elements in a hashset to retrieve it efficiently
        HashSet<Integer> elems = new HashSet<>();
        for (int num : nums) {
            elems.add(num);
        }
        // Now time to remove the nodes
        ListNode temp = head;
        ListNode prev = null;
        while (temp.next != null) {
            if (elems.contains(temp.val)) {
                // Then we should remove this one
                // check if this is head or not
                if (temp.val == head.val) {
                    ListNode next = head.next;
                    head.next = null;
                    head = next;
                    temp = head;
                } else {
                    // if its not head
                    ListNode next = temp.next;
                    temp.next = null;
                    prev.next = next;
                    temp = next;
                }
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteNodesFromLinkedListPresentInArray obj = new DeleteNodesFromLinkedListPresentInArray();
        int[] nums = { 1, 2, 3 };
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(1);
        ll.addAtTail(2);
        ll.addAtTail(3);
        ll.addAtTail(4);
        ll.addAtTail(5);
        ll.printList();
        ListNode h = obj.modifiedList(nums, ll.head);
        System.out.println(h.val);
    }
}

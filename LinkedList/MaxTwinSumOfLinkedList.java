package LinkedList;

public class MaxTwinSumOfLinkedList {

    public int pairSum(ListNode head) {
        int maxPairSum = Integer.MIN_VALUE;
        // Now lets first reverse the half of the linked list
        // For that lets find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the second half and then using the two pointers technique
        // Now using the two pointer technique
        ListNode left = head;
        ListNode right = reverseHalf(slow);
        while (left != null && right != null) {
            int currSum = left.val + right.val;
            maxPairSum = Math.max(maxPairSum, currSum);
            left = left.next;
            right = right.next;
        }
        return maxPairSum;
    }

    private ListNode reverseHalf(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            ListNode nextOne = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextOne;
        }
        // now we return the tail,thats gonna be the last one
        return prev;
    }

    public static void main(String[] args) {
        MaxTwinSumOfLinkedList obj = new MaxTwinSumOfLinkedList();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(5);
        ll.addAtTail(4);
        ll.addAtTail(2);
        ll.addAtTail(1);
        System.out.println(obj.pairSum(ll.head));
    }
}
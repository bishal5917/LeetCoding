package LinkedList;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // Now lets first reverse the half of the linked list
        // For that lets find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the second half and then using the two pointers technique
        // Now using the two pointer technique
        ListNode left = head;
        ListNode right = reverseHalf(slow);
        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
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
        PalindromeLinkedList obj = new PalindromeLinkedList();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(1);
        ll.addAtTail(0);
        ll.addAtTail(0);
        ll.addAtTail(1);
        System.out.println(obj.isPalindrome(ll.head));
    }
}

package LinkedList;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        // lets use floyd's tortoise and hare algorithm
        // fast and slow pointers
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                // means no cycle (fast reached null)
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // means a cycle
                return true;
            }
        }
    }

    public static void main(String[] args) {
    }
}

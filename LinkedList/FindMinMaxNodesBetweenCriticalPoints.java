package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMinMaxNodesBetweenCriticalPoints {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // first of all lets just find the critical points
        List<Integer> criticals = new ArrayList<>();
        int count = 1;
        ListNode prev = head;
        ListNode curr = head.next;
        int minDist = Integer.MAX_VALUE;
        int prevCount = -1;
        while (curr.next != null) {
            count += 1;
            if (curr.val > prev.val && curr.val > curr.next.val) {
                // System.out.println("FOUND MAXIMA=" + curr.val);
                if (prevCount != -1) {
                    minDist = Math.min(minDist, count - prevCount);
                }
                prevCount = count;
                criticals.add(count);
            }
            if (curr.val < prev.val && curr.val < curr.next.val) {
                // System.out.println("FOUND MINIMA=" + curr.val);
                if (prevCount != -1) {
                    minDist = Math.min(minDist, count - prevCount);
                }
                prevCount = count;
                criticals.add(count);
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println(criticals);
        if (criticals.size() >= 2) {
            int size = criticals.size();
            int maxDist = criticals.get(size - 1) - criticals.get(0);
            return new int[] { minDist, maxDist };
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        FindMinMaxNodesBetweenCriticalPoints obj = new FindMinMaxNodesBetweenCriticalPoints();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(6);
        ll.addAtTail(8);
        ll.addAtTail(4);
        ll.addAtTail(1);
        ll.addAtTail(9);
        ll.addAtTail(6);
        ll.addAtTail(6);
        ll.addAtTail(10);
        ll.addAtTail(6);
        ll.printList();
        int[] ans = obj.nodesBetweenCriticalPoints(ll.head);
        System.out.println(Arrays.toString(ans));
    }
}

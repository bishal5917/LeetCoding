package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterNode {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        Stack<int[]> st = new Stack<>();
        // Now we traverse the linked list and keep finding the values
        ListNode temp = head;
        int idx = 0;
        while (temp != null) {
            while (!st.isEmpty() && st.peek()[1] < temp.val) {
                // then find that idx, pop that and then replace the value
                int index = st.peek()[0];
                ans.set(index, temp.val);
                st.pop();
            }
            ans.add(0);
            st.push(new int[] { idx, temp.val });
            temp = temp.next;
            idx++;
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        NextGreaterNode obj = new NextGreaterNode();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(2);
        ll.addAtTail(7);
        ll.addAtTail(4);
        ll.addAtTail(3);
        ll.addAtTail(5);
        ll.printList();
        int[] ans = obj.nextLargerNodes(ll.head);
        System.out.println(Arrays.toString(ans));
    }
}

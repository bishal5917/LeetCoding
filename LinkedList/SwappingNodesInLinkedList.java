package LinkedList;

public class SwappingNodesInLinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length += 1;
        }
        int kFromLast = length - k;
        // Now find the nodes to swap
        curr = head;
        int count = 1;
        ListNode first = null;
        ListNode second = null;
        while (curr != null) {
            if (count == k) {
                first = curr;
            }
            if (count == kFromLast + 1) {
                second = curr;
            }
            if (first != null && second != null) {
                // if both found just break out of loop
                // optimization
                break;
            }
            curr = curr.next;
            count += 1;
        }
        System.out.println(length);
        swapNodes(first, second);
        return head;
    }

    private void swapNodes(ListNode a, ListNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public static void main(String[] args) {
        SwappingNodesInLinkedList obj = new SwappingNodesInLinkedList();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(100);
        ll.addAtTail(90);
        ll.printList();
        obj.swapNodes(ll.head, 2);
        ll.printList();
    }
}

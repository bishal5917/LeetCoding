package LinkedList;

public class MergeNodesInBetweenZeroes {

    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == 0) {
                ListNode temp = curr;
                curr = curr.next;
                int count = 0;
                // go till we encounter another zero summing up all the values
                while (curr.val != 0) {
                    count = count + curr.val;
                    curr = curr.next;
                }
                // System.out.println(count);
                // and after that create a new node and replace the between nodes
                ListNode newNode = new ListNode(count, null);
                temp.next = newNode;
                newNode.next = curr;
            } else {
                curr = curr.next;
            }
        }
        // Now gotta remove all the zeroes
        if (head == null || head.next == null) {
            return head;
        }
        // removing the zeroes in between
        ListNode t = head;
        while (t != null) {
            if (t.next.val == 0) {
                ListNode another = t.next.next;
                t.next = another;
            }
            t = t.next;
        }
        // now gotta return the next one after head as head gonna be zero always
        return head.next;
    }

    public static void main(String[] args) {
        MergeNodesInBetweenZeroes obj = new MergeNodesInBetweenZeroes();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(0);
        ll.addAtTail(1);
        ll.addAtTail(0);
        ll.addAtTail(3);
        ll.addAtTail(0);
        ll.addAtTail(2);
        ll.addAtTail(2);
        ll.addAtTail(0);
        ll.printList();
        obj.mergeNodes(ll.head);
        ll.printList();
    }
}

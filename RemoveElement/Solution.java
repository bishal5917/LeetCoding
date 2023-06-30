
public class Solution {
    public ListNode removeElements(ListNode head, int val, MyLinkedList list) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                ListNode newCurr = curr.next;
                prev.next = newCurr;
                curr = newCurr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        list.printList();
        return dummy.next;

    }

    public static void main(String[] args) {
        MyLinkedList MyLinkedListA = new MyLinkedList();
        MyLinkedListA.insertAtLast(1);
        MyLinkedListA.insertAtLast(2);
        MyLinkedListA.insertAtLast(6);
        MyLinkedListA.insertAtLast(3);
        MyLinkedListA.insertAtLast(4);
        MyLinkedListA.insertAtLast(5);
        MyLinkedListA.insertAtLast(6);
        Solution m = new Solution();
        m.removeElements(MyLinkedListA.root, 6, MyLinkedListA);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {
    ListNode root;

    MyLinkedList() {
        this.root = null;
    }

    void insertAtLast(int value) {
        ListNode newNode = new ListNode(value, null);

        if (root == null) {
            root = newNode;
        } else {
            ListNode currNode = root;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
    }

    void printList() {
        if (root == null) {
            System.out.println("List is Empty");
            return;
        }
        ListNode currNode = root;
        while (currNode != null) {
            System.out.println(currNode.val);
            currNode = currNode.next;
        }
        System.out.println('\n');
    }
}
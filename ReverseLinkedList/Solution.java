
public class Solution {
    public ListNode reverseLinkedList(ListNode head) {

        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode nextOne = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextOne;
        }

        // prev will always be our new head after getting reversed
        return prev;
    }

    public static void main(String[] args) {
        MyLinkedList MyLinkedListA = new MyLinkedList();
        MyLinkedListA.insertAtLast(1);
        MyLinkedListA.insertAtLast(2);
        MyLinkedListA.insertAtLast(3);
        MyLinkedListA.insertAtLast(4);
        MyLinkedListA.insertAtLast(5);
        Solution m = new Solution();
        ListNode newHead = m.reverseLinkedList(MyLinkedListA.root);
        System.out.println(newHead.val);
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
}

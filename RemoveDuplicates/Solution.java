// package RemoveDuplicates;

public class Solution {
    public ListNode deleteDuplicates(ListNode head, MyLinkedList list) {

        ListNode i = head;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode j = head.next;

        while (j != null) {
            if (i.val == j.val) {
                ListNode temp = j.next;
                i.next = j.next;
                j = temp;
            } else {
                i = j;
                j = j.next;
            }
        }
        list.printList();
        return i;

    }

    public static void main(String[] args) {
        MyLinkedList MyLinkedListA = new MyLinkedList();
        MyLinkedListA.insertAtLast(1);
        MyLinkedListA.insertAtLast(1);
        MyLinkedListA.insertAtLast(2);
        MyLinkedListA.insertAtLast(3);
        MyLinkedListA.insertAtLast(3);
        Solution m = new Solution();
        m.deleteDuplicates(MyLinkedListA.root, MyLinkedListA);
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

    void insertAtFirst(int value) {
        ListNode newNode = new ListNode(value, null);

        if (root == null) {
            root = newNode;
        } else {
            ListNode currNode = root;
            newNode.next = currNode;
            root = newNode;
        }
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
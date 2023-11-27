package PalindromeLinkedList;

public class Solution {

    public boolean isPalindrome(ListNode head) {

        // reversing the linked list
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode nextOne = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextOne;
        }

        // ListNode head = head;
        ListNode headOfReversed = prev;

        while (head != null && headOfReversed != null) {
            if (head.val != headOfReversed.val) {
                return false;
            }
            head = head.next;
            headOfReversed = headOfReversed.next;
        }

        return true;

    }

    public static void main(String[] args) {
        MyLinkedList MyLinkedListA = new MyLinkedList();
        MyLinkedListA.insertAtLast(1);
        MyLinkedListA.insertAtLast(1);
        MyLinkedListA.insertAtLast(2);
        MyLinkedListA.insertAtLast(1);
        Solution m = new Solution();
        Boolean returned = m.isPalindrome(MyLinkedListA.root);
        System.out.println(returned);
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
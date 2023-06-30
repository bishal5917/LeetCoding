
public class Solution {
    public ListNode removeElements(ListNode head, int val, MyLinkedList list) {
        // not working == to debug
        ListNode temp = head;
        if (temp == null) {
            return temp;
        }
        if (temp != null && temp.next == null && temp.val == val) {
            return null;
        }
        if (temp != null && temp.next == null && temp.val != val) {
            return temp;
        }

        while (temp.next != null) {
            if (temp.val == val & temp == head & temp.next.val != val) {
                ListNode currNode = head.next;
                head.next = null;
                head = null;
                head = currNode;
            } else {
                if (temp.next.val == val) {
                    ListNode another = temp.next.next;
                    ListNode toRemove = temp.next;
                    temp.next = another;
                    toRemove.next = null;
                } else {
                    temp = temp.next;
                }
            }
        }
        list.printList();
        return head;

    }

    public static void main(String[] args) {
        MyLinkedList MyLinkedListA = new MyLinkedList();
        // MyLinkedListA.insertAtLast(1);
        // MyLinkedListA.insertAtLast(2);
        // MyLinkedListA.insertAtLast(6);
        // MyLinkedListA.insertAtLast(3);
        // MyLinkedListA.insertAtLast(4);
        // MyLinkedListA.insertAtLast(5);
        // MyLinkedListA.insertAtLast(6);
        MyLinkedListA.insertAtLast(1);
        MyLinkedListA.insertAtLast(2);
        MyLinkedListA.insertAtLast(1);
        // MyLinkedListA.insertAtLast(7);
        Solution m = new Solution();
        m.removeElements(MyLinkedListA.root, 1, MyLinkedListA);
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
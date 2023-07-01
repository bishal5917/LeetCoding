
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode i = list1;
        ListNode j = list2;
        ListNode dummy = new ListNode();
        ListNode merged = dummy;
        while (i != null && j != null) {
            if (i.val <= j.val) {
                merged.next = i;
                merged = merged.next;
                i = i.next;
            } else {
                merged.next = j;
                merged = merged.next;
                j = j.next;
            }
        }
        while (i != null) {
            merged.next = i;
            merged = merged.next;
            i = i.next;
        }
        while (j != null) {
            merged.next = j;
            merged = merged.next;
            j = j.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MyLinkedList MyLinkedListA = new MyLinkedList();
        MyLinkedListA.insertAtLast(1);
        MyLinkedListA.insertAtLast(2);
        MyLinkedListA.insertAtLast(4);
        MyLinkedList MyLinkedListB = new MyLinkedList();
        MyLinkedListB.insertAtLast(0);
        MyLinkedListB.insertAtLast(3);
        MyLinkedListB.insertAtLast(4);

        Solution m = new Solution();
        ListNode headOfMerged = m.mergeTwoLists(MyLinkedListA.root, MyLinkedListB.root);
        System.out.println(headOfMerged.val);
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
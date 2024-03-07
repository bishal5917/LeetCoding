package LinkedList;

public class MyLinkedList {

    ListNode head;
    int length;

    MyLinkedList() {
        this.head = null;
    }

    public int get(int index) {
        int count = 0;
        if (head == null || index >= length) {
            return -1;
        }
        ListNode temp = head;
        while (temp != null) {
            if (count == index) {
                return temp.val;
            }
            temp = temp.next;
            count += 1;
        }
        return -1;
    }

    // ALL INSERTION OPERATIONS
    // Linear Time complexity
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val, null);
        if (head == null) {
            length += 1;
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        length += 1;
    }

    // Constant time complexity
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val, null);
        if (head == null) {
            length += 1;
            head = newNode;
            return;
        }
        ListNode temp = head;
        newNode.next = temp;
        head = newNode;
        length += 1;
    }

    // O(index) time complexity
    public void addAtIndex(int index, int val) {
        if (index <= 0 || head == null) {
            addAtHead(val);
            return;
        }
        if (index == length) {
            addAtTail(val);
            return;
        }
        if (index > length) {
            return;
        }
        int count = 0;
        ListNode newNode = new ListNode(val, null);
        ListNode temp = head;
        while (temp.next != null) {
            if (count == index - 1) {
                break;
            }
            temp = temp.next;
            count += 1;
        }
        ListNode next = temp.next;
        temp.next = newNode;
        newNode.next = next;
        index += 1;
    }

    // ALL INSERTION OPERATIONS
    // Linear Time complexity
    public void removeTail() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            length -= 1;
            return;
        }
        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        length -= 1;
    }

    // Constant time complexity
    public void removeHead() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            length -= 1;
            head = null;
            return;
        }
        ListNode temp = head;
        ListNode next = temp.next;
        head = next;
        temp.next = null;
        length -= 1;
    }

    public void deleteAtIndex(int index) {
        if (index >= length) {
            return;
        }
        if (index == 0) {
            // delete at head
            removeHead();
            return;
        }
        int count = 0;
        if (head == null) {
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (count == index - 1) {
                break;
            }
            temp = temp.next;
            count += 1;
        }
        ListNode prev = temp;
        ListNode curr = temp.next;
        ListNode next = temp.next.next;
        prev.next = next;
        curr.next = null;
        length -= 1;
    }

    public void printList() {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(" --> ");
            } else {
                System.out.println();
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.addAtHead(2);
        ll.printList();
        ll.deleteAtIndex(1);
        ll.printList();
        ll.addAtIndex(1, 2);
        System.out.println(ll.get(1));
        ll.printList();
        ll.deleteAtIndex(1);
        ll.printList();
        System.out.println(ll.get(1));
    }
}

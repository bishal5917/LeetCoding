package LinkedList;

public class DoublyLinkedList {

    DoublyListNode head;
    DoublyListNode tail;
    int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void insertRear(int val) {
        DoublyListNode newNode = new DoublyListNode(val);
        if (tail == null) {
            head = newNode;
            tail = newNode;
            length += 1;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        length += 1;
    }

    public void insertFront(int val) {
        DoublyListNode newNode = new DoublyListNode(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            length += 1;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        length += 1;
    }

    public void deleteRear() {
        if (tail == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            length -= 1;
            return;
        }
        DoublyListNode prev = tail.prev;
        prev.next = null;
        tail.prev = null;
        tail = prev;
        length -= 1;
    }

    public void deleteFront() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            length -= 1;
            return;
        }
        DoublyListNode next = head.next;
        head.next = null;
        next.prev = null;
        head = next;
        length -= 1;
    }

    public void printForward() {
        if (head == null) {
            return;
        }
        DoublyListNode temp = head;
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

    public void printReverse() {
        if (tail == null) {
            return;
        }
        DoublyListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.prev != null) {
                System.out.print(" --> ");
            } else {
                System.out.println();
            }
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.insertRear(1);
        ll.insertRear(2);
        ll.insertRear(3);
        ll.insertFront(0);
        ll.deleteFront();
        ll.printForward();
        ll.printReverse();
    }
}

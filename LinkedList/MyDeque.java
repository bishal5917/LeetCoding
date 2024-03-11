package LinkedList;

//We are doing this by using a LinkedList
public class MyDeque {

    int maxLen = 0;
    int currentLen = 0;
    ListNode front = null;
    ListNode rear = null;

    public MyDeque(int k) {
        this.maxLen = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        ListNode newNode = new ListNode(value, null);
        if (front == null) {
            front = newNode;
            rear = newNode;
            currentLen += 1;
            return true;
        }
        ListNode temp = front;
        newNode.next = temp;
        front = newNode;
        currentLen += 1;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        ListNode newNode = new ListNode(value, null);
        if (rear == null) {
            currentLen += 1;
            rear = newNode;
            front = newNode;
            return true;
        }
        rear.next = newNode;
        rear = newNode;
        currentLen += 1;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (front == null) {
            return false;
        }
        if (front == rear) {
            front = null;
            rear = null;
            currentLen -= 1;
            return true;
        }
        ListNode temp = front;
        ListNode next = temp.next;
        front = next;
        temp.next = null;
        currentLen -= 1;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (rear == null) {
            return false;
        }
        if (front == null) {
            return false;
        }
        if (front.next == null) {
            front = null;
            rear = null;
            currentLen -= 1;
            return true;
        }
        ListNode temp = front;
        ListNode prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        rear = prev;
        currentLen -= 1;
        return true;
    }

    public int getFront() {
        if (front != null) {
            return front.val;
        }
        return -1;
    }

    public int getRear() {
        if (rear != null) {
            return rear.val;
        }
        return -1;
    }

    public boolean isEmpty() {
        return currentLen == 0;
    }

    public boolean isFull() {
        return currentLen == maxLen;
    }

    public static void main(String[] args) {
        MyDeque dq = new MyDeque(84);
        System.out.println(dq.insertFront(60));
        System.out.println(dq.deleteLast());
        System.out.println(dq.isFull());
        System.out.println(dq.insertFront(80));
        System.out.println(dq.isFull());
        System.out.println(dq.deleteFront());
        System.out.println(dq.deleteFront());
        System.out.println(dq.deleteLast());
        System.out.println(dq.isEmpty());
        System.out.println(dq.insertLast(80));
        System.out.println(dq.deleteLast());
    }
}

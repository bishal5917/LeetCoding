package LinkedList;

public class MyCircularQueue {

    DoublyListNode front;
    DoublyListNode rear;
    int capacity;
    int currFilled;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.currFilled = 0;
        this.front = null;
        this.rear = null;
    }

    public boolean enQueue(int value) {
        // means adding at the rear
        if (isFull()) {
            return false;
        }
        DoublyListNode newNode = new DoublyListNode(value);
        if (rear == null) {
            // means both front and rear are null
            front = newNode;
            rear = newNode;
            currFilled += 1;
            return true;
        }
        rear.next = newNode;
        newNode.prev = rear;
        rear = newNode;
        currFilled += 1;
        return true;
    }

    public boolean deQueue() {
        // means removing the front value
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            // means there is only one node
            front = null;
            rear = null;
            currFilled -= 1;
            return true;
        }
        DoublyListNode nextToFront = front.next;
        front.next = null;
        nextToFront.prev = null;
        front = nextToFront;
        currFilled -= 1;
        return true;
    }

    public int Front() {
        if (front == null) {
            return -1;
        }
        return front.val;
    }

    public int Rear() {
        if (rear == null) {
            return -1;
        }
        return rear.val;
    }

    public boolean isEmpty() {
        return currFilled == 0;
    }

    public boolean isFull() {
        return currFilled == capacity;
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
    }
}

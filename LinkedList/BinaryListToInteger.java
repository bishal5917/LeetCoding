package LinkedList;

public class BinaryListToInteger {

    public int getDecimalValue(ListNode head) {
        int sum = 0;
        int count = 0;
        // Lets traverse
        ListNode temp = head;
        while (temp.next != null) {
            count += 1;
            temp = temp.next;
        }
        // Now lets traverse again calculating the sum
        temp = head;
        while (temp != null) {
            sum = sum + temp.val * (int) Math.pow(2, count);
            count -= 1;
            temp = temp.next;
        }
        // System.out.println(count);
        return sum;
    }

    public static void main(String[] args) {
        BinaryListToInteger obj = new BinaryListToInteger();
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(1);
        ll.addAtTail(0);
        ll.addAtTail(1);
        System.out.println(obj.getDecimalValue(ll.head));
    }

}
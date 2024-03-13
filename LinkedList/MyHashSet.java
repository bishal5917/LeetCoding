package LinkedList;

public class MyHashSet {
    ListNode[] set = new ListNode[10000];
    int len = 10000;

    public MyHashSet() {
        // initialize to 10000 as these many calls will be made
        for (int i = 0; i < set.length; i++) {
            set[i] = new ListNode(-1);
        }
    }

    public void add(int key) {
        // Lets do this by chaining
        int mod = key % len;
        // retrieve the head
        ListNode curr = set[mod];
        while (curr.next != null) {
            if (curr.next.val == key) {
                return;
            }
            curr = curr.next;
        }
        curr.next = new ListNode(key);
    }

    public void remove(int key) {
        int mod = key % len;
        ListNode curr = set[mod];
        while (curr != null && curr.next != null) {
            if (curr.next.val == key) {
                // remove
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        int mod = key % len;
        ListNode curr = set[mod];
        while (curr.next != null) {
            if (curr.next.val == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashSet hs = new MyHashSet();
        hs.add(1);
        hs.add(2);
        System.out.println(hs.contains(1));
        System.out.println(hs.contains(3));
        hs.add(2);
        System.out.println(hs.contains(2));
        hs.remove(2);
        System.out.println(hs.contains(2));
    }
}
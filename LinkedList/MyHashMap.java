package LinkedList;

class HashNode {
    int key;
    int val;
    HashNode next;

    HashNode() {
    }

    HashNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    HashNode(int key, int val, HashNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}

public class MyHashMap {

    HashNode[] map = new HashNode[10000];
    int len = 10000;

    public MyHashMap() {
        // initialize to 10000 as these many calls will be made
        for (int i = 0; i < map.length; i++) {
            map[i] = new HashNode(-1, -1);
        }
    }

    public void put(int key, int value) {
        int mod = key % len;
        HashNode curr = map[mod];
        boolean inserted = false;
        while (curr.next != null) {
            if (curr.next.key == key) {
                // if key found,update the value
                curr.next.val = value;
                inserted = true;
            }
            curr = curr.next;
        }
        if (inserted == false) {
            // if we didnot found any value,just add the value at last
            curr.next = new HashNode(key, value);
        }
    }

    public int get(int key) {
        int mod = key % len;
        HashNode curr = map[mod];
        while (curr.next != null) {
            if (curr.next.key == key) {
                // if key found,just return
                return curr.next.val;
            }
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int mod = key % len;
        HashNode curr = map[mod];
        while (curr != null && curr.next != null) {
            if (curr.next.key == key) {
                // if found,then just remove
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap hm = new MyHashMap();
        hm.put(1, 1);
        hm.put(2, 2);
        System.out.println(hm.get(1));
        System.out.println(hm.get(3));
        hm.put(2, 1);
        System.out.println(hm.get(2));
        hm.remove(2);
        System.out.println(hm.get(2));

    }
}

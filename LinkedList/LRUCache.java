package LinkedList;

import java.util.HashMap;

class CacheNode {
    int key;
    int val;
    CacheNode prev;
    CacheNode next;

    CacheNode() {
    }

    CacheNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    CacheNode(int key, int val, CacheNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}

public class LRUCache {
    // LRU = Least Recently Used (TAIL)
    // MRU = Most Recently Used (HEAD)
    HashMap<Integer, CacheNode> cache;
    int capacity;
    CacheNode head;
    CacheNode tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        CacheNode cacheNode = cache.get(key);
        if (cacheNode == null) {
            return -1;
        }
        // Now if the CacheNode isnot null
        // shift the cachenode to the front,depicts the MRU
        shiftToTheFront(cacheNode);
        return cacheNode.val;
    }

    public void put(int key, int value) {
        CacheNode cacheNode = cache.get(key);
        if (cacheNode == null) {
            // means not found,add if the capacity hasnot been reached
            CacheNode newNode = new CacheNode(key, value);
            if (cache.size() == capacity) {
                // if capacity has been reached,remove last node (LRU)
                // EVICTING
                deleteRear();
            }
            // add to the front (MRU)
            insertFront(newNode);
            cache.put(key, newNode);
        } else {
            // already found,just update the value
            // and shift to front to make it MRU
            cacheNode.val = value;
            cache.put(key, cacheNode);
            shiftToTheFront(cacheNode);
        }
    }

    // HELPER FUNCTIONS
    private void shiftToTheFront(CacheNode node) {
        if (node.next == null && node.prev == null) {
            // means its already the first
            return;
        }
        if (node.key == head.key) {
            // means at the front just return
            return;
        }
        CacheNode prev = node.prev;
        CacheNode next = node.next;
        // connect them
        prev.next = next;
        if (next != null) {
            next.prev = prev;
        }
        // add the node to the front
        node.next = head;
        head.prev = node;
        head = node;
        // if the node was tail,make the previous one as tail
        if (node.key == tail.key) {
            tail = prev;
        }
    }

    public void insertFront(CacheNode node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    // EVICTING least recently used one (LRU)
    public void deleteRear() {
        if (tail == null) {
            return;
        }
        cache.remove(tail.key);
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        CacheNode prev = tail.prev;
        prev.next = null;
        tail.prev = null;
        tail = prev;
    }

    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);
        c.put(1, 1);
        c.put(2, 2);
        System.out.println(c.get(1));
        c.put(3, 3);
        System.out.println(c.get(2));
        c.put(4, 4);
        System.out.println(c.get(1));
        System.out.println(c.get(3));
        System.out.println(c.get(4));
    }
}
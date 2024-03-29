import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer> minHeap = null;
    int k = 1;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;
        // Lets add all nums to the queue
        for (int num : nums) {
            minHeap.offer(num);
        }
        // Now we remove the elements until we have k remaining
        // we only need k largest elems
        if (minHeap.size() > k) {
            while (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            while (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.isEmpty() ? -1 : minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 8, 2 };
        KthLargest obj = new KthLargest(3, nums);
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }
}

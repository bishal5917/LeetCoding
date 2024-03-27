import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        // Lets just use a max-heap
        int elem = -1;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            maxHeap.offer(num);
        }
        // Now the time to retrieve
        while (k > 0) {
            elem = maxHeap.poll();
            k -= 1;
        }
        return elem;
    }

    public static void main(String[] args) {
        KthLargestElementInArray obj = new KthLargestElementInArray();
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println(obj.findKthLargest(nums, k));
    }
}

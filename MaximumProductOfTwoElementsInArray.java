import java.util.PriorityQueue;

public class MaximumProductOfTwoElementsInArray {

    public int maxProduct(int[] nums) {
        int max = -1;
        // Add to the maxheap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            maxHeap.offer(num);
        }
        // Pop the first two elements
        int a = maxHeap.poll();
        int b = maxHeap.poll();
        max = Math.max(max, (a - 1) * (b - 1));
        return max;
    }

    public static void main(String[] args) {
        MaximumProductOfTwoElementsInArray obj = new MaximumProductOfTwoElementsInArray();
        int[] nums = { 3, 4, 5, 2 };
        System.out.println(obj.maxProduct(nums));
    }
}

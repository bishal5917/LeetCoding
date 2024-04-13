import java.util.PriorityQueue;

public class MaximumScoreAfterKOperations {

    public long maxKelements(int[] nums, int k) {
        long maxElems = 0;
        // Using the priority queue
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        for (int num : nums) {
            pq.offer((double) num);
        }
        while (!pq.isEmpty() && k > 0) {
            double val = pq.poll();
            maxElems += val;
            val = Math.ceil(val / 3);
            pq.offer(val);
            k -= 1;
        }
        return maxElems;
    }

    public static void main(String[] args) {
        MaximumScoreAfterKOperations obj = new MaximumScoreAfterKOperations();
        int[] nums = { 1, 10, 3, 3, 3 };
        int k = 3;
        System.out.println(obj.maxKelements(nums, k));
    }
}
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MarkElementsOnArrayByPerformingQueries {

    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        long[] sum = new long[queries.length];
        long sumTotal = 0;
        // To keep track of marked
        HashSet<Integer> marked = new HashSet<>();
        // MinHeap for adding all the nums
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        // add on the minheap with the indexes
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[] { i, nums[i] });
            sumTotal += nums[i];
        }
        // Now time to perform the queries
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int idx = query[0];
            int k = query[1];
            if (!marked.contains(idx)) {
                sumTotal -= nums[idx];
                marked.add(idx);
            }
            // Now mark the top k elems
            while (k > 0 && !pq.isEmpty()) {
                int[] top = pq.poll();
                int index = top[0];
                if (!marked.contains(index)) {
                    sumTotal -= nums[index];
                    marked.add(index);
                    k -= 1;
                }
            }
            sum[i] = sumTotal;
        }
        return sum;
    }

    public static void main(String[] args) {
        MarkElementsOnArrayByPerformingQueries obj = new MarkElementsOnArrayByPerformingQueries();
        int[] nums = { 1, 2, 2, 1, 2, 3, 1 };
        int[][] queries = { { 1, 2 }, { 3, 3 }, { 4, 2 } };
        long[] ans = obj.unmarkedSumArray(nums, queries);
        System.out.println(Arrays.toString(ans));
    }
}

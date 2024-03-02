import java.util.PriorityQueue;

//These two problems were solved in a leetcode contest
public class MinOperationsToExceedThreshold {

    public int minOperationsI(int[] nums, int k) {
        int ops = 0;
        for (int num : nums) {
            if (num < k) {
                ops += 1;
            }
        }
        return ops;
    }

    public int minOperationsII(int[] nums, int k) {
        int ops = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer((long) num);
        }
        while (pq.size() >= 2) {
            long x = pq.poll();
            long y = pq.poll();
            if (x >= k) {
                break;
            }
            long z = Math.min(x, y) * 2 + Math.max(x, y);
            pq.offer(z);
            ops += 1;
        }
        return ops;
    }

    public static void main(String[] args) {
        MinOperationsToExceedThreshold obj = new MinOperationsToExceedThreshold();
        int[] nums = { 1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999 };
        int ans = obj.minOperationsII(nums, 1000000000);
        System.out.println(ans);
    }
}

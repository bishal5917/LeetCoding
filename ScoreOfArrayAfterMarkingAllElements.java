import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class ScoreOfArrayAfterMarkingAllElements {

    public long findScore(int[] nums) {
        long score = 0;
        // Lets use a MinHeap and a MarkedSet
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        HashSet<List<Integer>> set = new HashSet<>();
        // Now lets add all the nums in a minheap
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[] { i, nums[i] });
        }
        // Now time to manage the score
        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            int idx = polled[0];
            int val = polled[1];
            if (set.contains(Arrays.asList(idx, val))) {
                continue;
            }
            // else we add the score
            score += val;
            // Now add its left and right to the marked set
            set.add(Arrays.asList(idx, val));
            if (idx - 1 >= 0) {
                set.add(Arrays.asList(idx - 1, nums[idx - 1]));
            }
            if (idx + 1 < nums.length) {
                set.add(Arrays.asList(idx + 1, nums[idx + 1]));
            }
        }
        return score;
    }

    public static void main(String[] args) {
        ScoreOfArrayAfterMarkingAllElements obj = new ScoreOfArrayAfterMarkingAllElements();
        int[] nums = { 2, 1, 3, 4, 5, 2 };
        System.out.println(obj.findScore(nums));
    }
}

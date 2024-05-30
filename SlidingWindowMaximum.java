import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> maxs = new ArrayList<>();
        // Slide the window
        int l = 0;
        int r = 0;
        int len = 1;
        while (r < n) {
            // Gotta maintain a monotonically decreasing queue
            while (!dq.isEmpty() && nums[r] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offer(r);
            len += 1;
            // if the len is k
            if (len > k) {
                maxs.add(nums[dq.peekFirst()]);
                l += 1;
                if (l > dq.getFirst()) {
                    dq.pollFirst();
                }
                len -= 1;
            }
            r += 1;
        }
        int[] ans = new int[maxs.size()];
        for (int i = 0; i < maxs.size(); i++) {
            ans[i] = maxs.get(i);
        }
        return ans;
    }

    // MaxHeap solution got TLE 😅
    // public int[] maxSlidingWindow(int[] nums, int k) {
    // int n = nums.length;
    // List<Integer> maxs = new ArrayList<>();
    // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    // // Slide the window
    // int l = 0;
    // int r = 0;
    // int len = 1;
    // while (r < n) {
    // pq.offer(nums[r]);
    // len += 1;
    // // if the len is k
    // if (len > k) {
    // maxs.add(pq.peek());
    // pq.remove(nums[l]);
    // l += 1;
    // len -= 1;
    // }
    // r += 1;
    // }
    // int[] ans = new int[maxs.size()];
    // for (int i = 0; i < maxs.size(); i++) {
    // ans[i] = maxs.get(i);
    // }
    // return ans;
    // }

    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] ans = obj.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }
}

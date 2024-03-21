import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MaximumSumOfAlmostUniqueSubarray {

    public long maxSum(List<Integer> nums, int m, int k) {
        // USING THE FIXED SLIDING WINDOW APPROACH
        int i = 0;
        int j = 0;
        long maxSum = 0;
        long currSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // Lets maintain a first window
        while (j < k && j < nums.size()) {
            int val = nums.get(j);
            currSum += val;
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
            j += 1;
        }
        // Update the maxSum if conditions are met
        if (map.size() >= m) {
            maxSum = Math.max(maxSum, currSum);
        }
        // NOW LETS SLIDE THE WINDOW
        while (j < nums.size()) {
            // add the new one
            int next = nums.get(j);
            currSum += next;
            if (map.containsKey(next)) {
                map.put(next, map.get(next) + 1);
            } else {
                map.put(next, 1);
            }
            // remove or decrement the prev one
            int prev = nums.get(i);
            currSum -= prev;
            if (map.get(prev) == 1) {
                map.remove(prev);
            } else {
                map.put(prev, map.get(prev) - 1);
            }
            if (map.size() >= m) {
                maxSum = Math.max(maxSum, currSum);
            }
            i += 1;
            j += 1;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSumOfAlmostUniqueSubarray obj = new MaximumSumOfAlmostUniqueSubarray();
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 1, 1, 3));
        System.out.println(obj.maxSum(nums, 2, 2));
    }
}

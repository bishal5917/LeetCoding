import java.util.HashMap;
import java.util.HashSet;

public class MaxSumOfDistinctSubarraysWithLengthK {

    public long maximumSubarraySum(int[] nums, int k) {
        int i = 0;
        int j = 0;
        long maxSum = 0;
        long currSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        // lets make a window if size k first
        while (j < nums.length && j < k) {
            int curr = nums[j];
            currSum += curr;
            // add to the set
            set.add(curr);
            // add to the map
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) + 1);
            } else {
                map.put(curr, 1);
            }
            j += 1;
        }
        if (set.size() == k) {
            maxSum = Math.max(maxSum, currSum);
        }
        // NOW WE GOTTA SLIDE THE WINDOW
        while (j < nums.length) {
            // HANDLING THE PREVIOUS
            int prev = nums[i];
            currSum -= prev;
            if (map.get(prev) == 1) {
                map.remove(prev);
            } else {
                map.put(prev, map.get(prev) - 1);
            }
            if (!map.containsKey(prev)) {
                set.remove(prev);
            }
            // HANDLING THE NEXT
            int next = nums[j];
            currSum += next;
            set.add(next);
            if (map.containsKey(next)) {
                map.put(next, map.get(next) + 1);
            } else {
                map.put(next, 1);
            }
            if (set.size() == k) {
                maxSum = Math.max(maxSum, currSum);
            }
            i += 1;
            j += 1;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSumOfDistinctSubarraysWithLengthK obj = new MaxSumOfDistinctSubarraysWithLengthK();
        int[] nums = { 9, 9, 9, 1, 2, 3 };
        int k = 3;
        System.out.println(obj.maximumSubarraySum(nums, k));
    }
}

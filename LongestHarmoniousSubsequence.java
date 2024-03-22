import java.util.Arrays;

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        int maxLen = 0;
        Arrays.sort(nums);
        // Now lets go by dynamic sliding window style
        // System.out.println(Arrays.toString(nums));
        int i = 0;
        int j = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[j] - nums[i] <= 1) {
                // Keep going on
                if (nums[j] - nums[i] == 1) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                j += 1;
            } else {
                // else slide from the left
                i += 1;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestHarmoniousSubsequence obj = new LongestHarmoniousSubsequence();
        int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };
        System.out.println(obj.findLHS(nums));
    }
}

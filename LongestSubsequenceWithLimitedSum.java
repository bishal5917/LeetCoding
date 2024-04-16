import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {

    public int[] answerQueries(int[] nums, int[] queries) {
        int[] answers = new int[queries.length];
        // USING THE PREFIX SUM AND BINARY SEARCH
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        // Now Binary search the nums array sum for each queries
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int ans = -1;
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] > query) {
                    r -= 1;
                } else {
                    ans = Math.max(ans, mid);
                    l += 1;
                }
            }
            answers[i] = ans + 1;
        }
        System.out.println(Arrays.toString(nums));
        return answers;
    }

    public static void main(String[] args) {
        LongestSubsequenceWithLimitedSum obj = new LongestSubsequenceWithLimitedSum();
        int[] nums = { 4, 5, 2, 1 };
        int[] queries = { 3, 10, 21 };
        int[] ans = obj.answerQueries(nums, queries);
        System.out.println(Arrays.toString(ans));
    }
}

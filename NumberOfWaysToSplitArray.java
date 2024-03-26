import java.util.Arrays;

public class NumberOfWaysToSplitArray {

    public int waysToSplitArray(int[] nums) {
        int ways = 0;
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        // Lets first find the prefix sum
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(prefixSum));
        // Now lets find the valid ways to split
        for (int i = 0; i < prefixSum.length - 1; i++) {
            long left = prefixSum[i];
            long right = prefixSum[nums.length - 1];
            if (left >= right - left) {
                ways += 1;
            }
        }
        return ways;
    }

    public static void main(String[] args) {
        NumberOfWaysToSplitArray obj = new NumberOfWaysToSplitArray();
        int[] nums = { 10, 4, -8, 7 };
        System.out.println(obj.waysToSplitArray(nums));
    }
}

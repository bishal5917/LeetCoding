import java.util.Arrays;

public class SumOfAbsoluteDifferencesInSortedArray {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        // Lets calculate the prefix and suffix sum first
        int n = nums.length;
        int[] preSum = new int[n];
        int[] sufSum = new int[n];
        preSum[0] = nums[0];
        sufSum[n - 1] = nums[n - 1];
        // LETS ITERATE AND CALCULATE THE SUMS
        for (int i = 1; i < n; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
            sufSum[n - 1 - i] = nums[n - 1 - i] + sufSum[n - i];
        }
        System.out.println(Arrays.toString(preSum));
        System.out.println(Arrays.toString(sufSum));
        // NOW LETS FINALLY CALCULATE THE ABSOLUTE DIFFERENCE ARRAY AT LAST
        for (int i = 0; i < n; i++) {
            int currentAbsoluteDiff = ((nums[i] * i) - preSum[i]) + (sufSum[i] - (nums[i] * (n - i - 1)));
            nums[i] = currentAbsoluteDiff;
        }
        return nums;
    }

    public static void main(String[] args) {
        SumOfAbsoluteDifferencesInSortedArray obj = new SumOfAbsoluteDifferencesInSortedArray();
        int[] nums = { 2, 3, 5 };
        int[] ans = obj.getSumAbsoluteDifferences(nums);
        System.out.println(Arrays.toString(ans));
    }
}

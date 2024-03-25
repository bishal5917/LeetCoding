import java.util.Arrays;

public class LeftAndRightSumDifference {

    public int[] leftRightDifference(int[] nums) {
        // First lets find the left and the right sum
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        leftSum[0] = nums[0];
        rightSum[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
            rightSum[n - i - 1] = rightSum[n - i] + nums[n - i - 1];
        }
        // Now find the difference
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        System.out.println(Arrays.toString(leftSum));
        System.out.println(Arrays.toString(rightSum));
        return nums;
    }

    public static void main(String[] args) {
        LeftAndRightSumDifference obj = new LeftAndRightSumDifference();
        int[] nums = { 10, 4, 8, 3 };
        int[] ans = obj.leftRightDifference(nums);
        System.out.println(Arrays.toString(ans));
    }
}

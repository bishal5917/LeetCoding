import java.util.Arrays;

public class RunningSumOf1DArray {

    // JUST THE PREFIX SUM
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        RunningSumOf1DArray obj = new RunningSumOf1DArray();
        int[] nums = { 1, 2, 3, 4 };
        int[] ans = obj.runningSum(nums);
        System.out.println(Arrays.toString(ans));
    }
}

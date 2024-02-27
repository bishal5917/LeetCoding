import java.util.Arrays;

public class MinimizeMaxPairSum {

    public int minPairSum(int[] nums) {
        int currMax = Integer.MIN_VALUE;
        Arrays.sort(nums);
        // Lets use two pointers now
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            currMax = Math.max(currMax, nums[i] + nums[j]);
            i += 1;
            j -= 1;
        }
        return currMax;
    }

    public static void main(String[] args) {
        MinimizeMaxPairSum obj = new MinimizeMaxPairSum();
        int[] nums = { 3, 5, 2, 3 };
        System.out.println(obj.minPairSum(nums));
    }
}

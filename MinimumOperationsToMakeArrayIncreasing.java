import java.util.Arrays;

public class MinimumOperationsToMakeArrayIncreasing {

    public int minOperations(int[] nums) {
        int ops = 0;
        Arrays.sort(nums);
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr <= prev) {
                // find to increment and add it
                int diff = prev + 1 - curr;
                ops += diff;
                curr += diff;
            }
            prev = curr;
        }
        return ops;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeArrayIncreasing obj = new MinimumOperationsToMakeArrayIncreasing();
        int[] nums = { 1, 1, 1 };
        System.out.println(obj.minOperations(nums));
    }
}

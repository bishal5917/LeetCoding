import java.util.HashSet;

public class MaximumErasureValue {

    public int maximumUniqueSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int currSum = 0;
        int maxSum = 0;
        HashSet<Integer> set = new HashSet<>();
        while (i < nums.length && j < nums.length) {
            if (set.contains(nums[j])) {
                currSum -= nums[i];
                set.remove(nums[i]);
                i += 1;
            } else {
                currSum += nums[j];
                maxSum = Math.max(maxSum, currSum);
                set.add(nums[j]);
                j += 1;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumErasureValue obj = new MaximumErasureValue();
        int[] nums = { 5, 2, 1, 2, 5, 2, 1, 2, 5 };
        System.out.println(obj.maximumUniqueSubarray(nums));
    }
}

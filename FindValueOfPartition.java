import java.util.Arrays;

public class FindValueOfPartition {

    public int findValueOfPartition(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        Arrays.sort(nums);
        // We dont have to actually partition
        // We just gotta find the minValue
        // So the minimum is the adjacent difference minimum
        for (int i = 0; i < nums.length - 1; i++) {
            minValue = Math.min(minValue, nums[i + 1] - nums[i]);
        }
        return minValue;
    }

    public static void main(String[] args) {
        FindValueOfPartition obj = new FindValueOfPartition();
        int[] nums = { 1, 3, 2, 4 };
        System.out.println(obj.findValueOfPartition(nums));
    }
}

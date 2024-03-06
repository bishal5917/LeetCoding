import java.util.Arrays;

public class MaximizeGreatnessOfArray {

    public int maximizeGreatness(int[] nums) {
        // lets just use a simple two pointer approach
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < nums.length) {
            if (nums[i] >= nums[j]) {
                j += 1;
            } else {
                count += 1;
                i += 1;
                j += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaximizeGreatnessOfArray obj = new MaximizeGreatnessOfArray();
        int[] nums = { 1, 3, 5, 2, 1, 3, 1 };
        System.out.println(obj.maximizeGreatness(nums));
    }
}

import java.util.Arrays;

public class SortColors {

    public void sortColors(int[] nums) {
        // lets count the total zeroes,1s and 2s
        int zeroes = 0;
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroes += 1;
            } else if (num == 1) {
                ones += 1;
            } else {
                twos += 1;
            }
        }
        // Now add back to the nums
        int i = 0;
        while (i < zeroes) {
            nums[i] = 0;
            i += 1;
        }
        while (i < ones + zeroes) {
            nums[i] = 1;
            i += 1;
        }
        while (i < twos + ones + zeroes) {
            nums[i] = 2;
            i += 1;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        SortColors obj = new SortColors();
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        obj.sortColors(nums);
    }
}

import java.util.Arrays;

public class MaximumGap {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        int currDiff = Integer.MIN_VALUE;
        while (j < nums.length) {
            currDiff = Math.max(Math.abs(nums[i] - nums[j]), currDiff);
            i += 1;
            j += 1;
        }
        System.out.println(currDiff);
        return currDiff;
    }

    public static void main(String[] args) {
        MaximumGap obj = new MaximumGap();
        int[] arr = { 1, 3, 6, 9 };
        obj.maximumGap(arr);
    }

}

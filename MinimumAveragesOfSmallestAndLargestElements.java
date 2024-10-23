import java.util.Arrays;

public class MinimumAveragesOfSmallestAndLargestElements {

    public double minimumAverage(int[] nums) {
        double minAvg = Integer.MAX_VALUE;
        int n = nums.length;
        // we use the two pointers technique
        Arrays.sort(nums);
        int l = 0;
        int r = n - 1;
        int count = n / 2;
        while (count >= 0) {
            double avg = (double) (nums[l] + nums[r]) / 2;
            minAvg = Math.min(minAvg, avg);
            l++;
            r--;
            count--;
        }
        return minAvg;
    }

    public static void main(String[] args) {
        MinimumAveragesOfSmallestAndLargestElements obj = new MinimumAveragesOfSmallestAndLargestElements();
        int[] nums = { 7, 8, 3, 4, 15, 13, 4, 1 };
        System.out.println(obj.minimumAverage(nums));
    }
}

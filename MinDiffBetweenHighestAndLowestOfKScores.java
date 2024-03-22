import java.util.Arrays;

public class MinDiffBetweenHighestAndLowestOfKScores {

    public int minimumDifference(int[] nums, int k) {
        // Lets sort and maintain a sliding window over k
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int i = 0;
        int j = k - 1;
        // NOW LETS JUST SLIDE THE WINDOW
        while (j < nums.length) {
            diff = Math.min(diff, nums[j] - nums[i]);
            i += 1;
            j += 1;
        }
        return diff;
    }

    public static void main(String[] args) {
        MinDiffBetweenHighestAndLowestOfKScores obj = new MinDiffBetweenHighestAndLowestOfKScores();
        int[] nums = { 9, 4, 1, 7 };
        int k = 2;
        System.out.println(obj.minimumDifference(nums, k));
    }
}

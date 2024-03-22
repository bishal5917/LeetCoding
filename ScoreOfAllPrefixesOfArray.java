import java.util.Arrays;

public class ScoreOfAllPrefixesOfArray {

    public long[] findPrefixScore(int[] nums) {
        long[] prefixMax = new long[nums.length];
        // copy numbers to prefixMax
        for (int idx = 0; idx < nums.length; idx++) {
            prefixMax[idx] = nums[idx];
        }
        // Lets find the prefix maximum
        for (int idx = 1; idx < nums.length; idx++) {
            prefixMax[idx] = Math.max(prefixMax[idx], prefixMax[idx - 1]);
        }
        System.out.println(Arrays.toString(prefixMax));
        // Now lets find the conversion array as per the question
        prefixMax[0] = prefixMax[0] + nums[0];
        for (int idx = 1; idx < prefixMax.length; idx++) {
            prefixMax[idx] = prefixMax[idx] + nums[idx];
        }
        // Now lets find the prefix sum of the conversion array
        for (int idx = 1; idx < prefixMax.length; idx++) {
            prefixMax[idx] = prefixMax[idx] + prefixMax[idx - 1];
        }
        return prefixMax;
    }

    public static void main(String[] args) {
        ScoreOfAllPrefixesOfArray obidx = new ScoreOfAllPrefixesOfArray();
        int[] nums = { 17, 17, 12, 14, 13, 8, 8, 9, 10, 18, 10, 18, 10 };
        long[] ans = obidx.findPrefixScore(nums);
        System.out.println(Arrays.toString(ans));
    }
}

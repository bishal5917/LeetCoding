public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int currSum = 0;
        int minLength = Integer.MAX_VALUE;
        while (i < nums.length) {
            if (currSum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                // go front to find currSum<target
                while (currSum >= target) {
                    currSum -= nums[i];
                    i += 1;
                }
                System.out.println(i + "&&" + j);
                minLength = Math.min(minLength, j - i + 1);
            } else {
                if (j < nums.length) {
                    currSum += nums[j];
                    j += 1;
                } else {
                    break;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        System.out.println(obj.minSubArrayLen(7, nums));
    }
}

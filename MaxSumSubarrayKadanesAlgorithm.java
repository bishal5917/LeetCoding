
public class MaxSumSubarrayKadanesAlgorithm {

    public int maxSubArray(int[] nums) {
        // start current sum from 0
        int currSum = 0;
        // set max sum to first of the nums
        // nums.size>=1
        int maxSum = nums[0];
        for (int num : nums) {
            // if current-sum is negative start from 0
            // because if we add more negative num it will only make it worse
            if (currSum < 0) {
                currSum = 0;
            }
            currSum = currSum + num;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    // NOW TO FIND THE ACTUAL SUBARRAY
    public void findMaxSubArray(int[] nums) {
        // start current sum from 0
        int currSum = 0;
        // set max sum to first of the nums
        // nums.size>=1
        int maxSum = nums[0];
        int l = 0;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            // if current-sum is negative start from 0
            // because if we add more negative num it will only make it worse
            if (currSum < 0) {
                // if we found currSum less than 0
                // set it to 0 and start window from that point
                currSum = 0;
                l = i;
                r = i;
            }
            currSum = currSum + nums[i];
            if (currSum > maxSum) {
                // if currSum is greater than maxSum,update the right while keep the left
                maxSum = currSum;
                r = i;
            }
        }
        System.out.println("LeftIdx=" + l + " RightIdx=" + r);
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        MaxSumSubarrayKadanesAlgorithm obj = new MaxSumSubarrayKadanesAlgorithm();
        obj.findMaxSubArray(nums);
        int ans = obj.maxSubArray(nums);
        System.out.println(ans);
    }
}
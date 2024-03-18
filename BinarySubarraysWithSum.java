public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        // Using the concept of probability
        return numSubarraysHelper(nums, goal) - numSubarraysHelper(nums, goal - 1);
    }

    private int numSubarraysHelper(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        int count = 0;
        int i = 0;
        int j = 0;
        int currSum = 0;
        // THE SLIDING WINDOW ALGORITHM
        while (i < nums.length && j < nums.length) {
            currSum += nums[j];
            while (i < nums.length && currSum > goal) {
                currSum -= nums[i];
                i += 1;
            }
            count += j - i + 1;
            j += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        BinarySubarraysWithSum obj = new BinarySubarraysWithSum();
        int[] nums = { 0, 0, 0, 0, 0, };
        int goal = 0;
        System.out.println(obj.numSubarraysWithSum(nums, goal));
    }
}

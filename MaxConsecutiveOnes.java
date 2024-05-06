
import java.lang.Math;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {

        int currMax = 0;
        int maxNum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currMax = currMax + 1;
                maxNum = Math.max(maxNum, currMax);
            }
            if (nums[i] == 0) {
                maxNum = Math.max(maxNum, currMax);
                currMax = 0;
            }
        }

        return maxNum;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 1, 1, 1 };
        MaxConsecutiveOnes co = new MaxConsecutiveOnes();
        System.out.println(co.findMaxConsecutiveOnes(nums));

    }

}

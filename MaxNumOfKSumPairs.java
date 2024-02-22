import java.util.Arrays;

public class MaxNumOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        int pairsRemoved = 0;
        // Just sorting and two pointers
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == k) {
                pairsRemoved += 1;
                i += 1;
                j -= 1;
            } else if (nums[i] + nums[j] < k) {
                i += 1;
            } else {
                j -= 1;
            }

        }
        return pairsRemoved;
    }

    public static void main(String[] args) {
        MaxNumOfKSumPairs obj = new MaxNumOfKSumPairs();
        int[] nums = { 4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4 };
        int k = 2;
        System.out.println(obj.maxOperations(nums, k));
    }

}

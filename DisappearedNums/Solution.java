package DisappearedNums;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedNums = new ArrayList<>();

        int lengthOfNums = nums.length;

        while (lengthOfNums != 0) {
            if (isPresent(nums, lengthOfNums) == false) {
                disappearedNums.add(lengthOfNums);
            }
            lengthOfNums -= 1;
        }

        return disappearedNums;

    }

    static boolean isPresent(int[] nums, int element) {
        for (Integer num : nums) {
            if (num == element) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        // int[] nums = { 2, 2 };
        Solution s = new Solution();
        System.out.println(s.findDisappearedNumbers(nums));
    }

}

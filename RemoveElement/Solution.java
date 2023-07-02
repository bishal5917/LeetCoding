import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int removeElement(int[] nums, int val) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }

        System.out.println(nums);
        return count;

    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 3 };
        int val = 2;
        Solution s = new Solution();
        int returned = s.removeElement(nums, val);
        System.out.println(returned);

    }
}

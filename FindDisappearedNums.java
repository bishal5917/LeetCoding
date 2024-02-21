import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindDisappearedNums {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedNums = new ArrayList<>();
        // Lets create a set to add all nums
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        // Now add the unPresent nums
        for (int i = 1; i <= nums.length; i++) {
            if (!numSet.contains(i)) {
                disappearedNums.add(i);
            }
        }
        return disappearedNums;
    }

    // Disappeared nums OPTIMAL solution (ARRAY MARKING)
    public List<Integer> findDisappearedNumbersOptimal(int[] nums) {
        List<Integer> disappearedNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // take the abs value
            int curr = Math.abs(nums[i]);
            // Now mark that index negative(Means marking as present)
            nums[curr - 1] = 0 - Math.abs(nums[curr - 1]);
        }

        // now iterate over nums and if we find positive add to disappeared
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                disappearedNums.add(i + 1);
            }
        }
        return disappearedNums;
    }

    public static void main(String[] args) {
        FindDisappearedNums obj = new FindDisappearedNums();
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(obj.findDisappearedNumbers(nums));
        System.out.println(obj.findDisappearedNumbersOptimal(nums));
    }

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class NumbersSmallerThanCurrentNumber {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        // Using new arraylist to improve time complexity
        List<Integer> numsSorted = new ArrayList<>();
        for (int num : nums) {
            numsSorted.add(num);
        }
        Collections.sort(numsSorted, Collections.reverseOrder());
        // Now creating a hashset to count how many numbers smaller than are found
        HashMap<Integer, Integer> bucket = new HashMap<>();
        int totalSize = numsSorted.size();
        for (int i = 0; i < numsSorted.size(); i++) {
            bucket.put(numsSorted.get(i), totalSize - i - 1);
        }
        // Now just iterate over the nums and put the value
        for (int i = 0; i < nums.length; i++) {
            nums[i] = bucket.get(nums[i]);
        }
        System.out.println(bucket);
        return nums;
    }

    public static void main(String[] args) {
        NumbersSmallerThanCurrentNumber obj = new NumbersSmallerThanCurrentNumber();
        int[] nums = { 8, 1, 2, 2, 3 };
        int[] ans = obj.smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(ans));
    }

}

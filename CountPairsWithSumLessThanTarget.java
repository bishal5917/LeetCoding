import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountPairsWithSumLessThanTarget {

    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int count = 0;
        int i = 0;
        int j = nums.size() - 1;
        // Lets just iterate with some logic
        while (i < j) {
            if (nums.get(i) + nums.get(j) >= target) {
                j--;
            } else {
                // means all between right and left satisfy condition
                count = count + (j - i);
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPairsWithSumLessThanTarget obj = new CountPairsWithSumLessThanTarget();
        List<Integer> nums = new ArrayList<>(Arrays.asList(-1, 1, 2, 3, 1));
        int target = 2;
        System.out.println(obj.countPairs(nums, target));
    }
}
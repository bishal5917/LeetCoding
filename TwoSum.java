import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// O(n) time and O(n) space
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diff = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            diff.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (diff.containsKey(nums[i]) && i != diff.get(nums[i])) {
                ans.add(i);
                ans.add(diff.get(nums[i]));
                break;
            }
        }
        System.out.println(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 4 };
        int target = 6;
        TwoSum obj = new TwoSum();
        obj.twoSum(nums, target);
    }

}

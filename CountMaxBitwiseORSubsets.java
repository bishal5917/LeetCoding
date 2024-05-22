import java.util.ArrayList;
import java.util.List;

public class CountMaxBitwiseORSubsets {

    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        // Lets find the MaxOr,that is (or of the whole array)
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }
        getSubsetsHelper(nums, new ArrayList<>(), 0, maxOr);
        return count;
    }

    private List<Integer> getSubsetsHelper(int[] nums, List<Integer> curr, int idx, int maxOr) {
        int currOr = getOr(curr);
        if (currOr == maxOr) {
            count += 1;
        }
        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            curr = getSubsetsHelper(nums, curr, i + 1, maxOr);
            curr.remove(curr.size() - 1);
        }
        return curr;
    }

    private int getOr(List<Integer> arr) {
        int or = 0;
        for (int num : arr) {
            or |= num;
        }
        return or;
    }

    public static void main(String[] args) {
        CountMaxBitwiseORSubsets obj = new CountMaxBitwiseORSubsets();
        int[] nums = { 3, 2, 1, 5 };
        System.out.println(obj.countMaxOrSubsets(nums));
    }
}

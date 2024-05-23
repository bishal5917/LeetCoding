import java.util.ArrayList;
import java.util.List;

public class MaxStrengthOfAGroup {

    long maxStrength = Long.MIN_VALUE;

    public long maxStrength(int[] nums) {
        getGroupsHelper(nums, new ArrayList<>(), 0);
        return maxStrength;
    }

    private List<Integer> getGroupsHelper(int[] nums, List<Integer> curr, int idx) {
        maxStrength = Math.max(maxStrength, getProduct(curr));
        // check the value if its the max
        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            curr = getGroupsHelper(nums, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
        return curr;
    }

    private long getProduct(List<Integer> curr) {
        if (curr.size() == 0)
            return Integer.MIN_VALUE;
        long prod = curr.get(0);
        for (int i = 1; i < curr.size(); i++) {
            prod *= curr.get(i);
        }
        return prod;
    }

    public static void main(String[] args) {
        MaxStrengthOfAGroup obj = new MaxStrengthOfAGroup();
        int[] nums = { 3, -1, -5, 2, 5, -9 };
        System.out.println(obj.maxStrength(nums));
    }
}

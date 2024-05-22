import java.util.ArrayList;
import java.util.List;

public class SumOfAllSubsetXORTotals {

    int sum = 0;

    public int subsetXORSum(int[] nums) {
        getSubsetsHelper(nums, new ArrayList<>(), 0);
        return sum;
    }

    private List<Integer> getSubsetsHelper(int[] nums, List<Integer> curr, int idx) {
        sum += getXor(curr);
        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            getSubsetsHelper(nums, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
        return curr;
    }

    private int getXor(List<Integer> subset) {
        int xor = 0;
        for (int item : subset) {
            xor = item ^ xor;
        }
        return xor;
    }

    public static void main(String[] args) {
        SumOfAllSubsetXORTotals obj = new SumOfAllSubsetXORTotals();
        int[] nums = { 5, 1, 6 };
        System.out.println(obj.subsetXORSum(nums));
    }
}

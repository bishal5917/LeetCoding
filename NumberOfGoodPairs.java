import java.util.ArrayList;
import java.util.List;

public class NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        return countGoodOrderPairsRecursiveHelper(nums, new ArrayList<>(), 0, 0);
    }

    private int countGoodOrderPairsRecursiveHelper(int[] nums, List<Integer> pair, int count, int idx) {
        if (pair.size() == 2) {
            // System.out.println(pair);
            int fIdx = pair.get(0);
            int sIdx = pair.get(1);
            if (nums[fIdx] == nums[sIdx]) {
                count += 1;
            }
            return count;
        }
        for (int i = idx; i < nums.length; i++) {
            // for a good node pair i<j
            if ((pair.size() != 0 && pair.get(pair.size() - 1) < i) || pair.size() == 0) {
                pair.add(i);
                count = countGoodOrderPairsRecursiveHelper(nums, pair, count, idx + 1);
                pair.remove(pair.size() - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfGoodPairs obj = new NumberOfGoodPairs();
        int[] nums = { 1, 2, 3, 1, 1, 3 };
        System.out.println(obj.numIdenticalPairs(nums));
    }

}

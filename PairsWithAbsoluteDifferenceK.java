import java.util.ArrayList;
import java.util.List;

public class PairsWithAbsoluteDifferenceK {

    public int countKDifference(int[] nums, int k) {
        return countkDifferencePairsHelper(nums, new ArrayList<>(), k, 0, 0);
    }

    private int countkDifferencePairsHelper(int[] nums, List<Integer> pair, int target, int count, int idx) {
        if (pair.size() == 2) {
            int a = pair.get(0);
            int b = pair.get(1);
            if (Math.abs(nums[a] - nums[b]) == target) {
                count += 1;
            }
            return count;
        }
        // Generate every pair to check
        for (int i = idx; i < nums.length; i++) {
            if (pair.size() == 0 || (pair.size() > 0 && pair.get(0) < i)) {
                pair.add(i);
                count = countkDifferencePairsHelper(nums, pair, target, count, idx + 1);
                pair.remove(pair.size() - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 1 };
        int k = 1;
        PairsWithAbsoluteDifferenceK obj = new PairsWithAbsoluteDifferenceK();
        System.out.println(obj.countKDifference(nums, k));
    }
}
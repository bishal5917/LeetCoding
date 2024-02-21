import java.util.List;
import java.util.ArrayList;

public class NumberOfUnequalTripletsInAnArray {

    public int unequalTriplets(int[] nums) {
        return countUnequalTripletsHelper(nums, new ArrayList<>(), 0, 0);
    }

    private int countUnequalTripletsHelper(int[] nums, List<Integer> triplet, int count, int idx) {
        if (triplet.size() == 3) {
            // check
            if (checkIfUnequal(nums, triplet)) {
                count += 1;
            }
            return count;
        }
        for (int i = idx; i < nums.length; i++) {
            if (triplet.size() == 0 || (triplet.size() != 0 && triplet.get(triplet.size() - 1) < i)) {
                triplet.add(i);
                count = countUnequalTripletsHelper(nums, triplet, count, idx + 1);
                triplet.remove(triplet.size() - 1);
            }
        }
        return count;
    }

    private boolean checkIfUnequal(int[] nums, List<Integer> triplet) {
        int a = triplet.get(0);
        int b = triplet.get(1);
        int c = triplet.get(2);
        if (nums[a] != nums[b] && nums[b] != nums[c] && nums[c] != nums[a]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        NumberOfUnequalTripletsInAnArray obj = new NumberOfUnequalTripletsInAnArray();
        int[] nums = { 4, 4, 2, 4, 3 };
        System.out.println(obj.unequalTriplets(nums));
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LargestPositiveIntegerThatExists {

    public int findMaxK(int[] nums) {
        int maxWithNeg = -1;
        List<Integer> poss = new ArrayList<>();
        HashSet<Integer> negs = new HashSet<>();
        // Now lets add positives and negatives to nums
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > 0) {
                poss.add(nums[i]);
            } else {
                negs.add(nums[i]);
            }
        }
        System.out.println(poss);
        System.out.println(negs);
        // Now lets track the max that has also a negative
        for (int i = 0; i < poss.size(); i++) {
            if (negs.contains(0 - poss.get(i))) {
                maxWithNeg = Math.max(poss.get(i), maxWithNeg);
            }
        }
        return maxWithNeg;
    }

    public static void main(String[] args) {
        LargestPositiveIntegerThatExists obj = new LargestPositiveIntegerThatExists();
        int[] nums = { -1, 10, 6, 7, -7, 1 };
        System.out.println(obj.findMaxK(nums));
    }
}
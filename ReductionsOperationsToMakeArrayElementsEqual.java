import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReductionsOperationsToMakeArrayElementsEqual {

    public int reductionOperations(int[] nums) {
        int ops = 0;
        Arrays.sort(nums);
        // Now we count the occurence of same ones
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
        }
        int idx = 0;
        while (idx < nums.length) {
            int curr = nums[idx];
            int count = 0;
            while (idx < nums.length && nums[idx] == curr) {
                count += 1;
                idx += 1;
            }
            counts.add(count);
        }
        // Now the time to flip
        System.out.println(counts);
        // We iterate from last to first
        // and check how many ops we need
        for (int i = counts.size() - 1; i > 0; i--) {
            ops += counts.get(i);
            counts.set(i - 1, counts.get(i) + counts.get(i - 1));
        }
        return ops;
    }

    public static void main(String[] args) {
        ReductionsOperationsToMakeArrayElementsEqual obj = new ReductionsOperationsToMakeArrayElementsEqual();
        int[] nums = { 1, 1, 2, 2, 3 };
        System.out.println(obj.reductionOperations(nums));
    }
}

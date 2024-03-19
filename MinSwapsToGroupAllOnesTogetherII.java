import java.util.ArrayList;
import java.util.List;

public class MinSwapsToGroupAllOnesTogetherII {

    public int minSwaps(int[] nums) {
        // Lets count the number of ones and create a new array simultaneously
        int ones = 0;
        List<Integer> cnums = new ArrayList<>();
        for (int num : nums) {
            if (num == 1) {
                ones += 1;
            }
            cnums.add(num);
        }
        // Now add the remaining ones from the first to eliminate the circular portion.
        for (int i = 0; i < ones; i++) {
            cnums.add(nums[i]);
        }
        // Now using the sliding window (fixed)
        int l = 0;
        int r = 0;
        int currOnes = 0;
        int minSwaps = Integer.MAX_VALUE;
        while (r < ones) {
            if (cnums.get(r) == 1) {
                currOnes += 1;
            }
            r += 1;
        }
        minSwaps = Math.min(minSwaps, ones - currOnes);
        // NOW KEEP MOVING MAINTAINING THE WINDOW SIZE
        while (l < cnums.size() && r < cnums.size()) {
            if (cnums.get(l) == 1) {
                currOnes -= 1;
            }
            if (cnums.get(r) == 1) {
                currOnes += 1;
            }
            minSwaps = Math.min(minSwaps, ones - currOnes);
            l += 1;
            r += 1;
        }
        return minSwaps;
    }

    public static void main(String[] args) {
        MinSwapsToGroupAllOnesTogetherII obj = new MinSwapsToGroupAllOnesTogetherII();
        int[] nums = { 0, 1, 0, 1, 1, 0, 0 };
        System.out.println(obj.minSwaps(nums));
    }
}

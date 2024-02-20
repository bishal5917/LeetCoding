import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubarraysDistinctElementsSumOfSquares {

    public int sumCounts(List<Integer> nums) {
        return countUniqueSquaresRecursiveHelper(nums, new ArrayList<>(), 0, 0);
    }

    private int countUniqueSquaresRecursiveHelper(List<Integer> nums, List<Integer> current, int count, int idx) {
        if (current.size() == 1) {
            // if there is one,then it is unique
            count = count + 1;
        }
        if (current.size() > 1) {
            int uniqueCount = getUniques(nums, current);
            // add to the count by squaring
            count = count + uniqueCount * uniqueCount;
        }
        for (int i = idx; i < nums.size(); i++) {
            // We are just seeking for subarrays(must be contiguous)
            if (current.size() == 0 || (current.size() > 0 && current.get(current.size() - 1) == i - 1)) {
                current.add(i);
                count = countUniqueSquaresRecursiveHelper(nums, current, count, idx + 1);
                current.remove(current.size() - 1);
            }
        }
        return count;
    }

    private int getUniques(List<Integer> nums, List<Integer> subsets) {
        HashSet<Integer> uniques = new HashSet<>();
        for (int idx : subsets) {
            uniques.add(nums.get(idx));
        }
        return uniques.size();
    }

    public static void main(String[] args) {
        SubarraysDistinctElementsSumOfSquares obj = new SubarraysDistinctElementsSumOfSquares();
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 1));
        System.out.println(obj.sumCounts(nums));
    }
}
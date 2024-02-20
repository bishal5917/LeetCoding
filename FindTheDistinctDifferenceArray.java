import java.util.Arrays;
import java.util.HashSet;

public class FindTheDistinctDifferenceArray {

    public int[] distinctDifferenceArray(int[] nums) {
        // This is just a bruteforce approach,no any other way
        // constraints are less (only 50),so it will work fine
        int[] distinctDifferences = new int[nums.length];
        // Now lets just calculate and keep putting
        for (int i = 0; i < nums.length; i++) {
            int prefixElems = returnDistinct(nums, 0, i + 1);
            int suffixElems = returnDistinct(nums, i + 1, nums.length);
            distinctDifferences[i] = prefixElems - suffixElems;
        }
        return distinctDifferences;
    }

    private int returnDistinct(int[] nums, int lIdx, int rIdx) {
        HashSet<Integer> unique = new HashSet<>();
        for (int i = lIdx; i < rIdx; i++) {
            unique.add(nums[i]);
        }
        return unique.size();
    }

    public static void main(String[] args) {
        FindTheDistinctDifferenceArray obj = new FindTheDistinctDifferenceArray();
        int[] nums = { 1, 2, 3, 4, 5 };
        int[] ans = obj.distinctDifferenceArray(nums);
        System.out.println(Arrays.toString(ans));
    }

}

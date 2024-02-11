import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {

    // means we want unique subsets , in this case , just check with hashset
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return subsetsIIHelper(nums, new ArrayList<>(), new ArrayList<>(), new HashSet<>(), 0);
    }

    private List<List<Integer>> subsetsIIHelper(int[] nums, List<List<Integer>> allSubs, List<Integer> subset,
            HashSet<List<Integer>> wholeSet, int index) {

        if (!wholeSet.contains(subset)) {
            allSubs.add(new ArrayList<>(subset));
            wholeSet.add(new ArrayList<>(subset));
        }

        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            subsetsIIHelper(nums, allSubs, subset, wholeSet, i + 1);
            subset.remove(subset.size() - 1);
        }
        return allSubs;
    }

    public static void main(String[] args) {
        SubsetsII obj = new SubsetsII();
        int[] nums = { 1, 2, 2 };
        List<List<Integer>> ans = obj.subsetsWithDup(nums);
        System.out.println(ans);
    }
    // [[],[1],[1,4],[1,4,4],[1,4,4,4],[1,4,4,4,4],[4],[4,4],[4,4,4],[4,4,4,4]]
}
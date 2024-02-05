import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        // LEAST OPTIMAL WAY (HIGH TIME COMPLEXITY) (TIME LIMIT EXCEEDED)
        List<Integer> vals = new ArrayList<>();
        for (int item : nums) {
            vals.add(item);
        }
        Set<List<Integer>> ans = findSubsetsRecursiveHelper(vals, new HashSet<>());
        // Adding empty and full at last
        ans.add(new ArrayList<>());
        ans.add(vals);
        // return new ArrayList<>(ans);

        // MORE OPTIMAL WAY
        return findAllSubsets(nums, 0, new ArrayList<>(), new ArrayList<>());
    }

    // Worked but not for long inputs
    // time limit exceeded
    // gotta do with the normal nums
    private Set<List<Integer>> findSubsetsRecursiveHelper(List<Integer> nums,
            Set<List<Integer>> allSubsets) {
        if (nums.size() == 1) {
            return allSubsets;
        }
        for (int i = 0; i < nums.size(); i++) {
            int poppped = nums.remove(i);
            allSubsets.add(new ArrayList<>(nums));
            findSubsetsRecursiveHelper(nums, allSubsets);
            nums.add(i, poppped);
        }
        return allSubsets;
    }

    // OPTIMAL SOLUTION
    private List<List<Integer>> findAllSubsets(int[] nums, int idx, List<Integer> current,
            List<List<Integer>> allSubsets) {
        if (idx == nums.length) {
            // Create a new list to avoid sharing the reference
            allSubsets.add(new ArrayList<>(current));
            return allSubsets;
        }
        current.add(nums[idx]);
        findAllSubsets(nums, idx + 1, current, allSubsets);
        // Remove the last one (BACKTRACKING)
        current.remove(current.size() - 1);
        findAllSubsets(nums, idx + 1, current, allSubsets);
        return allSubsets;
    }

    public static void main(String[] args) {
        Subsets obj = new Subsets();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> ans = obj.subsets(nums);
        System.out.println(ans);
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        return uniquePermuteHelper(nums, new ArrayList<>(), new ArrayList<>(), used, new HashSet<>());
    }

    private List<List<Integer>> uniquePermuteHelper(int[] nums, List<List<Integer>> allPerms, List<Integer> curr,
            boolean[] used, HashSet<List<Integer>> permsSet) {
        if (curr.size() == nums.length) {
            if (!permsSet.contains(curr)) {
                allPerms.add(new ArrayList<>(curr));
                permsSet.add(new ArrayList<>(curr));
            }
            return allPerms;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false) {
                used[i] = true;
                curr.add(nums[i]);
                uniquePermuteHelper(nums, allPerms, curr, used, permsSet);
                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
        return allPerms;
    }

    public static void main(String[] args) {
        PermutationsII obj = new PermutationsII();
        int[] nums = { 1, 1, 2 };
        List<List<Integer>> ans = obj.permuteUnique(nums);
        System.out.println(ans);
    }

}

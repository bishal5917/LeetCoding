import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        return findPermute(nums, new ArrayList<>(), new ArrayList<>(), used);
    }

    private List<List<Integer>> findPermute(int[] nums, List<Integer> currPerm, List<List<Integer>> allPerms,
            boolean[] used) {
        if (currPerm.size() == nums.length) {
            allPerms.add(new ArrayList<>(currPerm));
            return allPerms;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false) {
                used[i] = true;
                currPerm.add(nums[i]);
                findPermute(nums, currPerm, allPerms, used);
                used[i] = false;
                currPerm.remove(currPerm.size() - 1);
            }
        }
        return allPerms;
    }

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> ans = obj.permute(nums);
        System.out.println(ans);
    }

}
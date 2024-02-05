import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> vals = new ArrayList<>();
        for (int val : nums) {
            vals.add(val);
        }
        return findPermute(vals, new ArrayList<>());
    }

    private List<List<Integer>> findPermute(List<Integer> nums, List<List<Integer>> allPerms) {
        if (nums.size() == 1) {
            allPerms.add(new ArrayList<>(nums));
            return allPerms;
        }
        for (int i = 0; i < nums.size(); i++) {
            int popped = nums.remove(i);
            List<List<Integer>> vals = findPermute(nums, allPerms);
            nums.add(i, popped);
            for (List<Integer> perm : vals) {
                perm.add(popped);
            }
            System.out.println(allPerms);
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
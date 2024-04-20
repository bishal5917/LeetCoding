import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> idxs = new ArrayList<>();
        return findTargetIndicesHelper(nums, target, 0, nums.length - 1, idxs);
    }

    private List<Integer> findTargetIndicesHelper(int[] nums, int target, int l, int r, List<Integer> idxs) {
        if (l > r) {
            return idxs;
        }
        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            idxs = findTargetIndicesHelper(nums, target, l, mid - 1, idxs);
            idxs.add(mid);
            idxs = findTargetIndicesHelper(nums, target, mid + 1, r, idxs);
        } else if (target < nums[mid]) {
            idxs = findTargetIndicesHelper(nums, target, l, mid - 1, idxs);
        } else {
            idxs = findTargetIndicesHelper(nums, target, mid + 1, r, idxs);
        }
        return idxs;
    }

    public static void main(String[] args) {
        FindTargetIndicesAfterSortingArray obj = new FindTargetIndicesAfterSortingArray();
        int[] nums = { 1, 2, 5, 2, 3 };
        int target = 2;
        System.out.println(obj.targetIndices(nums, target));
    }
}

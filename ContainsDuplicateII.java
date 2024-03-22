import java.util.HashSet;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0;
        int j = 0;
        HashSet<Integer> set = new HashSet<>();
        // First lets maintain a window of size k
        while (j < nums.length && j <= k) {
            if (set.contains(nums[j]))
                return true;
            set.add(nums[j]);
            j += 1;
        }
        // NOW LETS JUST SLIDE THE WINDOW AND CHECK
        while (j < nums.length) {
            set.remove(nums[i]);
            if (set.contains(nums[j]))
                return true;
            set.add(nums[j]);
            i += 1;
            j += 1;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII obj = new ContainsDuplicateII();
        int[] nums = { 1, 2, 3, 1 };
        int k = 3;
        System.out.println(obj.containsNearbyDuplicate(nums, k));
    }
}

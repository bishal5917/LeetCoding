import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindTheDifferenceOfTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1Set = new HashSet<>();
        HashSet<Integer> nums2Set = new HashSet<>();
        for (int num : nums1) {
            nums1Set.add(num);
        }
        for (int num : nums2) {
            nums2Set.add(num);
        }
        // Now iterate and add the elements which are not in each other
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> forNum1 = new ArrayList<>();
        List<Integer> forNum2 = new ArrayList<>();
        // Now just iterate
        for (int num : nums1Set) {
            if (!nums2Set.contains(num)) {
                forNum1.add(num);
            }
        }
        for (int num : nums2Set) {
            if (!nums1Set.contains(num)) {
                forNum2.add(num);
            }
        }
        ans.add(forNum1);
        ans.add(forNum2);
        return ans;
    }

    public static void main(String[] args) {
        FindTheDifferenceOfTwoArrays obj = new FindTheDifferenceOfTwoArrays();
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 2, 4, 6 };
        System.out.println(obj.findDifference(nums1, nums2));
    }

}

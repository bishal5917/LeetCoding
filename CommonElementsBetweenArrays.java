import java.util.Arrays;
import java.util.HashSet;

public class CommonElementsBetweenArrays {
    // TIME COMPLEXITY IS O(n)
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        // Lets create a hashset for nums1 and nums2
        HashSet<Integer> setNums1 = new HashSet<>();
        HashSet<Integer> setNums2 = new HashSet<>();
        for (int num : nums1) {
            setNums1.add(num);
        }
        for (int num : nums2) {
            setNums2.add(num);
        }
        int commonForA = 0;
        int commonForB = 0;
        // Now lets check one by one
        for (int num : nums1) {
            if (setNums2.contains(num)) {
                commonForA += 1;
            }
        }
        for (int num : nums2) {
            if (setNums1.contains(num)) {
                commonForB += 1;
            }
        }
        // And just return
        int[] commons = { commonForA, commonForB };
        return commons;
    }

    public static void main(String[] args) {
        CommonElementsBetweenArrays obj = new CommonElementsBetweenArrays();
        int[] nums1 = { 4, 3, 2, 3, 1 };
        int[] nums2 = { 2, 2, 5, 2, 3, 6 };
        int[] ans = obj.findIntersectionValues(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }

}

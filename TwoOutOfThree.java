import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TwoOutOfThree {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> commons = new ArrayList<>();
        // Create a bucket
        HashMap<Integer, Integer> bucket = new HashMap<>();
        for (int num : nums1) {
            // Just put for nums1,dont worry about quantity
            bucket.put(num, 1);
        }
        // Now lets create set for nums2 and nums3
        HashSet<Integer> nums2Set = new HashSet<>();
        HashSet<Integer> nums3Set = new HashSet<>();
        // Add to set
        for (int num : nums2) {
            nums2Set.add(num);
        }
        for (int num : nums3) {
            nums3Set.add(num);
        }
        // And just iterate over the set checking it its common
        for (int num : nums2Set) {
            if (bucket.get(num) == null) {
                bucket.put(num, 1);
            } else {
                int prev = bucket.get(num);
                // doing this to not add duplicates in our ans
                if (prev == 1) {
                    commons.add(num);
                }
                bucket.put(num, prev + 1);
            }
        }
        for (int num : nums3Set) {
            if (bucket.get(num) == null) {
                bucket.put(num, 1);
            } else {
                int prev = bucket.get(num);
                if (prev == 1) {
                    commons.add(num);
                }
                bucket.put(num, prev + 1);
            }
        }
        System.out.println(bucket);
        return commons;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 1, 3, 2 };
        int[] nums2 = { 2, 3 };
        int[] nums3 = { 3, 4, 4 };
        TwoOutOfThree obj = new TwoOutOfThree();
        System.out.println(obj.twoOutOfThree(nums1, nums2, nums3));
    }

}

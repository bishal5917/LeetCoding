import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class ArrayIntersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> firstNumSet = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for (int item : nums1) {
            firstNumSet.add(item);
        }

        for (int item : nums2) {
            if (firstNumSet.contains(item)) {
                ans.add(item);
                firstNumSet.remove(item);
            }
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        System.out.println(ans);
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        ArrayIntersection obj = new ArrayIntersection();
        obj.intersection(nums1, nums2);
    }
}
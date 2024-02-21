import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeTwoArraysBySummingValues {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer, Integer> bucket = new HashMap<>();
        for (int[] num : nums1) {
            bucket.put(num[0], num[1]);
        }
        for (int[] num : nums2) {
            if (bucket.get(num[0]) == null) {
                bucket.put(num[0], num[1]);
            } else {
                bucket.put(num[0], bucket.get(num[0]) + num[1]);
            }
        }
        int[][] ans = new int[bucket.size()][2];
        List<Integer> ids = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : bucket.entrySet()) {
            ids.add(entry.getKey());
        }
        Collections.sort(ids);
        // Now iterate over all and put in ans
        for (int i = 0; i < ids.size(); i++) {
            ans[i] = new int[] { ids.get(i), bucket.get(ids.get(i)) };
        }
        // System.out.println(bucket);
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums1 = { { 1, 2 }, { 2, 3 }, { 4, 5 } };
        int[][] nums2 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
        MergeTwoArraysBySummingValues obj = new MergeTwoArraysBySummingValues();
        obj.mergeArrays(nums1, nums2);
    }
}

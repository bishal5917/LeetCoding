import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextGreater {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreaterList = new int[nums1.length];
        int findGreaterThan;
        int nextGreater;
        int idxStart;
        for (int x = 0; x < nums1.length; x++) {
            nextGreater = -1;
            findGreaterThan = nums1[x];
            int indexStart = findIdxOf(findGreaterThan, nums2);
            for (int i = indexStart; i < nums2.length; i++) {
                if (nums2[i] > findGreaterThan && nextGreater == -1) {
                    nextGreater = nums2[i];
                }
            }
            nextGreaterList[x] = nextGreater;
        }
        System.out.println(Arrays.toString(nextGreaterList));
        return nextGreaterList;
    }

    public int findIdxOf(int val, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 4 };
        int[] nums2 = { 1, 2, 3, 4 };
        NextGreater obj = new NextGreater();
        obj.nextGreaterElement(nums1, nums2);
    }
}

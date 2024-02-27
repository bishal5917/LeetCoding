import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeArrayElementsBySign {

    public int[] rearrangeArray(int[] nums) {
        List<Integer> negs = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        // Just iterate
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negs.add(nums[i]);
            } else {
                pos.add(nums[i]);
            }
        }
        System.out.println(pos);
        System.out.println(negs);
        // Now use two pointers and add to nums
        int idx = 0;
        int n = 0;
        while (idx < pos.size()) {
            nums[n++] = pos.get(idx);
            nums[n++] = negs.get(idx);
            idx += 1;
        }
        return nums;
    }

    public static void main(String[] args) {
        RearrangeArrayElementsBySign obj = new RearrangeArrayElementsBySign();
        int[] nums = { 3, 1, -2, -5, 2, -4 };
        int[] ans = obj.rearrangeArray(nums);
        System.out.println(Arrays.toString(ans));
    }

}

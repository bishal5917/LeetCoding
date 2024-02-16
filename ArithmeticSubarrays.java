import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArithmeticSubarrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            // lets check if that interval is arithmetic or not
            int leftIdx = l[i];
            int rightIdx = r[i];
            boolean isArithmetic = isArithmetic(nums, leftIdx, rightIdx);
            ans.add(isArithmetic);
        }
        return ans;
    }

    private boolean isArithmetic(int[] nums, int lIdx, int rIdx) {
        List<Integer> subArray = new ArrayList<>();
        for (int i = lIdx; i <= rIdx; i++) {
            subArray.add(nums[i]);
        }
        if (subArray.size() == 1 || subArray.size() == 0) {
            return true;
        }
        // Now sort and check if its arithmetic or not
        Collections.sort(subArray);
        int a = 0;
        int b = 1;
        int diff = subArray.get(b) - subArray.get(a);
        while (b <= subArray.size() - 1) {
            if (subArray.get(b) - subArray.get(a) != diff) {
                return false;
            }
            a += 1;
            b += 1;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 6, 5, 9, 3, 7 };
        int[] l = { 0, 0, 2 };
        int[] r = { 2, 3, 5 };
        ArithmeticSubarrays obj = new ArithmeticSubarrays();
        List<Boolean> ans = obj.checkArithmeticSubarrays(nums, l, r);
        System.out.println(ans);
    }

}

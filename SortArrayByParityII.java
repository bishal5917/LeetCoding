import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        ArrayList<Integer> vals = new ArrayList<>();
        for (int item : nums) {
            vals.add(item);
        }
        int currOddIdx = 1;
        int currEvenIdx = 0;
        for (int item : vals) {
            if (item % 2 == 0) {
                nums[currEvenIdx] = item;
                currEvenIdx += 2;
            } else {
                nums[currOddIdx] = item;
                currOddIdx += 2;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public static void main(String[] args) {

        SortArrayByParityII obj = new SortArrayByParityII();
        int[] nums = { 4, 2, 5, 7 };
        obj.sortArrayByParityII(nums);
    }
}

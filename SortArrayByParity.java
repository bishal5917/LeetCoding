import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        ArrayList<Integer> vals = new ArrayList<>();
        for (int item : nums) {
            if (item % 2 == 0) {
                vals.add(0, item);
            } else {
                vals.add(item);
            }

            for (int i = 0; i < vals.size(); i++) {
                nums[i] = vals.get(i);
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public static void main(String[] args) {

        SortArrayByParity obj = new SortArrayByParity();
        int[] nums = { 1, 2, 3, 4 };
        obj.sortArrayByParity(nums);

    }

}

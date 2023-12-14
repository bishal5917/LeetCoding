import java.util.Arrays;

public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return nums;

    }

    public static void main(String[] args) {
        SquaresOfSortedArray obj = new SquaresOfSortedArray();
        int[] nums = { -4, -1, 0, 3, 10 };
        obj.sortedSquares(nums);
    }
}

import java.util.Arrays;

public class ConcatenationOfAnArray {

    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        ConcatenationOfAnArray obj = new ConcatenationOfAnArray();
        int[] nums = { 1, 2, 1 };
        int[] ans = obj.getConcatenation(nums);
        System.out.println(Arrays.toString(ans));
    }

}

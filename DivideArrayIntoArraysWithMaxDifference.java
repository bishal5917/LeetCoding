import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {

    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] ans = new int[n / 3][3];
        // Lets do this using SORT
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int idx = 0;
        while (idx < n && i < n) {
            // Lets place three of them and check validity
            while (idx < n && j < 3 && i < ans.length) {
                ans[i][j++] = nums[idx++];
            }
            // Check validity
            if (ans[i][2] - ans[i][0] > k) {
                // means invalid,just return empty
                return new int[][] {};
            }
            j = 0;
            i++;
        }
        print(ans);
        return ans;
    }

    private void print(int[][] arr) {
        for (int[] elems : arr) {
            System.out.println(Arrays.toString(elems));
        }
    }

    public static void main(String[] args) {
        DivideArrayIntoArraysWithMaxDifference obj = new DivideArrayIntoArraysWithMaxDifference();
        int[] nums = { 1, 3, 4, 8, 7, 9, 3, 5, 1 };
        int k = 2;
        obj.divideArray(nums, k);
    }
}

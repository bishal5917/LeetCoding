import java.util.Arrays;

public class SumInAMatrix {

    public int matrixSum(int[][] nums) {
        int score = 0;
        // lets sort each rows and select the highest value everytime and add it
        for (int[] arr : nums) {
            Arrays.sort(arr);
        }
        // Now select the maxOne and add to the score
        int col = 0;
        while (col < nums[0].length) {
            int max = 0;
            for (int row = 0; row < nums.length; row++) {
                max = Math.max(max, nums[row][col]);
            }
            // find max for each time and add it
            score += max;
            col += 1;
        }
        return score;
    }

    public static void main(String[] args) {
        SumInAMatrix obj = new SumInAMatrix();
        int[][] nums = { { 7, 2, 1 }, { 6, 4, 2 }, { 6, 5, 3 }, { 3, 2, 1 } };
        System.out.println(obj.matrixSum(nums));
    }
}

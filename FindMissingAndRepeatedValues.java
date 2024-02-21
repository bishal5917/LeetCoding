import java.util.Arrays;
import java.util.HashMap;

public class FindMissingAndRepeatedValues {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int repeatedNum = 0;
        int allGridNumsSum = 0;
        HashMap<Integer, Integer> bucket = new HashMap<>();
        for (int[] nums : grid) {
            for (int num : nums) {
                allGridNumsSum += num;
                if (bucket.get(num) == null) {
                    bucket.put(num, 1);
                } else {
                    // Num is repeated
                    repeatedNum = num;
                }
            }
        }
        // Now lets find the missing number
        // Total sum possible
        int n = grid.length * grid.length;
        int naturalSum = (n * (n + 1)) / 2;
        int sumWithOutRepeatedNum = Math.abs(allGridNumsSum - repeatedNum);
        int missing = Math.abs(naturalSum - sumWithOutRepeatedNum);
        int[] ans = { repeatedNum, missing };
        return ans;
    }

    public static void main(String[] args) {
        FindMissingAndRepeatedValues obj = new FindMissingAndRepeatedValues();
        int[][] grid = { { 9, 1, 7 }, { 8, 9, 2 }, { 3, 4, 6 } };
        System.out.println(Arrays.toString(obj.findMissingAndRepeatedValues(grid)));
    }
}

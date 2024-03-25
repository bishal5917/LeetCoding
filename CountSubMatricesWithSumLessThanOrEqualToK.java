import java.util.Arrays;

public class CountSubMatricesWithSumLessThanOrEqualToK {

    public int countSubmatrices(int[][] grid, int k) {
        int count = 0;
        // lets first find the prefix sum of this 2D Matrix
        calculatePrefixSum(grid);
        // Now count the cases when sum<=k
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] <= k) {
                    count += 1;
                }
            }
        }
        printMatrix(grid);
        return count;
    }

    private void calculatePrefixSum(int[][] grid) {
        // for first row
        for (int col = 1; col < grid[0].length; col++) {
            grid[0][col] = grid[0][col - 1] + grid[0][col];
        }
        // for first col
        for (int row = 1; row < grid.length; row++) {
            grid[row][0] = grid[row - 1][0] + grid[row][0];
        }
        // now for the remaining portions
        for (int r = 1; r < grid.length; r++) {
            for (int c = 1; c < grid[0].length; c++) {
                grid[r][c] = (grid[r - 1][c] + grid[r][c - 1] + grid[r][c]) - grid[r - 1][c - 1];
            }
        }
    }

    private void printMatrix(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        CountSubMatricesWithSumLessThanOrEqualToK obj = new CountSubMatricesWithSumLessThanOrEqualToK();
        int k = 20;
        int[][] grid = { { 7, 2, 9 }, { 1, 5, 0 }, { 2, 6, 6 } };
        System.out.println(obj.countSubmatrices(grid, k));
    }
}

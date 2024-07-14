import java.util.Arrays;
import java.util.HashSet;

public class DifferenceOfNumberOfDistinctsOnDiagonals {

    public int[][] differenceOfDistinctValues(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] ans = new int[rows][cols];
        // Now we proces each diagonals and get the value and put it
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                ans[r][c] = getDiff(grid, r, c);
            }
        }
        printGrid(ans);
        return ans;
    }

    private int getDiff(int[][] grid, int r, int c) {
        HashSet<Integer> tops = new HashSet<>();
        HashSet<Integer> bottoms = new HashSet<>();
        // FOR TOP
        int i = r;
        int j = c;
        i -= 1;
        j -= 1;
        while (i >= 0 && j >= 0) {
            tops.add(grid[i--][j--]);
        }
        // FOR BOTTOM
        i = r;
        j = c;
        i += 1;
        j += 1;
        while (i < grid.length && j < grid[0].length) {
            bottoms.add(grid[i++][j++]);
        }
        return Math.abs(tops.size() - bottoms.size());
    }

    private void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        DifferenceOfNumberOfDistinctsOnDiagonals obj = new DifferenceOfNumberOfDistinctsOnDiagonals();
        int[][] grid = {
                { 1, 2, 3 },
                { 3, 1, 5 },
                { 3, 2, 1 }
        };
        obj.differenceOfDistinctValues(grid);
    }
}

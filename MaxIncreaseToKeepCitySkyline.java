import java.util.Arrays;

public class MaxIncreaseToKeepCitySkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int incs = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[] rowsMax = new int[rows];
        int[] colsMax = new int[cols];
        // gotta go through and find the maximum among rows & cols
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int curr = grid[i][j];
                rowsMax[i] = Math.max(rowsMax[i], curr);
                colsMax[j] = Math.max(colsMax[j], curr);
            }
        }
        System.out.println(Arrays.toString(rowsMax));
        System.out.println(Arrays.toString(colsMax));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int curr = grid[i][j];
                incs += (Math.min(rowsMax[i], colsMax[j]) - curr);
            }
        }
        return incs;
    }

    public static void main(String[] args) {
        MaxIncreaseToKeepCitySkyline obj = new MaxIncreaseToKeepCitySkyline();
        int[][] grid = {
                { 3, 0, 8, 4 },
                { 2, 4, 5, 7 },
                { 9, 2, 6, 3 },
                { 0, 3, 1, 0 }
        };
        System.out.println(obj.maxIncreaseKeepingSkyline(grid));
    }
}

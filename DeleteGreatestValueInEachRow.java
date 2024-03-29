import java.util.Arrays;

public class DeleteGreatestValueInEachRow {

    public int deleteGreatestValue(int[][] grid) {
        int total = 0;
        for (int[] row : grid) {
            Arrays.sort(row);
        }
        int col = 0;
        while (col < grid[0].length) {
            int currMax = -1;
            for (int row = 0; row < grid.length; row++) {
                currMax = Math.max(currMax, grid[row][col]);
            }
            total += currMax;
            col += 1;
        }
        return total;
    }

    public static void main(String[] args) {
        DeleteGreatestValueInEachRow obj = new DeleteGreatestValueInEachRow();
        int[][] grid = { { 1, 2, 4 }, { 3, 3, 1 } };
        System.out.println(obj.deleteGreatestValue(grid));
    }
}

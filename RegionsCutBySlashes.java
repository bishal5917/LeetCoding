import java.util.Arrays;

public class RegionsCutBySlashes {

    public int regionsBySlashes(String[] grid) {
        int count = 0;
        int n = grid.length;
        int[][] g = new int[3 * n][3 * n];
        // Upscaling the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    g[i * 3][j * 3 + 2] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    g[i * 3][j * 3] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        printGrid(g);
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] == 0) {
                    dfsHelper(g, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfsHelper(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 1) {
            return;
        }
        grid[r][c] = 1;
        // else dfs on all the directions
        dfsHelper(grid, r - 1, c);
        dfsHelper(grid, r + 1, c);
        dfsHelper(grid, r, c - 1);
        dfsHelper(grid, r, c + 1);
    }

    private void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        RegionsCutBySlashes obj = new RegionsCutBySlashes();
        String[] grid = { "/\\", "\\/" };
        System.out.println(obj.regionsBySlashes(grid));
    }
}


public class UniquePathsIII {

    int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public int uniquePathsIII(int[][] grid) {
        int emptySquares = 0;
        int sr = 0;
        int sc = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
                if (grid[i][j] != -1) {
                    emptySquares += 1;
                }
            }
        }
        return dfsHelper(grid, sr, sc, 1, emptySquares, 0);
    }

    // Lets just use a DFS with backtracking applied
    private int dfsHelper(int[][] grid, int r, int c, int covered, int total, int count) {
        if (grid[r][c] == 2) {
            // if all squares are covered,increase count
            // System.out.println(total + "*" + covered);
            covered += 1;
            if (covered == total + 1) {
                count += 1;
            }
            covered -= 1;
            return count;
        }
        // Now time to go four dirs
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length) {
                // check if its the goal
                if (grid[r][c] == -1) {
                    // means visited
                    continue;
                }
                covered += 1;
                grid[r][c] = -1;
                count = dfsHelper(grid, nr, nc, covered, total, count);
                // backtrack
                covered -= 1;
                grid[r][c] = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        UniquePathsIII obj = new UniquePathsIII();
        int[][] grid = {
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 2, -1 }
        };
        System.out.println(obj.uniquePathsIII(grid));
    }
}
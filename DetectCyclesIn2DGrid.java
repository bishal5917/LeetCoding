
public class DetectCyclesIn2DGrid {

    int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        // Now go for all the characters,if not visited
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] == false) {
                    boolean cycle = dfsHelper(grid, visited, -1, -1, i, j, grid[i][j], false);
                    if (cycle) {
                        return cycle;
                    }
                }
            }
        }

        return false;
    }

    // Lets do this using DFS
    private boolean dfsHelper(char[][] grid, boolean[][] visited, int pr, int pc, int r, int c, char currChar,
            boolean hasCycle) {
        // marking as visited
        visited[r][c] = true;
        // Now run dfs for all four directions
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            // go only if found the same character
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
                if (!(nr == pr && nc == pc)) {
                    if (grid[nr][nc] == currChar) {
                        if (visited[nr][nc] == true) {
                            // still we found the previously visited one,cycle found
                            hasCycle = true;
                            return hasCycle;
                        } else {
                            hasCycle = dfsHelper(grid, visited, r, c, nr, nc, currChar, hasCycle);
                        }
                        if (hasCycle == true)
                            return true;
                    }
                }
            }
        }
        return hasCycle;
    }

    public static void main(String[] args) {
        DetectCyclesIn2DGrid obj = new DetectCyclesIn2DGrid();
        char[][] grid = { { 'c', 'c', 'c', 'a' },
                { 'c', 'd', 'c', 'c' },
                { 'c', 'c', 'e', 'c' },
                { 'f', 'c', 'c', 'c' } };
        System.out.println(obj.containsCycle(grid));

    }
}

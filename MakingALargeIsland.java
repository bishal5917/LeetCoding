import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MakingALargeIsland {

    int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public int largestIsland(int[][] grid) {
        int largest = 0;
        int id = 2;
        int rows = grid.length;
        int cols = grid[0].length;
        // Lets flood fill and mark the islands
        // start marking form 2
        // map to track area of id
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = dfsHelper(grid, i, j, id, 0);
                    largest = Math.max(largest, area);
                    map.put(id, area);
                    id++;
                }
            }
        }
        System.out.println(map);
        // Now lets go through all zeroes
        // and try to connect
        return connectIslands(grid, map, largest);
    }

    private int connectIslands(int[][] grid, HashMap<Integer, Integer> map, int largest) {
        // Now go for every zeroes
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> ids = new HashSet<>();
                    int totalCurrArea = 1;
                    for (int[] dir : dirs) {
                        int nr = dir[0] + i;
                        int nc = dir[1] + j;
                        if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) {
                            continue;
                        }
                        if (grid[nr][nc] != 0) {
                            ids.add(grid[nr][nc]);
                        }
                    }
                    for (int id : ids) {
                        totalCurrArea += map.get(id);
                    }
                    largest = Math.max(largest, totalCurrArea);
                }
            }
        }
        return largest;
    }

    // Lets flood fill and get islands
    private int dfsHelper(int[][] grid, int r, int c, int id, int area) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return area;
        }
        if (grid[r][c] == id || grid[r][c] == 0) {
            return area;
        }
        grid[r][c] = id;
        area += 1;
        // Lets go all 4 dirs
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            area = dfsHelper(grid, nr, nc, id, area);
        }
        return area;
    }

    private void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        MakingALargeIsland obj = new MakingALargeIsland();
        int[][] grid = {
                { 1, 0 }, { 0, 1 }
        };
        System.out.println(obj.largestIsland(grid));
        obj.printGrid(grid);
    }
}

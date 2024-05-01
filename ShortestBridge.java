import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    public int shortestBridge(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // Queue for putting all coordinates of first island
        // gotta do bfs also
        Queue<int[]> queue = new LinkedList<>();
        // This normally means finding a shortest path between two islands
        // Finding the first island first
        boolean foundFirst = false;
        for (int i = 0; i < rows; i++) {
            if (foundFirst == true) {
                break;
            }
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    foundFirst = true;
                    dfsHelper(grid, queue, i, j);
                    break;
                }
            }
        }
        printGrid(grid);
        return bfsShortestPathHelper(grid, queue);
    }

    // First lets perform DFS to get the first island
    private void dfsHelper(int[][] grid, Queue<int[]> queue, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 2 || grid[r][c] == 0) {
            return;
        }
        grid[r][c] = 2;
        queue.offer(new int[] { r, c });
        // Now lets go in all 4 dirs
        dfsHelper(grid, queue, r + 1, c);
        dfsHelper(grid, queue, r - 1, c);
        dfsHelper(grid, queue, r, c - 1);
        dfsHelper(grid, queue, r, c + 1);
    }

    private int bfsShortestPathHelper(int[][] grid, Queue<int[]> queue) {
        int count = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                // Now go for all its neighbors and mark them also
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
                        if (grid[nr][nc] == 2) {
                            // continue because this is visited
                            continue;
                        }
                        if (grid[nr][nc] == 1) {
                            // means second island found
                            return count;
                        }
                        // mark neighbors visited and add to queue
                        grid[nr][nc] = 2;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
            count += 1;
        }
        return count;
    }

    private void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        ShortestBridge obj = new ShortestBridge();
        int[][] grid = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
        System.out.println(obj.shortestBridge(grid));
    }
}

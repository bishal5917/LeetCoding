import java.util.LinkedList;
import java.util.Queue;

public class FarFromLandAsPossible {

    public int maxDistance(int[][] grid) {
        int water = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        // Add all the ones to the queue
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    queue.offer(new int[] { r, c });
                } else {
                    water += 1;
                }
            }
        }
        if (water == 0) {
            return -1;
        }
        // Multisource BFS
        // run bfs from every ones
        return bfsHelper(grid, queue);
    }

    private int bfsHelper(int[][] grid, Queue<int[]> queue) {
        int distance = 0;
        // Using the BFS Approach
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                // add all its neighbors,and mark them rotten
                for (int[] dir : dirs) {
                    // go for all four directions
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
                        if (grid[nr][nc] == 1) {
                            // already visited,continue
                            continue;
                        }
                        // mark them visited
                        grid[nr][nc] = 1;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
            distance += 1;
        }
        return distance - 1;
    }

    public static void main(String[] args) {
        FarFromLandAsPossible obj = new FarFromLandAsPossible();
        int[][] grid = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
        System.out.println(obj.maxDistance(grid));
    }
}

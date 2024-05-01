import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    int fresh = 0;

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int empties = 0;
        // Add all rotten to the queue
        Queue<int[]> queue = new LinkedList<>();
        // first lets count the total number of fresh oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    fresh += 1;
                } else if (grid[r][c] == 2) {
                    queue.offer(new int[] { r, c });
                } else {
                    empties += 1;
                }
            }
        }
        if (empties == rows * cols) {
            // means all empties,just return 0
            return 0;
        }
        int time = bfsHelper(grid, queue);
        return fresh == 0 ? time - 1 : -1;
    }

    private int bfsHelper(int[][] grid, Queue<int[]> queue) {
        int time = 0;
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
                        if (grid[nr][nc] == 2 || grid[nr][nc] == 0) {
                            // already visited,continue
                            continue;
                        }
                        // mark them rotten
                        grid[nr][nc] = 2;
                        fresh -= 1;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
            time += 1;
        }
        return time;
    }

    public static void main(String[] args) {
        RottingOranges obj = new RottingOranges();
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(obj.orangesRotting(grid));
    }
}

import java.util.PriorityQueue;

public class MinimumObstacleRemovalToReachCorner {

    public int minimumObstacles(int[][] grid) {
        return dijkstraHelper(grid);
    }

    private int dijkstraHelper(int[][] grid) {
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        int rows = grid.length;
        int cols = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[2] - b[2]);
        // we start from 0,0
        pq.offer(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            if (r == rows - 1 && c == cols - 1) {
                return curr[2];
            }
            // check visited
            if (grid[r][c] == -1) {
                continue;
            }
            grid[r][c] = -1;
            // we go for its neighbors
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) {
                    continue;
                }
                // else we add to the pq
                pq.offer(new int[] { nr, nc, grid[nr][nc] + curr[2] });
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumObstacleRemovalToReachCorner obj = new MinimumObstacleRemovalToReachCorner();
        int[][] grid = {
                { 0, 1, 1 }, { 1, 1, 0 }, { 1, 1, 0 }
        };
        System.out.println(obj.minimumObstacles(grid));
    }
}

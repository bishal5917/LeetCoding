import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathWithObstaclesElimination {

    public int shortestPath(int[][] grid, int k) {
        return bfsHelper(grid, k);
    }

    private int bfsHelper(int[][] grid, int k) {
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        int len = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[rows][cols][k + 1];
        q.offer(new int[] { 0, 0, 0 });
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                int currK = curr[2];
                // check if reached
                if (r == rows - 1 && c == cols - 1) {
                    return len;
                }
                // Now time to add up its neighbors
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    int nk = currK;
                    if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) {
                        continue;
                    }
                    // Now add neighbors
                    nk = nk + grid[nr][nc];
                    if (nk <= k && !visited[nr][nc][nk]) {
                        // add to queue
                        q.offer(new int[] { nr, nc, nk });
                        visited[nr][nc][nk] = true;
                    }
                }
            }
            len += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestPathWithObstaclesElimination obj = new ShortestPathWithObstaclesElimination();
        int[][] grid = {
                { 0, 0, 0 },
                { 1, 1, 0 },
                { 0, 0, 0 },
                { 0, 1, 1 },
                { 0, 0, 0 }
        };
        int k = 1;
        System.out.println(obj.shortestPath(grid, k));
    }
}

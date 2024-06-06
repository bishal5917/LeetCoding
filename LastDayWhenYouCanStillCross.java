import java.util.LinkedList;
import java.util.Queue;

public class LastDayWhenYouCanStillCross {

    public int latestDayToCross(int row, int col, int[][] cells) {
        int n = cells.length;
        // Now we binary search the answer
        int lastDay = 0;
        int l = 1, r = n - 1, m = r;
        while (l <= r) {
            m = (l + (r - l) / 2);
            // check on mid if we can cross
            if (canCross(cells, row, col, m)) {
                lastDay = m;
                // gotta check from mid to right
                l = m + 1;
            } else {
                // unnecessary to check after mid
                r = m - 1;
            }
        }
        return lastDay + 1;
    }

    private boolean canCross(int[][] cells, int r, int c, int day) {
        // four directions to go
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        // lets create a grid for dfs
        int[][] grid = new int[r][c];
        // mark the waters till that day
        for (int d = 0; d <= day; d++) {
            int a = cells[d][0];
            int b = cells[d][1];
            // since given is 1 indexed
            grid[a - 1][b - 1] = 1;
        }
        // Now time for bfs
        Queue<int[]> queue = new LinkedList<>();
        // Add all the lands in the first row
        for (int i = 0; i < c; i++) {
            if (grid[0][i] == 0) {
                queue.offer(new int[] { 0, i });
            }
        }
        // This gonna be a multisourced bfs
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            // if we ever reached last row return true
            int a = curr[0];
            int b = curr[1];
            if (a == r - 1) {
                return true;
            }
            for (int[] dir : dirs) {
                int nr = a + dir[0];
                int nc = b + dir[1];
                if (nr < 0 || nc < 0 || nr >= r || nc >= c || grid[nr][nc] == 1) {
                    continue;
                }
                // else add to the queue and mark visited
                grid[nr][nc] = 1;
                queue.offer(new int[] { nr, nc });
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LastDayWhenYouCanStillCross obj = new LastDayWhenYouCanStillCross();
        int[][] cells = {
                { 1, 2 }, { 2, 1 }, { 3, 3 }, { 2, 2 }, { 1, 1 }, { 1, 3 }, { 2, 3 }, { 3, 2 }, { 3, 1 }
        };
        int rows = 3;
        int cols = 3;
        System.out.println(obj.latestDayToCross(rows, cols, cells));
    }
}

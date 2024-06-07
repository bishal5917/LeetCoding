import java.util.PriorityQueue;

public class SwimInRisingWater {

    public int swimInWater(int[][] grid) {
        return dijkstraHelper(grid);
    }

    private int dijkstraHelper(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[2] - b[2]);
        // we start from top left corner
        pq.offer(new int[] { 0, 0, grid[0][0] });
        grid[0][0] = -1;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int time = curr[2];
            // means reaached the bottom right,return
            if (r == rows - 1 && c == cols - 1) {
                return time;
            }
            // else we go all four dirs
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                // visited or out of bounds continue
                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || grid[nr][nc] == -1) {
                    continue;
                }
                // add to the priority queue
                pq.offer(new int[] { nr, nc, Math.max(time, grid[nr][nc]) });
                // else mark as visited
                grid[nr][nc] = -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SwimInRisingWater obj = new SwimInRisingWater();
        int[][] grid = {
                { 0, 1, 2, 3, 4 },
                { 24, 23, 22, 21, 5 },
                { 12, 13, 14, 15, 16 },
                { 11, 17, 18, 19, 20 },
                { 10, 9, 8, 7, 6 }
        };
        System.out.println(obj.swimInWater(grid));
    }
}

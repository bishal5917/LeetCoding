import java.util.PriorityQueue;

public class MinimumCostToMakeOneValidPathInGrid {

    public int minCost(int[][] grid) {
        return dijkstraHelper(grid);
    }

    private int dijkstraHelper(int[][] grid) {
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
            int cost = curr[2];
            if (r == rows - 1 && c == cols - 1) {
                return cost;
            }
            // check visited
            if (grid[r][c] == -1) {
                continue;
            }
            // we go for its neighbors
            // get current cell direction
            int currDir = grid[r][c];
            // mark as visited
            grid[r][c] = -1;
            if (c + 1 < cols) {
                pq.offer(new int[] { r, c + 1, (currDir == 1 ? 0 : 1) + cost });
            }
            if (c - 1 >= 0) {
                pq.offer(new int[] { r, c - 1, (currDir == 2 ? 0 : 1) + cost });
            }
            if (r + 1 < rows) {
                pq.offer(new int[] { r + 1, c, (currDir == 3 ? 0 : 1) + cost });
            }
            if (r - 1 >= 0) {
                pq.offer(new int[] { r - 1, c, (currDir == 4 ? 0 : 1) + cost });
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumCostToMakeOneValidPathInGrid obj = new MinimumCostToMakeOneValidPathInGrid();
        int[][] grid = {
                { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 1, 1, 1, 1 }, { 2, 2, 2, 2 }
        };
        System.out.println(obj.minCost(grid));
    }
}

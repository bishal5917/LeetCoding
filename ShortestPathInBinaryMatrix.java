import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            // means blocked,no path,return
            return -1;
        }
        return bfsHelper(grid);
    }

    private int bfsHelper(int[][] grid) {
        int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        int distance = 1;
        HashSet<List<Integer>> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0 });
        visited.add(Arrays.asList(0, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                if (r == grid.length - 1 && c == grid[0].length - 1) {
                    // means found goal
                    return distance;
                }
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
                        if (visited.contains(Arrays.asList(nr, nc)) || grid[nr][nc] == 1) {
                            continue;
                        }
                        // else mark visited and add to queue
                        visited.add(Arrays.asList(nr, nc));
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
            distance += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        ShortestPathInBinaryMatrix obj = new ShortestPathInBinaryMatrix();
        System.out.println(obj.shortestPathBinaryMatrix(grid));
    }
}

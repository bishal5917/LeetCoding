import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Matrix01 {

    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        // Add all zeroes to the queue
        Queue<int[]> queue = new LinkedList<>();
        HashSet<List<Integer>> visited = new HashSet<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0) {
                    queue.offer(new int[] { r, c });
                    visited.add(Arrays.asList(r, c));
                }
            }
        }
        bfsHelper(mat, queue, visited);
        return mat;
    }

    private int bfsHelper(int[][] grid, Queue<int[]> queue, HashSet<List<Integer>> visited) {
        int distance = 1;
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
                        if (visited.contains(Arrays.asList(nr, nc))) {
                            continue;
                        }
                        // update their distance
                        grid[nr][nc] = distance;
                        queue.offer(new int[] { nr, nc });
                        visited.add(Arrays.asList(nr, nc));
                    }
                }
            }
            distance += 1;
        }
        return distance;
    }

    public static void main(String[] args) {
        Matrix01 obj = new Matrix01();
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        int[][] ans = obj.updateMatrix(mat);
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }
}

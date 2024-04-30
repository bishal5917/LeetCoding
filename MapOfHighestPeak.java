import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {

    public int[][] highestPeak(int[][] isWater) {
        Queue<int[]> queue = new LinkedList<>();
        // We gotta perform BFS from each of the water cells,means from 1
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    isWater[i][j] = 0;
                    queue.offer(new int[] { i, j });
                } else {
                    isWater[i][j] = -1;
                }
            }
        }
        bfsHelper(isWater, queue);
        return isWater;
    }

    private void bfsHelper(int[][] isWater, Queue<int[]> queue) {
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            // Now go all directions
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                // Now if they are water,just continue
                if (nr >= 0 && nr < isWater.length && nc >= 0 && nc < isWater[0].length && isWater[nr][nc] < 0) {
                    isWater[nr][nc] = isWater[r][c] + 1;
                    queue.offer(new int[] { nr, nc });
                }
            }
        }
    }

    public static void main(String[] args) {
        MapOfHighestPeak obj = new MapOfHighestPeak();
        int[][] isWater = { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 0, 0 } };
        int[][] ans = obj.highestPeak(isWater);
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }
}

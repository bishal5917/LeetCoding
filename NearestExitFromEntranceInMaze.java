import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {

    public int nearestExit(char[][] maze, int[] entrance) {
        // Using BFS
        return bfsHelper(maze, entrance);
    }

    private int bfsHelper(char[][] grid, int[] start) {
        int steps = 1;
        HashSet<List<Integer>> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(Arrays.asList(start[0], start[1]));
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
                        if (visited.contains(Arrays.asList(nr, nc)) || grid[nr][nc] == '+') {
                            continue;
                        }
                        if (nr == 0 || nr == grid.length - 1 || nc == 0 || nc == grid[0].length - 1) {
                            return steps;
                        }
                        // update their distance
                        queue.offer(new int[] { nr, nc });
                        visited.add(Arrays.asList(nr, nc));
                    }
                }
            }
            steps += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        NearestExitFromEntranceInMaze obj = new NearestExitFromEntranceInMaze();
        char[][] maze = { { '+', '+', '.', '+' },
                { '.', '.', '.', '+' },
                { '+', '+', '+', '.' } };
        int[] entrance = { 1, 2 };
        System.out.println(obj.nearestExit(maze, entrance));
    }
}

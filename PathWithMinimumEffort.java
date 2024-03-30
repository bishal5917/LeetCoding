import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        // Using the dijkstra's algorithm
        // Start priority queue
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        HashSet<List<Integer>> visited = new HashSet<>();
        // idx0=distance,idx1=row,idx2=col
        minHeap.offer(new int[] { 0, 0, 0 });
        // Now lets pop from the heap till we reach the goal
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currRow = curr[1];
            int currCol = curr[2];
            if (visited.contains(Arrays.asList(currRow, currCol))) {
                continue;
            }
            visited.add(Arrays.asList(currRow, currCol));
            if (currRow == rows - 1 && currCol == cols - 1) {
                return curr[0];
            }
            // Now push all the directions to the heap
            if (currRow - 1 >= 0) {
                int effort = Math.abs(heights[currRow][currCol] - heights[currRow - 1][currCol]);
                effort = Math.max(effort, curr[0]);
                minHeap.offer(new int[] { effort, currRow - 1, currCol });
            }
            if (currCol - 1 >= 0) {
                int effort = Math.abs(heights[currRow][currCol] - heights[currRow][currCol - 1]);
                effort = Math.max(effort, curr[0]);
                minHeap.offer(new int[] { effort, currRow, currCol - 1 });
            }
            if (currRow + 1 < rows) {
                int effort = Math.abs(heights[currRow][currCol] - heights[currRow + 1][currCol]);
                effort = Math.max(effort, curr[0]);
                minHeap.offer(new int[] { effort, currRow + 1, currCol });
            }
            if (currCol + 1 < cols) {
                int effort = Math.abs(heights[currRow][currCol] - heights[currRow][currCol + 1]);
                effort = Math.max(effort, curr[0]);
                minHeap.offer(new int[] { effort, currRow, currCol + 1 });
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        PathWithMinimumEffort obj = new PathWithMinimumEffort();
        int[][] heights = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
        System.out.println(obj.minimumEffortPath(heights));
    }
}
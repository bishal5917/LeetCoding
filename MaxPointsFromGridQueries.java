import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Elem {
    int idx;
    int val;

    public Elem(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}

public class MaxPointsFromGridQueries {

    // Four directions that we gotta go
    int[][] nebs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public int[] maxPoints(int[][] grid, int[] queries) {
        int[] points = new int[queries.length];
        int rows = grid.length;
        int cols = grid[0].length;
        // We gotta create a new array with remembering index
        Elem[] arr = new Elem[queries.length];
        // sorting the queries,so we can reuse the result later
        // copy the original array
        for (int i = 0; i < queries.length; i++) {
            Elem elem = new Elem(i, queries[i]);
            arr[i] = elem;
        }
        // Now sort based on the val,prev index will remain same
        Arrays.sort(arr, Comparator.comparingInt(elem -> elem.val));
        // declare max-heap and visited array
        // we will have [i,j,val]
        long point = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[rows][cols];
        // We perform bfs in order for each query turn by turn
        pq.offer(new int[] { 0, 0, grid[0][0] });
        for (Elem elem : arr) {
            point += bfsHelper(pq, grid, visited, elem.val);
            // put the value in ans
            points[elem.idx] = (int) point;
            printGrid(visited);
            // System.out.println(point);
        }
        return points;
    }

    private long bfsHelper(PriorityQueue<int[]> pq, int[][] grid, boolean[][] visited, int query) {
        long points = 0;
        while (!pq.isEmpty()) {
            // peek and check
            int[] front = pq.peek();
            int r = front[0];
            int c = front[1];
            if (grid[r][c] >= query) {
                // means cant do nothing just break;
                break;
            }
            // else we pop that and go for its four neighbors
            pq.poll();
            if (visited[r][c]) {
                continue;
            }
            // increase the point
            points += 1;
            visited[r][c] = true;
            // Its neighbors
            for (int[] neb : nebs) {
                int nr = neb[0] + r;
                int nc = neb[1] + c;
                // check if out of bounds
                if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                // else we push in the heap
                pq.offer(new int[] { nr, nc, grid[nr][nc] });
            }
        }
        return points;
    }

    private void printGrid(boolean[][] grid) {
        for (boolean[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        MaxPointsFromGridQueries obj = new MaxPointsFromGridQueries();
        int[][] grid = {
                { 1, 2, 3 },
                { 2, 5, 7 },
                { 3, 5, 1 }
        };
        int[] queries = { 5, 6, 2 };
        int[] ans = obj.maxPoints(grid, queries);
        System.out.println(Arrays.toString(ans));
    }
}

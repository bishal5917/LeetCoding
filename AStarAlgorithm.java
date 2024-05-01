
import java.util.PriorityQueue;

class ANode {
    int val;
    int r;
    int c;
    int gScore;
    int fScore;
    ANode prev;

    public ANode(int val, int r, int c, int gScore, int fScore, ANode prev) {
        this.val = val;
        this.r = r;
        this.c = c;
        this.gScore = gScore;
        this.fScore = fScore;
        this.prev = prev;
    }
}

public class AStarAlgorithm {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // Process the grid to new matrix
        ANode[][] matrix = new ANode[rows][cols];
        // Convert the matrix to new one as ANode
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ANode node = new ANode(grid[i][j], i, j, Integer.MAX_VALUE, Integer.MAX_VALUE, null);
                matrix[i][j] = node;
            }
        }
        ANode start = matrix[0][0];
        ANode end = matrix[rows - 1][cols - 1];
        // if the start is 1 just return -1,No Path
        if (start.val == 1) {
            return -1;
        }
        // Set the g_score and f_score for the start node
        start.gScore = 1;
        start.fScore = start.gScore + getHeuristic(start, end);
        int dis = aStarAlgorithm(matrix, start, end);
        printPath(end);
        return dis;
    }

    // Now lets start the A* algorithm here
    private int aStarAlgorithm(ANode[][] grid, ANode start, ANode end) {
        int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        // Using a priority queue
        PriorityQueue<ANode> pq = new PriorityQueue<>(
                (a, b) -> a.fScore - b.fScore);
        // add the initial node to this priority queue
        pq.offer(start);
        // Now start
        while (!pq.isEmpty()) {
            ANode curr = pq.poll();
            if (curr.r == end.r && curr.c == end.c) {
                // set the prev for end
                // we need end while printing paths
                end.prev = curr.prev;
                // Goal found,return the g_score
                return curr.gScore;
            }
            // else go all 8 dirs and add the neighbors
            for (int[] dir : dirs) {
                int nr = curr.r + dir[0];
                int nc = curr.c + dir[1];
                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
                    // get the neighbor
                    ANode next = grid[nr][nc];
                    if (next.val == 1) {
                        // if its value is 1,continue (This is Blockage,Dont process)
                        continue;
                    }
                    int tentativeDisToNeighbor = curr.gScore + 1;
                    if (tentativeDisToNeighbor >= next.gScore) {
                        // if the tentativeDistance is already greater or equal to next gscore
                        // just continue,this way we cant get shortest path
                        continue;
                    }
                    // Update the f_score and g_score
                    next.gScore = tentativeDisToNeighbor;
                    next.fScore = tentativeDisToNeighbor + getHeuristic(next, end);
                    // updating the prev
                    next.prev = curr;
                    // add to the priority queue
                    pq.offer(next);
                }
            }
        }
        return -1;
    }

    // Lets calculate the heuristic function to update the fScore
    private int getHeuristic(ANode st, ANode end) {
        int sr = st.r;
        int sc = st.c;
        int er = end.r;
        int ec = end.c;
        double dx = er - sr;
        double dy = ec - sc;
        double euclideanDistance = Math.sqrt(dx * dx + dy * dy);
        return (int) euclideanDistance;
    }

    // Printing out the path taken
    private void printPath(ANode node) {
        if (node == null) {
            return;
        }
        printPath(node.prev);
        System.out.println(node.r + "-" + node.c);
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        AStarAlgorithm obj = new AStarAlgorithm();
        System.out.println(obj.shortestPathBinaryMatrix(grid));
    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CheckIfThereIsValidPathInGrid {

    // order=left,right,up,down
    int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
    String L = "L";
    String R = "R";
    String U = "U";
    String D = "D";
    String[] dirFromIdx = new String[] { L, R, U, D };

    public boolean hasValidPath(int[][] grid) {
        HashMap<Integer, HashMap<String, List<Integer>>> canGo = new HashMap<>();
        setDirections(canGo);
        // System.out.println(canGo);
        // lets create a grid for tracking visited roads
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return dfsHelper(grid, visited, canGo, 0, 0, false);
    }

    private void setDirections(HashMap<Integer, HashMap<String, List<Integer>>> canGo) {
        // lets keep track for which road is available to go from which
        // FOR 1
        HashMap<String, List<Integer>> directions = new HashMap<>();
        directions.put(R, Arrays.asList(1, 3, 5));
        directions.put(L, Arrays.asList(1, 4, 6));
        canGo.put(1, directions);
        // FOR 2
        directions = new HashMap<>();
        directions.put(U, Arrays.asList(2, 3, 4));
        directions.put(D, Arrays.asList(2, 5, 6));
        canGo.put(2, directions);
        // FOR 3
        directions = new HashMap<>();
        directions.put(D, Arrays.asList(2, 5, 6));
        directions.put(L, Arrays.asList(1, 4, 6));
        canGo.put(3, directions);
        // FOR 4
        directions = new HashMap<>();
        directions.put(R, Arrays.asList(1, 3, 5));
        directions.put(D, Arrays.asList(2, 5, 6));
        canGo.put(4, directions);
        // FOR 5
        directions = new HashMap<>();
        directions.put(U, Arrays.asList(2, 3, 4));
        directions.put(L, Arrays.asList(1, 4, 6));
        canGo.put(5, directions);
        // FOR 6
        directions = new HashMap<>();
        directions.put(R, Arrays.asList(1, 3, 5));
        directions.put(U, Arrays.asList(2, 3, 4));
        canGo.put(6, directions);
    }

    private boolean dfsHelper(int[][] grid, boolean[][] visited, HashMap<Integer, HashMap<String, List<Integer>>> canGo,
            int r, int c,
            boolean hasPath) {
        // System.out.println(r + "&&" + c);
        // if current row and column is the last,then return true
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            hasPath = true;
            return hasPath;
        }
        // check for visited,so that we wont go round and round
        if (visited[r][c] == true) {
            return hasPath;
        }
        visited[r][c] = true;
        // Now check four directions to go if we can
        int currRoad = grid[r][c];
        for (int i = 0; i < 4; i++) {
            int[] dir = dirs[i];
            int nr = r + dir[0];
            int nc = c + dir[1];
            String directionTrying = dirFromIdx[i];
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
                int nextRoad = grid[nr][nc];
                if (canGo.get(currRoad).containsKey(directionTrying)) {
                    // If there's a way to go to that direction
                    List<Integer> roads = canGo.get(currRoad).get(directionTrying);
                    if (roads.contains(nextRoad)) {
                        // Then call DFS
                        hasPath = dfsHelper(grid, visited, canGo, nr, nc, hasPath);
                    }
                }
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        CheckIfThereIsValidPathInGrid obj = new CheckIfThereIsValidPathInGrid();
        int[][] grid = { { 4, 1 }, { 6, 1 } };
        System.out.println(obj.hasValidPath(grid));
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumNumberOfFishInAGrid {

    public int findMaxFish(int[][] grid) {
        int maxFish = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Running DFS For every Non-Zero cell and tracking fish
                if (grid[i][j] != 0) {
                    count += 1;
                    int fish = countFishByDfsHelper(grid, i, j, new HashSet<>(), 0);
                    maxFish = Math.max(maxFish, fish);
                }
            }
        }
        // If we didnt get to run dfs,count will be 0 in that case,and fish will also be
        // zero
        return count > 0 ? maxFish : 0;
    }

    private int countFishByDfsHelper(int[][] grid, int row, int col, Set<List<Integer>> visited, int fish) {
        List<Integer> currRowCol = new ArrayList<>();
        currRowCol.add(row);
        currRowCol.add(col);
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || visited.contains(currRowCol)
                || grid[row][col] == 0) {
            return fish;
        }
        // Add fish once it is traversed
        fish += grid[row][col];
        visited.add(currRowCol);
        fish = countFishByDfsHelper(grid, row, col + 1, visited, fish);
        fish = countFishByDfsHelper(grid, row + 1, col, visited, fish);
        fish = countFishByDfsHelper(grid, row, col - 1, visited, fish);
        fish = countFishByDfsHelper(grid, row - 1, col, visited, fish);
        return fish;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 2, 1, 0 },
                { 4, 0, 0, 3 },
                { 1, 0, 0, 4 },
                { 0, 3, 2, 0 }
        };
        MaximumNumberOfFishInAGrid obj = new MaximumNumberOfFishInAGrid();
        System.out.println(obj.findMaxFish(grid));
    }
}

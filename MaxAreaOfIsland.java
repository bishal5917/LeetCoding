import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count += 1;
                    int area = countIslandsRecursiveHelper(grid, i, j, new HashSet<>(), 0);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return count == 0 ? 0 : maxArea;
    }

    private int countIslandsRecursiveHelper(int[][] grid, int row, int col, Set<List<Integer>> visited, int area) {
        List<Integer> currRowCol = new ArrayList<>();
        currRowCol.add(row);
        currRowCol.add(col);
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || visited.contains(currRowCol)
                || grid[row][col] == 0) {
            return area;
        }
        // Mark as -1 once it is traversed
        grid[row][col] = -1;
        area += 1;
        visited.add(currRowCol);
        area = countIslandsRecursiveHelper(grid, row, col + 1, visited, area);
        area = countIslandsRecursiveHelper(grid, row + 1, col, visited, area);
        area = countIslandsRecursiveHelper(grid, row, col - 1, visited, area);
        area = countIslandsRecursiveHelper(grid, row - 1, col, visited, area);
        return area;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
        };
        MaxAreaOfIsland obj = new MaxAreaOfIsland();
        System.out.println(obj.maxAreaOfIsland(grid));
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfEnclaves {

    public int numEnclaves(int[][] grid) {
        Set<List<Integer>> allBorderCells = getAllBorderCells(grid);
        return traverseGridAndFindEnclaves(allBorderCells, grid);
    }

    private int traverseGridAndFindEnclaves(Set<List<Integer>> allBorderCells, int[][] grid) {
        int count = 0;
        for (List<Integer> item : allBorderCells) {
            int a = item.get(0);
            int b = item.get(1);
            if (grid[a][b] == 1) {
                traverseLandDFSHelper(grid, a, b, new HashSet<>());
            }
        }
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    count += 1;
                }
            }
        }
        return count;
    }

    private Set<List<Integer>> getAllBorderCells(int[][] grid) {
        // traverse from every border cell
        Set<List<Integer>> allBorderCells = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < grid.length) {
            List<Integer> vals = new ArrayList<>();
            vals.add(i);
            vals.add(0);
            allBorderCells.add(vals);
            i += 1;
        }
        while (j < grid[0].length) {
            List<Integer> vals = new ArrayList<>();
            vals.add(0);
            vals.add(j);
            allBorderCells.add(vals);
            j += 1;
        }
        i = 0;
        j = 0;
        while (i < grid.length) {
            List<Integer> vals = new ArrayList<>();
            vals.add(i);
            vals.add(grid[0].length - 1);
            allBorderCells.add(vals);
            i += 1;
        }
        while (j < grid[0].length) {
            List<Integer> vals = new ArrayList<>();
            vals.add(grid.length - 1);
            vals.add(j);
            allBorderCells.add(vals);
            j += 1;
        }
        return allBorderCells;
    }

    private void traverseLandDFSHelper(int[][] grid, int row, int col, Set<List<Integer>> visited) {
        List<Integer> currRowCol = new ArrayList<>();
        currRowCol.add(row);
        currRowCol.add(col);
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || visited.contains(currRowCol)
                || grid[row][col] == 0) {
            return;
        }
        // Mark as Done once it is traversed
        grid[row][col] = -1;
        visited.add(currRowCol);
        traverseLandDFSHelper(grid, row, col + 1, visited);
        traverseLandDFSHelper(grid, row + 1, col, visited);
        traverseLandDFSHelper(grid, row, col - 1, visited);
        traverseLandDFSHelper(grid, row - 1, col, visited);
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 }
        };
        NumberOfEnclaves obj = new NumberOfEnclaves();
        System.out.println(obj.numEnclaves(grid));
    }
}
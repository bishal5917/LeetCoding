import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfClosedIslands {

    public int closedIsland(int[][] grid) {
        // first of all get all border cells
        Set<List<Integer>> allBorderCells = getAllBorderCells(grid);
        // traverse from border and eliminate connected islands as they are not closed
        traverseFromBordersAndEliminateIslands(allBorderCells, grid);
        // count the remaining island as they are the closed ones
        return traverseAndCountClosedIslands(grid);
    }

    private int traverseAndCountClosedIslands(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    count += 1;
                    traverseGridDFSHelper(grid, i, j, new HashSet<>());
                }
            }
        }
        return count;
    }

    private void traverseFromBordersAndEliminateIslands(Set<List<Integer>> allBorderCells, int[][] grid) {
        for (List<Integer> item : allBorderCells) {
            int a = item.get(0);
            int b = item.get(1);
            if (grid[a][b] == 0) {
                traverseGridDFSHelper(grid, a, b, new HashSet<>());
            }
        }
    }

    private Set<List<Integer>> getAllBorderCells(int[][] grid) {
        // traverse from every border cell
        Set<List<Integer>> allBorderCells = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                    List<Integer> borderCell = new ArrayList<>();
                    borderCell.add(i);
                    borderCell.add(j);
                    allBorderCells.add(borderCell);
                }
            }
        }
        return allBorderCells;
    }

    private void traverseGridDFSHelper(int[][] grid, int row, int col, Set<List<Integer>> visited) {
        // NOTE THAT 0=ISLAND and 1=WATER
        List<Integer> currRowCol = new ArrayList<>();
        currRowCol.add(row);
        currRowCol.add(col);
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || visited.contains(currRowCol)
                || grid[row][col] == 1) {
            return;
        }
        // Mark as Done once it is traversed
        grid[row][col] = -1;
        visited.add(currRowCol);
        traverseGridDFSHelper(grid, row, col + 1, visited);
        traverseGridDFSHelper(grid, row + 1, col, visited);
        traverseGridDFSHelper(grid, row, col - 1, visited);
        traverseGridDFSHelper(grid, row - 1, col, visited);
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0, 1, 1, 0 },
                { 1, 0, 1, 0, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 0 }
        };
        NumberOfClosedIslands obj = new NumberOfClosedIslands();
        System.out.println(obj.closedIsland(grid));
    }
}
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> vals = new ArrayList<>();
        Set<List<Integer>> pacificBorders = getBorderCells(heights, true);
        Set<List<Integer>> atlanticBorders = getBorderCells(heights, false);
        Set<List<Integer>> visitedPacific = new HashSet<>();
        Set<List<Integer>> visitedAtlantic = new HashSet<>();
        for (List<Integer> item : pacificBorders) {
            visitedPacific.addAll(traverseGridDFSHelper(heights, item.get(0), item.get(1), new HashSet<>(),
                    pacificBorders, new ArrayList<>()));
        }
        for (List<Integer> item : atlanticBorders) {
            visitedAtlantic.addAll(traverseGridDFSHelper(heights, item.get(0), item.get(1), new HashSet<>(),
                    atlanticBorders, new ArrayList<>()));
        }
        for (List<Integer> item : visitedPacific) {
            if (visitedAtlantic.contains(item)) {
                vals.add(item);
            }
        }
        return vals;
    }

    private Set<List<Integer>> getBorderCells(int[][] grid, boolean forPacific) {
        // TOP AND LEFT ARE FOR PACIFIC
        // BOTTOM AND RIGHT ARE FOR ATLANTIC
        Set<List<Integer>> borderCells = new HashSet<>();
        int i = 0;
        int j = 0;
        if (forPacific) {
            while (i < grid.length) {
                List<Integer> vals = new ArrayList<>();
                vals.add(i);
                vals.add(0);
                borderCells.add(vals);
                i += 1;
            }
            while (j < grid[0].length) {
                List<Integer> vals = new ArrayList<>();
                vals.add(0);
                vals.add(j);
                borderCells.add(vals);
                j += 1;
            }
        } else {
            while (i < grid.length) {
                List<Integer> vals = new ArrayList<>();
                vals.add(i);
                vals.add(grid[0].length - 1);
                borderCells.add(vals);
                i += 1;
            }
            while (j < grid[0].length) {
                List<Integer> vals = new ArrayList<>();
                vals.add(grid.length - 1);
                vals.add(j);
                borderCells.add(vals);
                j += 1;
            }
        }
        return borderCells;
    }

    private List<List<Integer>> traverseGridDFSHelper(int[][] grid, int row, int col, Set<List<Integer>> visited,
            Set<List<Integer>> borders, List<List<Integer>> points) {
        List<Integer> currRowCol = new ArrayList<>();
        currRowCol.add(row);
        currRowCol.add(col);
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || visited.contains(currRowCol)) {
            return points;
        }
        visited.add(currRowCol);
        if (col + 1 < grid[0].length && grid[row][col] <= grid[row][col + 1]) {
            traverseGridDFSHelper(grid, row, col + 1, visited, borders, points);
        }
        if (row + 1 < grid.length && grid[row][col] <= grid[row + 1][col]) {
            traverseGridDFSHelper(grid, row + 1, col, visited, borders, points);
        }
        if (col - 1 >= 0 && grid[row][col] <= grid[row][col - 1]) {
            traverseGridDFSHelper(grid, row, col - 1, visited, borders, points);
        }
        if (row - 1 >= 0 && grid[row][col] <= grid[row - 1][col]) {
            traverseGridDFSHelper(grid, row - 1, col, visited, borders, points);
        }
        points.add(currRowCol);
        return points;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 }
        };
        PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();
        System.out.println(obj.pacificAtlantic(grid));
    }
}
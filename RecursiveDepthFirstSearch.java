import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecursiveDepthFirstSearch {

    List<List<Integer>> depthFirstSearch(int[][] grid) {
        return recursiveDfsHelper(grid, 0, 0, new ArrayList<>(), new HashSet<>());
    }

    List<List<Integer>> recursiveDfsHelper(int[][] grid, int row, int col, List<List<Integer>> points,
            Set<List<Integer>> visited) {
        List<Integer> curr = new ArrayList<>();
        curr.add(row);
        curr.add(col);
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || visited.contains(curr)) {
            return points;
        }
        // add in points and visited
        points.add(curr);
        visited.add(curr);
        // visit all directions
        recursiveDfsHelper(grid, row, col + 1, points, visited);// (RIGHT)
        recursiveDfsHelper(grid, row + 1, col, points, visited);// (DOWN)
        recursiveDfsHelper(grid, row, col - 1, points, visited);// (LEFT)
        recursiveDfsHelper(grid, row - 1, col, points, visited);// (UP)
        return points;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        // int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 } };
        RecursiveDepthFirstSearch obj = new RecursiveDepthFirstSearch();
        List<List<Integer>> ans = obj.depthFirstSearch(grid);
        System.out.println(ans);
    }
}
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        return spiralOrderDfsTraverser(matrix, 0, 0, new ArrayList<>(), 'R');
    }

    List<Integer> spiralOrderDfsTraverser(int[][] grid, int row, int col, List<Integer> values, char direction) {

        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || grid[row][col] == 101) {
            return values;
        }

        values.add(grid[row][col]);
        // mark that as visited (set to 101)
        // because we wont have values greater than 100
        grid[row][col] = 101;

        // go in all the four directions
        if (direction == 'R') {
            // If previous was right , go right again till base case reaches
            values = spiralOrderDfsTraverser(grid, row, col + 1, values, 'R');
            values = spiralOrderDfsTraverser(grid, row + 1, col, values, 'D');
            values = spiralOrderDfsTraverser(grid, row, col - 1, values, 'L');
            values = spiralOrderDfsTraverser(grid, row - 1, col, values, 'U');
        }
        if (direction == 'D') {
            // If previous was down , go down again till base case reaches
            values = spiralOrderDfsTraverser(grid, row + 1, col, values, 'D');
            values = spiralOrderDfsTraverser(grid, row, col - 1, values, 'L');
            values = spiralOrderDfsTraverser(grid, row - 1, col, values, 'U');
            values = spiralOrderDfsTraverser(grid, row, col + 1, values, 'R');
        }
        if (direction == 'L') {
            // If previous was left , go left again till base case reaches
            values = spiralOrderDfsTraverser(grid, row, col - 1, values, 'L');
            values = spiralOrderDfsTraverser(grid, row - 1, col, values, 'U');
            values = spiralOrderDfsTraverser(grid, row, col + 1, values, 'R');
            values = spiralOrderDfsTraverser(grid, row + 1, col, values, 'D');
        }
        if (direction == 'U') {
            // If previous was up , go up again till base case reaches
            values = spiralOrderDfsTraverser(grid, row - 1, col, values, 'U');
            values = spiralOrderDfsTraverser(grid, row, col + 1, values, 'R');
            values = spiralOrderDfsTraverser(grid, row + 1, col, values, 'D');
            values = spiralOrderDfsTraverser(grid, row, col - 1, values, 'L');
        }

        return values;
    }

    public static void main(String[] args) {
        SpiralMatrix obj = new SpiralMatrix();
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        List<Integer> ans = obj.spiralOrder(matrix);
        System.out.println(ans);
    }

}

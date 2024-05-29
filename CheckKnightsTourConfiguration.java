
public class CheckKnightsTourConfiguration {

    int[][] dirs = { { -2, 1 }, { -1, 2 }, { 2, 1 }, { 1, 2 }, { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 } };

    public boolean checkValidGrid(int[][] grid) {
        return checkKnightTourRecursiveHelper(grid, 0, 0, -1);
    }

    private boolean checkKnightTourRecursiveHelper(int[][] grid, int r, int c, int currNum) {
        if (r >= grid.length || c >= grid[0].length || r < 0 || c < 0 || grid[r][c] != currNum + 1) {
            return false;
        }
        if (grid[r][c] == (grid.length * grid[0].length) - 1) {
            // Reached the final destination
            return true;
        }
        // Now checking all eight directions
        for (int[] dir : dirs) {
            boolean isFound = checkKnightTourRecursiveHelper(grid, r + dir[0], c + dir[1], grid[r][c]);
            if (isFound) {
                // if reached the destination,return true
                return true;
            }
        }
        // else return false
        return false;
    }

    public static void main(String[] args) {
        CheckKnightsTourConfiguration obj = new CheckKnightsTourConfiguration();
        int[][] grid = { { 0, 11, 16, 5, 20 },
                { 17, 4, 19, 10, 15 },
                { 12, 1, 8, 21, 6 },
                { 3, 18, 23, 14, 9 },
                { 24, 13, 2, 7, 22 }
        };
        System.out.println(obj.checkValidGrid(grid));
    }
}

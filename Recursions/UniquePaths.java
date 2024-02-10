package Recursions;

//THIS IS A BRUTEFORCED SOLUTION THAT USES RECURSION 
//SO THIS WONT WORK FOR LARGE GRID
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        return uniquePathsHelper(grid, 0, 0, 0);
    }

    private int uniquePathsHelper(int[][] grid, int row, int col, int paths) {
        if (row >= grid.length || col >= grid[0].length) {
            return paths;
        }
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            // means that we have reached a destination
            paths += 1;
            return paths;
        }
        // Move right
        paths = uniquePathsHelper(grid, row, col + 1, paths);
        // Move down
        paths = uniquePathsHelper(grid, row + 1, col, paths);
        return paths;
    }

    public static void main(String[] args) {
        UniquePaths obj = new UniquePaths();
        int m = 3;
        int n = 7;
        int ans = obj.uniquePaths(m, n);
        System.out.println(ans);
    }

}

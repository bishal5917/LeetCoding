public class PathWithMaximumGold {

    public int getMaximumGold(int[][] grid) {
        int currMaxGold = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    int gold = collectGoldRecursiveHelper(grid, i, j, 0, Integer.MIN_VALUE);
                    currMaxGold = Math.max(currMaxGold, gold);
                }
            }
        }
        return currMaxGold;
    }

    private int collectGoldRecursiveHelper(int[][] grid, int row, int col, int currGold, int maxGold) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            maxGold = Math.max(maxGold, currGold);
            return maxGold;
        }
        // collect the gold
        int foundGold = grid[row][col];
        currGold = foundGold + currGold;

        // mark as visited (means after getting collected gold will be 0)
        grid[row][col] = 0;

        maxGold = collectGoldRecursiveHelper(grid, row, col + 1, currGold, maxGold);
        maxGold = collectGoldRecursiveHelper(grid, row + 1, col, currGold, maxGold);
        maxGold = collectGoldRecursiveHelper(grid, row, col - 1, currGold, maxGold);
        maxGold = collectGoldRecursiveHelper(grid, row - 1, col, currGold, maxGold);

        // backtrack
        // replace that collected gold
        grid[row][col] = foundGold;
        currGold = foundGold - currGold;

        return maxGold;
    }

    public static void main(String[] args) {
        PathWithMaximumGold obj = new PathWithMaximumGold();
        int[][] grid = {
                { 1, 0, 7 },
                { 2, 0, 6 },
                { 3, 4, 5 },
                { 0, 3, 0 },
                { 9, 0, 20 }
        };
        int ans = obj.getMaximumGold(grid);
        System.out.println(ans);
    }

}


public class CountSubIslands {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int subIslands = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    int notInFirst = traverseIslandRecursiveHelper(grid2, grid1, i, j, 0);
                    if (notInFirst == 0) {
                        subIslands += 1;
                    }
                }
            }
        }
        return subIslands;
    }

    // We are doing flood filling and checking simultaneously in a grid 2
    private int traverseIslandRecursiveHelper(int[][] grid2, int[][] grid1, int row, int col, int notInFirstCount) {
        if (row >= grid2.length || col >= grid2[0].length || row < 0 || col < 0 || grid2[row][col] == 0) {
            return notInFirstCount;
        }
        if (grid1[row][col] == 0) {
            notInFirstCount += 1;
        }
        // Mark as visited once it is traversed (SET TO ZERO)
        grid2[row][col] = 0;
        // track the max coordinates for the group
        notInFirstCount = traverseIslandRecursiveHelper(grid2, grid1, row, col + 1, notInFirstCount);
        notInFirstCount = traverseIslandRecursiveHelper(grid2, grid1, row + 1, col, notInFirstCount);
        notInFirstCount = traverseIslandRecursiveHelper(grid2, grid1, row, col - 1, notInFirstCount);
        notInFirstCount = traverseIslandRecursiveHelper(grid2, grid1, row - 1, col, notInFirstCount);
        return notInFirstCount;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                { 1, 1, 1, 0, 0 },
                { 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1 }
        };
        int[][] grid2 = {
                { 1, 1, 1, 0, 0 },
                { 0, 0, 1, 1, 1 },
                { 0, 1, 0, 0, 0 },
                { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 1, 0 }
        };
        CountSubIslands obj = new CountSubIslands();
        System.out.println(obj.countSubIslands(grid1, grid2));
    }
}

import java.util.HashMap;

class NeighborSum {

    int[][] grid;
    HashMap<Integer, int[]> indices;
    int[][] adjDirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
    int[][] diagDirs = { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

    public NeighborSum(int[][] grid) {
        this.grid = grid;
        this.indices = new HashMap<>();
        // And we store all the indices
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                indices.put(grid[r][c], new int[] { r, c });
            }
        }
    }

    public int adjacentSum(int value) {
        int sum = 0;
        int[] idxs = indices.get(value);
        int currRow = idxs[0];
        int currCol = idxs[1];
        for (int[] dir : adjDirs) {
            int newRow = currRow + dir[0];
            int newCol = currCol + dir[1];
            if (withinBounds(newRow, newCol)) {
                sum += grid[newRow][newCol];
            }
        }
        return sum;
    }

    public int diagonalSum(int value) {
        int sum = 0;
        int[] idxs = indices.get(value);
        int currRow = idxs[0];
        int currCol = idxs[1];
        for (int[] dir : diagDirs) {
            int newRow = currRow + dir[0];
            int newCol = currCol + dir[1];
            if (withinBounds(newRow, newCol)) {
                sum += grid[newRow][newCol];
            }
        }
        return sum;
    }

    private boolean withinBounds(int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 1, 2 },
                { 3, 4, 5 },
                { 6, 7, 8 }
        };
        NeighborSum obj = new NeighborSum(grid);
        System.out.println(obj.adjacentSum(1));
        System.out.println(obj.adjacentSum(4));
        System.out.println(obj.diagonalSum(4));
        System.out.println(obj.diagonalSum(8));
    }
}

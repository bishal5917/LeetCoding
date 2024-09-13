public class MinimumFlipsToMakeBinaryGridPalindromicI {

    public int minFlips(int[][] grid) {
        int rflips = 0;
        int cflips = 0;
        // lets iterate and try to find the flips
        // FOR ROWS
        for (int[] row : grid) {
            int l = 0;
            int r = row.length - 1;
            while (l <= r) {
                if (row[l++] != row[r--]) {
                    rflips++;
                }
            }
        }
        // FOR COLUMNS
        for (int c = 0; c < grid[0].length; c++) {
            // We check for all columns
            int t = 0;
            int b = grid.length - 1;
            while (t <= b) {
                if (grid[t++][c] != grid[b--][c]) {
                    cflips++;
                }
            }
        }
        return Math.min(rflips, cflips);
    }

    public static void main(String[] args) {
        MinimumFlipsToMakeBinaryGridPalindromicI obj = new MinimumFlipsToMakeBinaryGridPalindromicI();
        int[][] grid = {
                { 1, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 1 }
        };
        System.out.println(obj.minFlips(grid));
    }
}

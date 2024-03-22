public class MaximumSumOfHourglass {

    public int maxSum(int[][] grid) {
        long sum = 0;
        // FINDING THE HOURGLASS FOR EVERY POSITIONS
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                sum = Math.max(sum, getHourGlassSum(r, c, grid));
            }
        }
        return (int) sum;
    }

    private long getHourGlassSum(int i, int j, int[][] grid) {
        long currSum = 0;
        int x = j;
        // FINDING THE FIRST LINE OF HOURGLASS
        while (x < j + 3) {
            if (x >= grid[0].length) {
                return 0;
            }
            currSum += grid[i][x];
            x += 1;
        }
        // SUM THE MIDDLE ISOLATED ELEMENT OF HOURGLASS
        if (i + 1 < grid.length && j + 1 < grid[0].length) {
            currSum += grid[i + 1][j + 1];
        }
        i = i + 2;
        if (i >= grid.length) {
            return 0;
        }
        x = j;
        // FINDING THE SECOND LINE OF HOURGLASS
        while (x < j + 3) {
            if (x >= grid[0].length) {
                return 0;
            }
            currSum += grid[i][x];
            x += 1;
        }
        return currSum;
    }

    public static void main(String[] args) {
        MaximumSumOfHourglass obj = new MaximumSumOfHourglass();
        int[][] grid = { { 6, 2, 1, 3 },
                { 4, 2, 1, 5 },
                { 9, 2, 8, 7 },
                { 4, 1, 2, 9 } };
        System.out.println(obj.maxSum(grid));
    }
}

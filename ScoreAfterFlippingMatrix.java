public class ScoreAfterFlippingMatrix {

    public int matrixScore(int[][] grid) {
        int maxScore = getScore(grid);
        // FLIPPING NECESSARY ROWS
        for (int[] row : grid) {
            if (row[0] == 0) {
                // flip that row
                rowFlip(row);
            }
        }
        maxScore = getScore(grid);
        // FLIPPING NECESSARY COLUMNS
        for (int i = 0; i < grid[0].length; i++) {
            if (areZeroesMore(grid, i)) {
                // flip that column
                columnFlip(grid, i);
                maxScore = Math.max(maxScore, getScore(grid));
            }
        }
        return maxScore;
    }

    private int getScore(int[][] grid) {
        int score = 0;
        // Now its time to calculate the total score
        for (int[] row : grid) {
            int exponent = 0;
            int value = 0;
            for (int i = row.length - 1; i >= 0; i--) {
                value += (Math.pow(2, exponent++) * row[i]);
            }
            score += value;
        }
        return score;
    }

    private void rowFlip(int[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 0) {
                row[i] = 1;
            } else {
                row[i] = 0;
            }
        }
    }

    private void columnFlip(int[][] grid, int col) {
        int idx = 0;
        while (idx < grid.length) {
            if (grid[idx][col] == 0) {
                grid[idx][col] = 1;
            } else {
                grid[idx][col] = 0;
            }
            idx++;
        }
    }

    private boolean areZeroesMore(int[][] grid, int col) {
        // check if zeroes are greater than ones
        int idx = 0;
        int zeros = 0;
        int ones = 0;
        while (idx < grid.length) {
            if (grid[idx][col] == 0) {
                zeros++;
            } else {
                ones++;
            }
            idx++;
        }
        return zeros > ones;
    }

    public static void main(String[] args) {
        ScoreAfterFlippingMatrix obj = new ScoreAfterFlippingMatrix();
        int[][] grid = {
                { 0, 0, 1, 1 },
                { 1, 0, 1, 0 },
                { 1, 1, 0, 0 }
        };
        System.out.println(obj.matrixScore(grid));
    }
}

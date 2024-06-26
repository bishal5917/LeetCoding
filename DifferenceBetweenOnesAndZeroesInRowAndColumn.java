public class DifferenceBetweenOnesAndZeroesInRowAndColumn {

    public int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // counting zeroes and ones
        int[] onesInRow = new int[rows];
        int[] zerosInRow = new int[rows];
        int[] onesInCol = new int[cols];
        int[] zerosInCol = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    zerosInRow[i] += 1;
                    zerosInCol[j] += 1;
                } else {
                    onesInRow[i] += 1;
                    onesInCol[j] += 1;
                }
            }
        }
        // Now the time to generate the answer
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int ones = onesInRow[i] + onesInCol[j];
                int zeros = zerosInRow[i] + zerosInCol[j];
                grid[i][j] = ones - zeros;
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        DifferenceBetweenOnesAndZeroesInRowAndColumn obj = new DifferenceBetweenOnesAndZeroesInRowAndColumn();
        int[][] grid = {
                { 0, 1, 1 },
                { 1, 0, 1 },
                { 0, 0, 1 }
        };
        obj.onesMinusZeros(grid);
    }
}

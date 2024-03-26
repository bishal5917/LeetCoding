import java.util.Arrays;

public class RangeSumQuery2DImmutable {

    class NumMatrix {

        int[][] prefixSum = null;

        public NumMatrix(int[][] matrix) {
            this.prefixSum = matrix;
            calculatePrefixSum(prefixSum);
            printMatrix(prefixSum);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int topLeft = 0;
            int leftOut = 0;
            int topOut = 0;
            int bottomRight = prefixSum[row2][col2];
            if (row1 - 1 >= 0 && col1 - 1 >= 0) {
                topLeft = prefixSum[row1 - 1][col1 - 1];
            }
            if (col1 - 1 >= 0) {
                leftOut = prefixSum[row2][col1 - 1];
            }
            if (row1 - 1 >= 0) {
                topOut = prefixSum[row1 - 1][col2];
            }
            // System.out.println(bottomRight);
            // System.out.println(leftOut);
            // System.out.println(topOut);
            // System.out.println(topLeft);
            return bottomRight - leftOut - topOut + topLeft;
        }

        // HELPER FUNCTIONS
        private void calculatePrefixSum(int[][] prefixSum) {
            // for first row
            for (int col = 1; col < prefixSum[0].length; col++) {
                prefixSum[0][col] = prefixSum[0][col - 1] + prefixSum[0][col];
            }
            // for first col
            for (int row = 1; row < prefixSum.length; row++) {
                prefixSum[row][0] = prefixSum[row - 1][0] + prefixSum[row][0];
            }
            // now for the remaining portions
            for (int r = 1; r < prefixSum.length; r++) {
                for (int c = 1; c < prefixSum[0].length; c++) {
                    prefixSum[r][c] = (prefixSum[r - 1][c] + prefixSum[r][c - 1] + prefixSum[r][c])
                            - prefixSum[r - 1][c - 1];
                }
            }
        }

        private void printMatrix(int[][] prefixSum) {
            for (int[] row : prefixSum) {
                System.out.println(Arrays.toString(row));
            }
        }
    }

    public static void main(String[] args) {
        RangeSumQuery2DImmutable mainObj = new RangeSumQuery2DImmutable();
        int[][] matrix = { { 3, 0, 1, 4, 2 },
                { 5, 6, 3, 2, 1 },
                { 1, 2, 0, 1, 5 },
                { 4, 1, 0, 1, 7 },
                { 1, 0, 3, 0, 5 } };
        NumMatrix obj = mainObj.new NumMatrix(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        System.out.println(obj.sumRegion(1, 2, 2, 4));
    }
}
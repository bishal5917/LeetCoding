import java.util.Arrays;

public class FindMatrixGivenRowAndColumnSums {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // take minimum from curr row and column
                int rsum = rowSum[i];
                int csum = colSum[j];
                int min = Math.min(rsum, csum);
                // place the minimum
                matrix[i][j] = min;
                rowSum[i] -= min;
                colSum[j] -= min;
            }
        }
        printMatrix(matrix);
        return matrix;
    }

    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        FindMatrixGivenRowAndColumnSums obj = new FindMatrixGivenRowAndColumnSums();
        int[] rowSum = { 3, 8 };
        int[] colSum = { 4, 7 };
        obj.restoreMatrix(rowSum, colSum);
    }
}

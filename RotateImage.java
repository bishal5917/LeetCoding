import java.util.Arrays;

public class RotateImage {

    public void rotate(int[][] matrix) {
        // we first transpose and swap the columns
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                int a = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = a;
            }
        }
        swapColumns(matrix);
        printGrid(matrix);
    }

    private void swapColumns(int[][] matrix) {
        for (int idx = 0; idx < matrix.length; idx++) {
            int[] row = matrix[idx];
            int i = 0;
            int j = row.length - 1;
            while (i <= j) {
                int left = matrix[idx][i];
                int right = matrix[idx][j];
                // swap left and right
                matrix[idx][i] = right;
                matrix[idx][j] = left;
                i++;
                j--;
            }
        }
    }

    private void printGrid(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        RotateImage obj = new RotateImage();
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        obj.rotate(matrix);
    }
}

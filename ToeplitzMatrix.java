
public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            if (checkIsDiagonalToeplitz(i, 0, matrix) == false) {
                return false;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (checkIsDiagonalToeplitz(0, i, matrix) == false) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIsDiagonalToeplitz(int row, int col, int[][] matrix) {
        int first = matrix[row][col];
        while (row < matrix.length && col < matrix[0].length) {
            if (first != matrix[row][col]) {
                return false;
            }
            row += 1;
            col += 1;
        }
        return true;
    }

    public static void main(String[] args) {
        ToeplitzMatrix obj = new ToeplitzMatrix();
        int[][] matrix = { { 18 }, { 66 } };
        obj.isToeplitzMatrix(matrix);
    }

}

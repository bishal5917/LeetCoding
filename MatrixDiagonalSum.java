public class MatrixDiagonalSum {

    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int rows = mat.length;
        int cols = mat[0].length;
        // First, Lets do for left diagonal
        int i = 0;
        int j = 0;
        while (i < rows && j < cols) {
            sum += mat[i][j];
            // mark as added
            mat[i++][j++] = 0;
        }
        // First, Lets do for left diagonal
        i = 0;
        j = cols - 1;
        while (i < rows && j >= 0) {
            sum += mat[i][j];
            // mark as added
            mat[i++][j--] = 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        MatrixDiagonalSum obj = new MatrixDiagonalSum();
        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(obj.diagonalSum(mat));
    }
}

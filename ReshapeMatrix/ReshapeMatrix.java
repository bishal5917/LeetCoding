package ReshapeMatrix;

import java.util.ArrayList;
import java.util.List;

public class ReshapeMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int givenMatrxRow = mat.length;
        int givenMatrxCol = mat[0].length;
        if (givenMatrxRow * givenMatrxCol != r * c) {
            return mat;
        }
        if (givenMatrxRow == r && givenMatrxCol == c) {
            return mat;
        }

        // initialize a matrix to reshape
        int[][] matrix = new int[r][c];

        List<Integer> allNums = new ArrayList<>();

        for (var i = 0; i < givenMatrxRow; i++) {
            for (var j = 0; j < givenMatrxCol; j++) {
                int element = mat[i][j];
                allNums.add(element);
            }
        }

        int idx = 0;
        for (var k = 0; k < r; k++) {
            for (var l = 0; l < c; l++) {
                matrix[k][l] = allNums.get(idx);
                idx += 1;
            }
        }

        // Print the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        return matrix;

    }

    public static void main(String[] args) {
        int r = 1;
        int c = 4;
        int[][] matrx = { { 1, 2 }, { 3, 4 } };
        ReshapeMatrix rm = new ReshapeMatrix();
        System.out.println(rm.matrixReshape(matrx, r, c));
    }

}

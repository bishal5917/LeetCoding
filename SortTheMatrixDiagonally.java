import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortTheMatrixDiagonally {

    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        // Getting all those diagonal cells starting positions
        List<List<Integer>> diagonalStarts = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            diagonalStarts.add(new ArrayList<>(
                    Arrays.asList(i, 0)));
        }
        for (int i = 1; i < cols; i++) {
            diagonalStarts.add(new ArrayList<>(
                    Arrays.asList(0, i)));
        }
        // Now we go diagonally and get diagonal elements turn by turn
        for (List<Integer> start : diagonalStarts) {
            int r = start.get(0);
            int c = start.get(1);
            List<Integer> elems = new ArrayList<>();
            while (r < rows && c < cols) {
                elems.add(mat[r++][c++]);
            }
            // sort them
            Collections.sort(elems);
            // Now place them back into the matrix
            r = start.get(0);
            c = start.get(1);
            int idx = 0;
            while (r < rows && c < cols && idx < elems.size()) {
                mat[r++][c++] = elems.get(idx++);
            }
        }
        return mat;
    }

    private void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        SortTheMatrixDiagonally obj = new SortTheMatrixDiagonally();
        int[][] mat = {
                { 3, 3, 1, 1 },
                { 2, 2, 1, 2 },
                { 1, 1, 1, 2 }
        };
        obj.printMatrix(mat);
        obj.diagonalSort(mat);
        System.out.println(" AFTER SORTING");
        obj.printMatrix(mat);
    }
}

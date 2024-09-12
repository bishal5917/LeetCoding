import java.util.Arrays;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        spiralOrder(n, n, matrix);
        printGrid(matrix);
        return matrix;
    }

    private void spiralOrder(int rows, int cols, int[][] grid) {
        int num = 1;
        int i = 0;
        int j = 0;
        int prevRow = i;
        int prevCol = j;
        while (true) {
            boolean entered = false;
            // RIGHT
            while (isWithinGrid(i, j, rows, cols) && grid[i][j] == 0) {
                grid[i][j] = num++;
                j++;
                entered = true;
            }
            // DOWN
            j--;
            i++;
            while (isWithinGrid(i, j, rows, cols) && grid[i][j] == 0) {
                grid[i][j] = num++;
                i++;
                entered = true;
            }
            // LEFT
            i--;
            j--;
            while (isWithinGrid(i, j, rows, cols) && grid[i][j] == 0) {
                grid[i][j] = num++;
                j--;
                entered = true;
            }
            // UP
            j++;
            i--;
            while (isWithinGrid(i, j, rows, cols) && grid[i][j] == 0) {
                grid[i][j] = num++;
                i--;
                entered = true;
            }
            i = prevRow + 1;
            j = prevCol + 1;
            prevRow = i;
            prevCol = j;
            if (entered == false) {
                break;
            }
        }
    }

    private void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    private boolean isWithinGrid(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public static void main(String[] args) {
        SpiralMatrixII obj = new SpiralMatrixII();
        int n = 5;
        obj.generateMatrix(n);
    }
}

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyz = new ArrayList<>();
        // Now we gotta check each element if its max in row and min in column
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                int num = matrix[r][c];
                if (num == maxInRow(r, c, matrix) && num == minInColumn(r, c, matrix)) {
                    luckyz.add(num);
                }
            }
        }
        return luckyz;
    }

    // maximum in a row
    private int maxInRow(int r, int c, int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            max = Math.max(max, matrix[i][c]);
        }
        return max;
    }

    // minimum in a column
    private int minInColumn(int r, int c, int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[r].length; i++) {
            min = Math.min(min, matrix[r][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        LuckyNumbersInAMatrix obj = new LuckyNumbersInAMatrix();
        int[][] matrix = {
                { 3, 7, 8 },
                { 9, 11, 13 },
                { 15, 16, 17 }
        };
        System.out.println(obj.luckyNumbers(matrix));
    }
}

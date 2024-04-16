public class CountNegativeNumbersInSortedMatrix {

    public int countNegatives(int[][] grid) {
        int negatives = 0;
        // USING THE BINARY SEARCH TO FIND THE INDEX OF FIRST NEGATIVE
        for (int[] row : grid) {
            int l = 0;
            int r = row.length - 1;
            int firstNegative = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (row[mid] < 0) {
                    if (mid - 1 >= 0 && row[mid - 1] >= 0) {
                        firstNegative = mid;
                        break;
                    }
                    r -= 1;
                } else {
                    l += 1;
                }
            }
            if (row[0] < 0) {
                firstNegative = 0;
            }
            if (firstNegative != -1) {
                negatives = negatives + row.length - firstNegative;
            }
        }
        return negatives;
    }

    public static void main(String[] args) {
        CountNegativeNumbersInSortedMatrix obj = new CountNegativeNumbersInSortedMatrix();
        int[][] grid = { { 3, -1, -3, -3, -3 }, { 2, -2, -3, -3, -3 }, { 1, -2, -3, -3, -3 }, { 0, -3, -3, -3, -3 } };
        System.out.println(obj.countNegatives(grid));
    }
}

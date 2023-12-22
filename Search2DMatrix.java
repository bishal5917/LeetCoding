public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        int pos = 0; // potential subarray position

        // perform binary serach to find that particular subarray
        while (i <= j) {
            int mid = (i + j) / 2;
            int f = 0;
            int l = matrix[mid].length - 1;
            if (matrix[mid][f] <= target && matrix[mid][l] >= target) {
                System.out.println(mid);
                pos = mid;
                break;
            } else if (matrix[mid][f] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        int left = 0;
        int right = matrix[pos].length - 1;
        // now perform binary search on that array only
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[pos][mid] == target) {
                return true;
            } else if (matrix[pos][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix obj = new Search2DMatrix();
        int target = 23;
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        Boolean ans = obj.searchMatrix(matrix, target);
        System.out.println(ans);
    }
}
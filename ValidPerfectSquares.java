public class ValidPerfectSquares {

    public boolean isPerfectSquare(int num) {
        // Lets use the binary search approach
        long left = 1;
        long right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquares obj = new ValidPerfectSquares();
        int num = 16;
        System.out.println(obj.isPerfectSquare(num));
    }
}

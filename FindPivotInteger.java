import java.util.Arrays;

public class FindPivotInteger {

    public int pivotInteger(int n) {
        // First lets find the left and the right sum
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        leftSum[0] = 1;
        rightSum[n - 1] = n;
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + (i + 1);
            rightSum[n - i - 1] = rightSum[n - i] + n - i;
        }
        System.out.println(Arrays.toString(leftSum));
        System.out.println(Arrays.toString(rightSum));
        // Now find the difference
        for (int i = 0; i < n; i++) {
            if (leftSum[i] == rightSum[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotInteger obj = new FindPivotInteger();
        System.out.println(obj.pivotInteger(8));
    }
}

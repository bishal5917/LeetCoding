import java.util.Arrays;

public class Find3ConsecutiveIntegersSummingUptoNumber {

    public long[] sumOfThree(long num) {
        long[] ans = new long[3];
        // if we can make sum of three,lets solve for the value of x
        // x-1+x+x+1 = num
        long x = num / 3;
        if (x + x - 1 + x + 1 == num) {
            ans[0] = x - 1;
            ans[1] = x;
            ans[2] = x + 1;
        } else {
            ans = new long[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        Find3ConsecutiveIntegersSummingUptoNumber obj = new Find3ConsecutiveIntegersSummingUptoNumber();
        long sum = 4;
        long[] ans = obj.sumOfThree(sum);
        System.out.println(Arrays.toString(ans));
    }
}

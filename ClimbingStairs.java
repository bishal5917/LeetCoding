import java.util.Arrays;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] steps = new int[n + 2];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        steps[0] = 0;
        steps[1] = 1;
        // Now keep calculating from 2 to the last index
        for (int i = 2; i <= n + 1; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        System.out.println(Arrays.toString(steps));
        return steps[n + 1];
    }

    public static void main(String[] args) {
        ClimbingStairs obj = new ClimbingStairs();
        System.out.println(obj.climbStairs(3));
    }
}

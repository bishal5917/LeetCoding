import java.util.Arrays;

public class NthTribonacciNumber {

    public int tribonacci(int n) {
        int[] tribonaccis = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        tribonaccis[0] = 0;
        tribonaccis[1] = 1;
        tribonaccis[2] = 1;
        // Now keep calculating from 2 to the last index
        for (int i = 3; i <= n; i++) {
            tribonaccis[i] = tribonaccis[i - 1] + tribonaccis[i - 2] + tribonaccis[i - 3];
        }
        System.out.println(Arrays.toString(tribonaccis));
        return tribonaccis[n];
    }

    public static void main(String[] args) {
        NthTribonacciNumber obj = new NthTribonacciNumber();
        System.out.println(obj.tribonacci(6));
    }
}

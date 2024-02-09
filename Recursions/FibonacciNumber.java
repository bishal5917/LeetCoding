package Recursions;

public class FibonacciNumber {

    public int fib(int n) {
        return fibHelper(n);
    }

    private int fibHelper(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int last = fibHelper(n - 1);
        int secondLast = fibHelper(n - 2);
        return last + secondLast;
    }

    public static void main(String[] args) {
        FibonacciNumber obj = new FibonacciNumber();
        int ans = obj.fib(5);
        System.out.println(ans);
    }

}

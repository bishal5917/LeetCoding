package Recursions;

public class Factorial {

    public int factorial(int n) {
        return factorialHelper(n);
    }

    private int factorialHelper(int n) {
        if (n == 1) {
            return 1;
        }
        int val = n * factorialHelper(n - 1);
        return val;
    }

    public static void main(String[] args) {
        Factorial obj = new Factorial();
        int ans = obj.factorial(5);
        System.out.println(ans);
    }

}

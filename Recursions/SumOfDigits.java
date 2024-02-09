package Recursions;

public class SumOfDigits {

    // Finding the sum upto n
    public int sumOfDigits(int n) {
        return sumUptoDigitsHelper(0, 0, n);
    }

    private int sumUptoDigitsHelper(int curr, int sum, int n) {
        if (curr > n) {
            return sum;
        }
        sum = sum + curr;
        sum = sumUptoDigitsHelper(curr + 1, sum, n);
        return sum;
    }

    public static void main(String[] args) {
        SumOfDigits obj = new SumOfDigits();
        int ans = obj.sumOfDigits(5);
        System.out.println(ans);
    }
}

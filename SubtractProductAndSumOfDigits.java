public class SubtractProductAndSumOfDigits {

    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        // Now time to get the digits and do product and sum
        for (int i = n; i > 0; i /= 10) {
            int digit = i % 10;
            product *= digit;
            sum += digit;
        }
        return product - sum;
    }

    public static void main(String[] args) {
        SubtractProductAndSumOfDigits obj = new SubtractProductAndSumOfDigits();
        int n = 234;
        System.out.println(obj.subtractProductAndSum(n));
    }
}

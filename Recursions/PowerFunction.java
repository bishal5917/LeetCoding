package Recursions;

public class PowerFunction {

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        double ans = findPowerHelper(1, x, Math.abs(n));
        // if the exponent is negative the power is 1/ans
        return n > 0 ? ans : 1 / ans;
        // NAIVE LARGE TIME COMLEXITY SOLUTION
        // if (n > 0) {
        // return findPowerPositiveHelper(1, x, n);
        // } else if (n < 0) {
        // return findPowerNegativeHelper(1, x, n);
        // } else {
        // return 1;
        // }
    }

    // CLEVER SOLUTION
    private double findPowerHelper(double power, double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        // just the logic as 2^10 = 2^5 x 2^5
        power = findPowerHelper(power, base, exponent / 2);
        power = power * power;
        // If its odd , one base must be multiped again
        power = exponent % 2 == 0 ? power : base * power;
        return power;
    }

    private double findPowerPositiveHelper(double power, double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        power = base * findPowerPositiveHelper(power, base, exponent - 1);
        // BY ITERATION
        // for (int i = 0; i < exponent; i++) {
        // power = power * base;
        // }
        return power;
    }

    private double findPowerNegativeHelper(double power, double base, int exponent) {
        if (exponent == -1) {
            return 1 / base;
        }
        power = 1 / base * findPowerNegativeHelper(power, base, exponent + 1);
        // BY ITERATION
        // for (int i = exponent; i < 0; i++) {
        // power = power * 1 / base;
        // }
        return power;
    }

    public static void main(String[] args) {
        PowerFunction obj = new PowerFunction();
        double ans = obj.myPow(2, 4);
        // double ans = obj.myPow(0.00001, 2147483647);
        System.out.println(ans);
    }
}

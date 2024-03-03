import java.util.HashSet;

public class HappyNumber {

    public boolean isHappy(int n) {
        HashSet<Integer> numSet = new HashSet<>();
        // Loop till we get 1 or we go in a cycle
        while (true) {
            if (n == 1) {
                return true;
            }
            int squaredDigitsSum = 0;
            while (n > 0) {
                int num = n % 10;
                n = n / 10;
                squaredDigitsSum = squaredDigitsSum + num * num;
            }
            n = squaredDigitsSum;
            if (numSet.contains(n)) {
                return false;
            } else {
                numSet.add(n);
            }
        }
    }

    public static void main(String[] args) {
        HappyNumber obj = new HappyNumber();
        int n = 2;
        System.out.println(obj.isHappy(n));
    }
}

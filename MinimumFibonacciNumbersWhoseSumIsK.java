import java.util.ArrayList;
import java.util.List;

public class MinimumFibonacciNumbersWhoseSumIsK {

    public int findMinFibonacciNumbers(int k) {
        List<Integer> fibs = new ArrayList<>();
        fibs.add(1);
        fibs.add(1);
        int idx = 1;
        int next = fibs.get(idx) + fibs.get(idx - 1);
        idx++;
        while (next <= k) {
            fibs.add(next);
            next = fibs.get(idx) + fibs.get(idx - 1);
            idx++;
        }
        System.out.println(fibs);
        // NOW WE GOT THE FIB NUMBERS , ITS TIME TO BE GREEDY
        int count = 0;
        int i = fibs.size() - 1;
        int sum = 0;
        while (i >= 0) {
            // We try to include current number multiple times
            while (sum + fibs.get(i) <= k) {
                sum += fibs.get(i);
                // System.out.println(fibs.get(i));
                count += 1;
            }
            i -= 1;
            if (sum == k) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumFibonacciNumbersWhoseSumIsK obj = new MinimumFibonacciNumbersWhoseSumIsK();
        int k = 10;
        System.out.println(obj.findMinFibonacciNumbers(k));
    }
}

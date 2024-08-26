import java.util.HashSet;

public class MinimumSumOfKAvoidingArray {

    public int minimumSum(int n, int k) {
        int sum = 0;
        int num = 1;
        HashSet<Integer> set = new HashSet<>();
        while (set.size() != n) {
            // (k-num) is in set, discard this one
            if (!set.contains(k - num)) {
                set.add(num);
                sum += num;
            }
            num++;
        }
        return sum;
    }

    public static void main(String[] args) {
        MinimumSumOfKAvoidingArray obj = new MinimumSumOfKAvoidingArray();
        int n = 5;
        int k = 4;
        System.out.println(obj.minimumSum(n, k));
    }
}

import java.util.ArrayList;
import java.util.List;

public class KthFactorOfN {

    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        // Lets find the factors
        for (int i = 1; i <= n; i++) {
            if (factors.size() >= k) {
                break;
            }
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return k - 1 >= factors.size() ? -1 : factors.get(k - 1);
    }

    public static void main(String[] args) {
        KthFactorOfN obj = new KthFactorOfN();
        int n = 12;
        int k = 3;
        System.out.println(obj.kthFactor(n, k));
    }
}

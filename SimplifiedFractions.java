import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SimplifiedFractions {

    public List<String> simplifiedFractions(int n) {
        List<String> fractions = new ArrayList<>();
        HashSet<Double> found = new HashSet<>();
        // We use two loops and check
        for (int nume = 0; nume <= n; nume++) {
            for (int deno = nume + 1; deno <= n; deno++) {
                // Lets calculate and check
                double ans = (double) nume / (double) deno;
                if (!found.contains(ans) && ans < 1.0 && ans > 0.0) {
                    fractions.add(nume + "/" + deno);
                    found.add(ans);
                }
            }
        }
        return fractions;
    }

    public static void main(String[] args) {
        SimplifiedFractions obj = new SimplifiedFractions();
        int n = 10;
        System.out.println(obj.simplifiedFractions(n));
    }
}

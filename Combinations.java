import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        return findAllCombinationsRecursiveHelper(new ArrayList<>(), new ArrayList<>(), n, k, 1);
    }

    private List<List<Integer>> findAllCombinationsRecursiveHelper(List<List<Integer>> combs, List<Integer> curr, int n,
            int k, int start) {
        if (curr.size() == k) {
            combs.add(new ArrayList<>(curr));
            return combs;
        }
        for (int i = start; i <= n; i++) {
            curr.add(i);
            findAllCombinationsRecursiveHelper(combs, curr, n, k, i + 1);
            curr.remove(curr.size() - 1);
        }
        return combs;
    }

    public static void main(String[] args) {
        Combinations obj = new Combinations();
        List<List<Integer>> ans = obj.combine(4, 2);
        System.out.println(ans);
    }
}

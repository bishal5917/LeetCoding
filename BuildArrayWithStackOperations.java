import java.util.ArrayList;
import java.util.List;

public class BuildArrayWithStackOperations {
    private static String push = "Push";
    private static String pop = "Pop";

    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        // Now lets start adding push pop
        int i = 0;
        int j = 1;
        while (i < target.length && j <= n) {
            if (target[i] == j) {
                operations.add(push);
                i += 1;
                j += 1;
            } else {
                operations.add(push);
                operations.add(pop);
                j += 1;
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        int[] target = { 1, 3 };
        int n = 3;
        BuildArrayWithStackOperations obj = new BuildArrayWithStackOperations();
        System.out.println(obj.buildArray(target, n));
    }
}
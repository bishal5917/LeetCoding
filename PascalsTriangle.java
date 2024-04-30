import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        // Lets generate the array first
        List<List<Integer>> vals = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            int size = i + 1;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                // fill with zero
                list.add(0);
            }
            // Now change first and last to 1
            list.set(0, 1);
            list.set(i, 1);
            vals.add(list);
        }
        // Now substitute the required values
        for (int i = 2; i < vals.size(); i++) {
            List<Integer> prev = vals.get(i - 1);
            List<Integer> curr = vals.get(i);
            for (int j = 1; j < curr.size() - 1; j++) {
                int newVal = prev.get(j - 1) + prev.get(j);
                curr.set(j, newVal);
            }
        }
        return vals;
    }

    public static void main(String[] args) {
        PascalsTriangle obj = new PascalsTriangle();
        System.out.println(obj.generate(6));
    }
}

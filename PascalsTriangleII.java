import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        // Lets generate the array first upto rowIndex+1 only
        List<List<Integer>> vals = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
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
        return vals.get(rowIndex);
    }

    public static void main(String[] args) {
        PascalsTriangleII obj = new PascalsTriangleII();
        System.out.println(obj.getRow(3));
    }
}

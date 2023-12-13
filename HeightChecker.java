import java.util.ArrayList;
import java.util.Arrays;

public class HeightChecker {

    public int heightChecker(int[] heights) {

        ArrayList<Integer> unsorted = new ArrayList<>();
        for (int item : heights) {
            unsorted.add(item);
        }

        int i = 0;
        int count = 0;
        Arrays.sort(heights);

        while (i < heights.length) {
            if (heights[i] != unsorted.get(i)) {
                count += 1;
            }
            i += 1;
        }

        System.out.println(count);
        return count;

    }

    public static void main(String[] args) {
        HeightChecker obj = new HeightChecker();
        int[] heights = { 1, 1, 4, 2, 1, 3 };
        obj.heightChecker(heights);
    }
}

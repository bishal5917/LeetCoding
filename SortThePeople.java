import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SortThePeople {

    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> peopleHeightHash = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            peopleHeightHash.put(heights[i], names[i]);
        }
        // Now sort the heights in descending order
        List<Integer> sortedHeights = new ArrayList<>();
        for (int height : heights) {
            sortedHeights.add(height);
        }
        Collections.sort(sortedHeights, Collections.reverseOrder());
        // Now iterate over the sorted heights and put names in names array
        for (int i = 0; i < sortedHeights.size(); i++) {
            names[i] = peopleHeightHash.get(sortedHeights.get(i));
        }
        return names;
    }

    public static void main(String[] args) {
        String[] names = { "Mary", "John", "Emma" };
        int[] heights = { 180, 165, 170 };
        SortThePeople obj = new SortThePeople();
        String[] ans = obj.sortPeople(names, heights);
        System.out.println(Arrays.toString(ans));
    }

}

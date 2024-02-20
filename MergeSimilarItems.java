import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeSimilarItems {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        // Lets first create a hashmap
        List<List<Integer>> groups = new ArrayList<>();
        HashMap<Integer, Integer> itemValMap = new HashMap<>();
        for (int[] item : items1) {
            if (itemValMap.get(item[0]) == null) {
                itemValMap.put(item[0], item[1]);
            }
        }
        for (int[] item : items2) {
            if (itemValMap.get(item[0]) == null) {
                itemValMap.put(item[0], item[1]);
            } else {
                int prev = itemValMap.get(item[0]);
                itemValMap.put(item[0], prev + item[1]);
            }
        }
        // Now lets put all the entries in an Arraylist to sort it
        List<Integer> keys = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : itemValMap.entrySet()) {
            keys.add(entry.getKey());
        }
        // Now sort the vals
        Collections.sort(keys);
        // Now lets add the groups to our group array
        for (int item : keys) {
            List<Integer> group = new ArrayList<>();
            group.add(item);
            group.add(itemValMap.get(item));
            groups.add(group);
        }
        System.out.println(itemValMap);
        return groups;
    }

    public static void main(String[] args) {
        MergeSimilarItems obj = new MergeSimilarItems();
        int[][] items1 = { { 1, 1 }, { 4, 5 }, { 3, 8 } };
        int[][] items2 = { { 3, 1 }, { 1, 5 } };
        System.out.println(obj.mergeSimilarItems(items1, items2));
    }

}

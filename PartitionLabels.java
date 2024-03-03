import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        // Lets create a hashmap to find the last occurence
        List<Integer> occurences = new ArrayList<>();
        HashMap<Character, Integer> lastIdxCount = new HashMap<>();
        // calculate the last index
        for (int i = 0; i < s.length(); i++) {
            lastIdxCount.put(s.charAt(i), i);
        }
        System.out.println(lastIdxCount);
        // Now using the two pointer technique
        int size = 0;
        int i = 0;
        int currLastIndexMax = 0;
        while (i < s.length()) {
            size += 1;
            currLastIndexMax = Math.max(currLastIndexMax, lastIdxCount.get(s.charAt(i)));
            if (i == currLastIndexMax) {
                occurences.add(size);
                size = 0;
            }
            i += 1;
        }
        return occurences;
    }

    public static void main(String[] args) {
        PartitionLabels obj = new PartitionLabels();
        String s = "ababcbacadefegdehijhklij";
        System.out.println(obj.partitionLabels(s));
    }
}

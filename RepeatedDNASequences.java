import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        // Using hashset of not add repeatedly
        HashSet<String> sequences = new HashSet<>();
        // we gotta maintain a window of size 10
        if (s.length() < 10)
            return new ArrayList<>();
        int i = 0;
        int j = 0;
        StringBuilder curr = new StringBuilder();
        // maintain a HashMap to count
        HashMap<String, Integer> map = new HashMap<>();
        // first maintain a window of size 10
        while (j < 10) {
            curr.append(s.charAt(j));
            j += 1;
        }
        map.put(curr.toString(), 1);
        // NOW LETS SLIDE THE WINDOW WHILE CHECKING
        while (i < s.length() && j < s.length()) {
            curr.deleteCharAt(0);
            curr.append(s.charAt(j));
            if (map.containsKey(curr.toString())) {
                map.put(curr.toString(), map.get(curr.toString()) + 1);
                sequences.add(curr.toString());
            } else {
                map.put(curr.toString(), 1);
            }
            i += 1;
            j += 1;
        }
        System.out.println(map);
        return new ArrayList<>(sequences);
    }

    public static void main(String[] args) {
        RepeatedDNASequences obj = new RepeatedDNASequences();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(obj.findRepeatedDnaSequences(s));
    }
}

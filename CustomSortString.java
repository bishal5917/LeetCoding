import java.util.HashMap;
import java.util.HashSet;

public class CustomSortString {

    public String customSortString(String order, String s) {
        StringBuilder str = new StringBuilder();
        // Lets count the characters of s first
        HashSet<Character> used = new HashSet<>();
        HashMap<Character, Integer> smap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (smap.containsKey(c)) {
                smap.put(c, smap.get(c) + 1);
            } else {
                smap.put(c, 1);
            }
        }
        // Now we go one by one from order and add to ans , i.e str
        for (char c : order.toCharArray()) {
            if (smap.containsKey(c)) {
                // then add to str that many times
                for (int i = 0; i < smap.get(c); i++) {
                    str.append(c);
                }
                used.add(c);
            }
        }
        // Now add remanining from s which arenot used yet
        for (char c : s.toCharArray()) {
            if (!used.contains(c)) {
                str.append(c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        CustomSortString obj = new CustomSortString();
        String order = "cba";
        String s = "abcd";
        System.out.println(obj.customSortString(order, s));
    }
}

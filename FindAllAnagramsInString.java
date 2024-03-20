import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> idxs = new ArrayList<>();
        if (p.length() > s.length()) {
            return idxs;
        }
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> pmap = new HashMap<>();
        int i = 0;
        int j = 0;
        // Take the count of the target
        while (j < p.length()) {
            char curr = p.charAt(j);
            if (pmap.get(curr) == null) {
                pmap.put(curr, 1);
            } else {
                pmap.put(curr, pmap.get(curr) + 1);
            }
            j += 1;
        }
        // maintain a first window,take the count
        // Take the count of the target
        while (i < j) {
            char curr = s.charAt(i);
            if (smap.get(curr) == null) {
                smap.put(curr, 1);
            } else {
                smap.put(curr, smap.get(curr) + 1);
            }
            i += 1;
        }
        // take back i to the first
        i = 0;
        if (smap.equals(pmap)) {
            // if its anagram,add the first idx
            idxs.add(i);
        }
        // NOW LETS SLIDE THE WINDOW
        while (j < s.length()) {
            char prevChar = s.charAt(i);
            char nextChar = s.charAt(j);
            // remove the previous
            if (smap.get(prevChar) == 1) {
                smap.remove(prevChar);
            } else {
                smap.put(prevChar, smap.get(prevChar) - 1);
            }
            // add the new one
            if (smap.get(nextChar) == null) {
                smap.put(nextChar, 1);
            } else {
                smap.put(nextChar, smap.get(nextChar) + 1);
            }
            if (smap.equals(pmap)) {
                // if its anagram,add the first idx started
                System.out.println(pmap);
                System.out.println(smap);
                idxs.add(i + 1);
            }
            i += 1;
            j += 1;
        }
        return idxs;
    }

    public static void main(String[] args) {
        FindAllAnagramsInString obj = new FindAllAnagramsInString();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(obj.findAnagrams(s, p));
    }
}

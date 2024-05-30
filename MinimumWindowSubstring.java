import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int lIdx = 0;
        int rIdx = 1000000;
        // lets first maintain a tmap
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        int scount = 0;
        int tcount = 0;
        for (char ch : t.toCharArray()) {
            if (tmap.containsKey(ch)) {
                tmap.put(ch, tmap.get(ch) + 1);
            } else {
                tmap.put(ch, 1);
            }
        }
        tcount = tmap.size();
        // GOTTA SLIDE THE WINDOW MAN
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (smap.containsKey(ch)) {
                smap.put(ch, smap.get(ch) + 1);
            } else {
                smap.put(ch, 1);
            }
            if (tmap.containsKey(ch)) {
                // if same qty found,update the scount
                if (smap.get(ch).equals(tmap.get(ch))) {
                    scount += 1;
                }
            }
            // while the counts are equal,lets try to decrease the size from left
            while (scount == tcount) {
                if ((r - l + 1) < (rIdx - lIdx + 1)) {
                    lIdx = l;
                    rIdx = r + 1;
                }
                // slide from the left
                char leftCh = s.charAt(l);
                if (tmap.containsKey(leftCh)) {
                    // remove from the smap also
                    int sval = smap.get(leftCh);
                    int tval = tmap.get(leftCh);
                    sval -= 1;
                    // if after removing,still becomes greater or equal
                    // dont decrement scount,else decrease
                    if (sval < tval) {
                        scount -= 1;
                    }
                    // Updating value on smap
                    if (sval == 0) {
                        smap.remove(leftCh);
                    } else {
                        smap.put(leftCh, sval);
                    }
                }
                l += 1;
            }
            r += 1;
        }
        return rIdx == 1000000 ? "" : s.substring(lIdx, rIdx);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(obj.minWindow(s, t));
    }
}

import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {

    public List<String> printVertically(String s) {
        List<String> ans = new ArrayList<>();
        String[] str = s.split(" ");
        int maxLen = 0;
        for (String ss : str) {
            maxLen = Math.max(ss.length(), maxLen);
        }
        // Now lets print in vertical order
        int idx = 0;
        int i = 0;
        while (idx < maxLen) {
            StringBuilder sbr = new StringBuilder();
            // we create string and append to the ans
            while (i < str.length) {
                String curr = str[i];
                if (idx >= curr.length()) {
                    sbr.append(" ");
                } else {
                    sbr.append(curr.charAt(idx));
                }
                i++;
            }
            // gotta remove the trailing spaces
            if (sbr.charAt(sbr.length() - 1) == ' ') {
                // remove the spaces
                int spIdx = sbr.length() - 1;
                while (spIdx >= 0 && sbr.charAt(spIdx) == ' ') {
                    sbr.deleteCharAt(spIdx--);
                }
            }
            ans.add(sbr.toString());
            // increment
            idx++;
            // reset the index
            i = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        PrintWordsVertically obj = new PrintWordsVertically();
        String s = "HOW ARE YOU";
        System.out.println(obj.printVertically(s));
    }
}

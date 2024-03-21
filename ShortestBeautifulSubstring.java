public class ShortestBeautifulSubstring {

    public String shortestBeautifulSubstring(String s, int k) {
        int minLength = Integer.MAX_VALUE;
        String minBeauty = "";
        // USING THE SLIDING WINDOW APPROACH
        int onesCount = 0;
        int i = 0;
        int j = 0;
        StringBuilder curr = new StringBuilder();
        while (i < s.length()) {
            if (onesCount == k) {
                if (curr.length() < minLength) {
                    minLength = curr.length();
                    minBeauty = curr.toString();
                } else if (curr.length() == minLength) {
                    // use the lexically smaller one
                    minBeauty = getLexicallySmaller(minBeauty, curr.toString());
                }
                char prev = s.charAt(i);
                if (prev == '1') {
                    onesCount -= 1;
                }
                curr.deleteCharAt(0);
                i += 1;
            } else {
                if (j < s.length()) {
                    char ch = s.charAt(j);
                    curr.append(ch);
                    if (ch == '1') {
                        onesCount += 1;
                    }
                    j += 1;
                } else {
                    break;
                }
            }
        }
        return minBeauty;
    }

    private String getLexicallySmaller(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '0' && s2.charAt(i) == '1') {
                return s1;
            } else if (s1.charAt(i) == '1' && s2.charAt(i) == '0') {
                return s2;
            }
        }
        return s1;
    }

    public static void main(String[] args) {
        ShortestBeautifulSubstring obj = new ShortestBeautifulSubstring();
        String s = "001110101101101111";
        int k = 10;
        System.out.println(obj.shortestBeautifulSubstring(s, k));
    }
}

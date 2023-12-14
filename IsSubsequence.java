public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        int count = 0;
        int i = 0;
        int j = 0;

        while (i < t.length() && j < s.length()) {
            if (s.charAt(j) == t.charAt(i)) {
                count += 1;
                i += 1;
                j += 1;
            } else if (s.charAt(j) != t.charAt(i)) {
                i += 1;
            }
        }

        System.out.println(count);
        return count == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence obj = new IsSubsequence();
        String s = "";
        String t = "adgbcgt";
        obj.isSubsequence(s, t);
    }
}

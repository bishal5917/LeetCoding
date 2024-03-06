public class NumberOfMatchingSubsequences {

    // THIS IS WORKING FINE BUT I AM GETTING TLE ON LEETCODE DUE TO HIGH CONSTRAINTS
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        // lets use the two pointers and check one by one for each word against s
        for (String word : words) {
            if (checkSubsequence(s, word)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean checkSubsequence(String s, String target) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                i += 1;
                j += 1;
            } else {
                i += 1;
            }
        }
        // System.out.println(j);
        return j == target.length();
    }

    public static void main(String[] args) {
        NumberOfMatchingSubsequences obj = new NumberOfMatchingSubsequences();
        String s = "abcde";
        String[] words = { "a", "bb", "acd", "ace" };
        System.out.println(obj.numMatchingSubseq(s, words));
    }
}

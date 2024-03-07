public class ExpressiveWords {

    public int expressiveWords(String s, String[] words) {
        // using two pointers to check for each and every one of them
        int count = 0;
        for (String word : words) {
            if (isExpressive(s, word)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean isExpressive(String s, String w) {
        int i = 0;
        int j = 0;
        // now lets check one by one using two pointers
        while (i < s.length() && j < w.length()) {
            if (s.charAt(i) != w.charAt(j)) {
                return false;
            } else {
                int countOnS = 0;
                int countOnW = 0;
                char curr = s.charAt(i);
                while (i < s.length() && s.charAt(i) == curr) {
                    countOnS += 1;
                    i += 1;
                }
                while (j < w.length() && w.charAt(j) == curr) {
                    countOnW += 1;
                    j += 1;
                }
                if (countOnS < countOnW) {
                    return false;
                }
                if (countOnS != countOnW) {
                    if (countOnS < 3) {
                        return false;
                    }
                }
            }
        }
        return i == s.length() && j == w.length() ? true : false;
    }

    public static void main(String[] args) {
        ExpressiveWords obj = new ExpressiveWords();
        String s = "heeellooo";
        String[] words = { "hello", "hi", "helo" };
        System.out.println(obj.expressiveWords(s, words));
    }
}
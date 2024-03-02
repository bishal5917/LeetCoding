public class CheckIfStringIsArrayPrefix {

    public boolean isPrefixString(String s, String[] words) {
        // Lets make a stringbuilder to store words
        StringBuilder wordStr = new StringBuilder();
        int i = 0;
        int j = 0;
        // minimum concatenation length to make a word
        int minConcatLength = Integer.MAX_VALUE;
        // Add the words to make a string
        for (String word : words) {
            wordStr.append(word);
            minConcatLength = Math.min(minConcatLength, word.length());
        }
        // Now check using two pointers
        while (i < s.length() && j < wordStr.length()) {
            if (s.charAt(i) == wordStr.charAt(j)) {
                i += 1;
                j += 1;
            } else {
                break;
            }
        }
        System.out.println(i);
        System.out.println(wordStr);
        System.out.println(minConcatLength);
        // return i == s.length() && i >= minConcatLength;
        // JUST JUST DO THIS - One Annoying problem
        String res = "";
        for (int idx = 0; idx < words.length; idx++) {
            res = res + words[idx];
            if (res.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckIfStringIsArrayPrefix obj = new CheckIfStringIsArrayPrefix();
        String s = "iloveleetcode";
        String[] words = { "apples", "i", "love", "leetcode" };
        System.out.println(obj.isPrefixString(s, words));
    }

}

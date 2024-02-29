public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int i = 0;
        int j = 0;
        // Lets just merge alternately
        while (i < word1.length() && j < word2.length()) {
            merged.append(word1.charAt(i));
            merged.append(word2.charAt(j));
            i += 1;
            j += 1;
        }
        // Now add if remaining from word1 and word2
        while (i < word1.length()) {
            merged.append(word1.charAt(i));
            i += 1;
        }
        while (j < word2.length()) {
            merged.append(word2.charAt(j));
            j += 1;
        }
        return merged.toString();
    }

    public static void main(String[] args) {
        MergeStringsAlternately obj = new MergeStringsAlternately();
        String word1 = "abcd";
        String word2 = "pq";
        System.out.println(obj.mergeAlternately(word1, word2));
    }
}

import java.util.Arrays;
import java.util.HashSet;

public class CloseStrings {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        // Checking if two words have same character set
        // And checking if their frequencies are same
        HashSet<Character> seta = new HashSet<>();
        HashSet<Character> setb = new HashSet<>();
        int[] counta = new int[27];
        int[] countb = new int[27];
        for (char c : word1.toCharArray()) {
            counta[c - 97] += 1;
            seta.add(c);
        }
        for (char c : word2.toCharArray()) {
            countb[c - 97] += 1;
            setb.add(c);
        }
        Arrays.sort(counta);
        Arrays.sort(countb);
        for (int i = 0; i < counta.length; i++) {
            if (counta[i] != countb[i]) {
                return false;
            }
        }
        return seta.equals(setb) ? true : false;
    }

    public static void main(String[] args) {
        CloseStrings obj = new CloseStrings();
        String word1 = "abc";
        String word2 = "bca";
        System.out.println(obj.closeStrings(word1, word2));
    }
}

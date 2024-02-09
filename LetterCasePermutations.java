
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCasePermutations {

    Set<Character> digitSet = new HashSet<>();

    public List<String> letterCasePermutation(String s) {
        StringBuilder str = new StringBuilder();
        initHashSetOfNumbers();
        for (char c : s.toCharArray()) {
            str.append(c);
        }
        return letterCasePermutationsHelper(str, new ArrayList<>(), new HashSet<>(), 0);
    }

    private List<String> letterCasePermutationsHelper(StringBuilder s, List<String> allPerms,
            HashSet<String> allUsedPerms,
            int index) {
        if (!allUsedPerms.contains(s.toString())) {
            allPerms.add(s.toString());
            allUsedPerms.add(s.toString());
        }
        for (int i = index; i < s.length(); i++) {
            if (isDigit(s.charAt(i))) {
                continue;
            }
            char currChar = s.charAt(i);
            // TWO CHOICES (IF CHARACTER IS UPPERCASE OR LOWERCASE)
            if (Character.isLowerCase(currChar)) {
                // Convert that to uppercase and go for other characters
                s.setCharAt(i, Character.toUpperCase(currChar));
                // Going for other characters
                letterCasePermutationsHelper(s, allPerms, allUsedPerms, index + 1);
                // backtracking (UNDO THAT - convert back to lowercase)
                s.setCharAt(i, Character.toLowerCase(currChar));
            } else {
                // Convert that to lowercase and go for other characters
                s.setCharAt(i, Character.toLowerCase(currChar));
                // Going for other characters
                letterCasePermutationsHelper(s, allPerms, allUsedPerms, index + 1);
                // backtracking (UNDO THAT - convert back to uppercase)
                s.setCharAt(i, Character.toUpperCase(currChar));
            }
        }
        return allPerms;
    }

    private void initHashSetOfNumbers() {
        for (int i = 0; i <= 9; i++) {
            digitSet.add((char) i);
        }
    }

    private boolean isDigit(char c) {
        if (digitSet.contains(c)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LetterCasePermutations obj = new LetterCasePermutations();
        String s = "a1b2";
        List<String> ans = obj.letterCasePermutation(s);
        System.out.println(ans);
    }
}
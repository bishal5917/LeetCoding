import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        return findAllLetterCombinations(digits, new StringBuilder(), new ArrayList<>(), 0);
    }

    public List<String> findAllLetterCombinations(String digits, StringBuilder curr, List<String> allCombs, int index) {
        // Base case
        if (index >= digits.length()) {
            allCombs.add(curr.toString());
            return allCombs;
        }
        String numLetter = getLettersForPhoneCharacter(digits.charAt(index));
        // Does for every letter for every letters
        for (char c : numLetter.toCharArray()) {
            // add the digit
            curr.append(c);
            // call for next index
            findAllLetterCombinations(digits, curr, allCombs, index + 1);
            // finally backtrack
            curr.deleteCharAt(curr.length() - 1);
        }

        return allCombs;
    }

    String getLettersForPhoneCharacter(char num) {
        switch (num) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }

    // Just for reference.This code works for only one cases if we want combinations
    // of length 2 for each
    // digits given
    public List<String> letterCombinationsHelper(String givenFirst, String givenSecond, StringBuilder curr,
            List<String> allCombs, int start, int index) {
        if (index == givenFirst.length()) {
            return allCombs;
        }

        if (curr.length() == 0) {
            curr.append(givenFirst.charAt(index));
        }

        if (curr.length() == 2) {
            // System.out.println(curr);
            allCombs.add(curr.toString());
            return allCombs;
        }
        for (int i = start; i < givenSecond.length(); i++) {
            curr.append(givenSecond.charAt(i));
            allCombs = letterCombinationsHelper(givenFirst, givenSecond, curr, allCombs, i + 1, index);
            // backtrack and go for next one
            curr.deleteCharAt(curr.length() - 1);
        }
        // Backtrack - go for next one
        curr.deleteCharAt(curr.length() - 1);
        letterCombinationsHelper(givenFirst, givenSecond, curr, allCombs, 0, index +
                1);
        return allCombs;
    }

    public static void main(String[] args) {
        String digits = "234";
        LetterCombinationsOfPhoneNumber obj = new LetterCombinationsOfPhoneNumber();
        List<String> ans = obj.letterCombinations(digits);
        System.out.println(ans);
    }
}

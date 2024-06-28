import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class SortVowelsInString {

    public String sortVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        HashSet<Character> vowelSet = new HashSet<>(
                Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (vowelSet.contains(c)) {
                vowels.add(c);
            }
        }
        Collections.sort(vowels);
        // Now time to replace
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (vowelSet.contains(s.charAt(i))) {
                str.setCharAt(i, vowels.get(idx++));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        SortVowelsInString obj = new SortVowelsInString();
        String s = "lEetcOde";
        System.out.println(obj.sortVowels(s));
    }
}

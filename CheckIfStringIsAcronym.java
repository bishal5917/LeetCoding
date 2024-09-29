import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckIfStringIsAcronym {

    public boolean isAcronym(List<String> words, String s) {
        StringBuilder str = new StringBuilder();
        for (String word : words) {
            str.append(word.charAt(0));
        }
        return str.toString().equals(s);
    }

    public static void main(String[] args) {
        CheckIfStringIsAcronym obj = new CheckIfStringIsAcronym();
        List<String> words = new ArrayList<>(Arrays.asList("alice", "bob", "charlie"));
        String s = "abc";
        System.out.println(obj.isAcronym(words, s));
    }
}

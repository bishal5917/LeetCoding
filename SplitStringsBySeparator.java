import java.util.ArrayList;
import java.util.List;

public class SplitStringsBySeparator {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            String[] splitted = word.split("\\" + String.valueOf(separator));
            for (String split : splitted) {
                if (!split.isEmpty()) {
                    ans.add(split);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SplitStringsBySeparator obj = new SplitStringsBySeparator();
        List<String> words = new ArrayList<>();
        words.add("one.two.three");
        words.add("four.five");
        char separator = '.';
        System.out.println(obj.splitWordsBySeparator(words, separator));
    }
}

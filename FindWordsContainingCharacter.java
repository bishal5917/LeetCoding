import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.indexOf(x) != -1) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindWordsContainingCharacter obj = new FindWordsContainingCharacter();
        String[] words = { "leet", "code" };
        char x = 'e';
        System.out.println(obj.findWordsContaining(words, x));
    }

}

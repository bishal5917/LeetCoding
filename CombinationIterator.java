import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationIterator {

    List<String> combinations;
    int idx;
    int len;

    public CombinationIterator(String characters, int combinationLength) {
        this.combinations = new ArrayList<>();
        this.idx = 0;
        this.len = combinationLength;
        generateCombination(characters, new StringBuilder(), 0);
        Collections.sort(combinations);
        System.out.println(combinations);
    }

    private StringBuilder generateCombination(String str, StringBuilder curr, int idx) {
        if (curr.length() == len) {
            combinations.add(curr.toString());
        }
        for (int i = idx; i < str.length(); i++) {
            curr.append(str.charAt(i));
            generateCombination(str, curr, i + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
        return curr;
    }

    public String next() {
        return combinations.get(idx++);
    }

    public boolean hasNext() {
        if (idx < combinations.size()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CombinationIterator obj = new CombinationIterator("abc", 2);
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
    }
}

import java.util.ArrayList;
import java.util.List;

public class KthHappyString {

    public String getHappyString(int n, int k) {
        char[] chars = new char[] { 'a', 'b', 'c' };
        List<String> happyStrs = new ArrayList<>();
        generateHappyStrings(chars, new StringBuilder(), n, happyStrs);
        System.out.println(happyStrs);
        return k - 1 < happyStrs.size() ? happyStrs.get(k - 1) : "";
    }

    private StringBuilder generateHappyStrings(char[] chars, StringBuilder curr, int len, List<String> strs) {
        if (curr.length() == len) {
            strs.add(curr.toString());
            return curr;
        }
        for (int i = 0; i < chars.length; i++) {
            if (curr.length() == 0 || (curr.length() > 0 && curr.charAt(curr.length() - 1) != chars[i])) {
                curr.append(chars[i]);
                curr = generateHappyStrings(chars, curr, len, strs);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        KthHappyString obj = new KthHappyString();
        System.out.println(obj.getHappyString(3, 9));
    }
}

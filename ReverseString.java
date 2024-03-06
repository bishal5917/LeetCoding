import java.util.Arrays;

public class ReverseString {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder rev = new StringBuilder();
        // lets just iterate and append back
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                rev.append(words[i]);
                if (i != 0) {
                    rev.append(" ");
                }
            }
        }
        System.out.println(Arrays.toString(words));
        return rev.toString().trim();
    }

    public static void main(String[] args) {
        ReverseString obj = new ReverseString();
        String s = "a good   example";
        System.out.println(obj.reverseWords(s));
    }
}

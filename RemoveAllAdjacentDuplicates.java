import java.util.Stack;

public class RemoveAllAdjacentDuplicates {

    public String removeDuplicates(String s) {
        Stack<Character> chars = new Stack<>();
        // Now iterate
        for (char c : s.toCharArray()) {
            if (chars.isEmpty()) {
                chars.push(c);
                continue;
            }
            if (!chars.isEmpty() && chars.peek() == c) {
                while (!chars.isEmpty() && chars.peek() == c) {
                    chars.pop();
                }
            } else {
                chars.push(c);
            }
        }
        // Now add the remaining ones to the String
        StringBuilder res = new StringBuilder();
        for (char c : chars) {
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicates obj = new RemoveAllAdjacentDuplicates();
        String s = "abbaca";
        System.out.println(obj.removeDuplicates(s));
    }
}

import java.util.Stack;

public class MinStringLengthAfterRemovingSubstrings {

    public int minLength(String s) {
        Stack<Character> chars = new Stack<>();
        // Now lets start push and pop logic from the stack
        for (char c : s.toCharArray()) {
            if (chars.isEmpty()) {
                chars.push(c);
                continue;
            }
            if (!chars.isEmpty() && (c == 'B' || c == 'D')) {
                if (chars.peek() == 'A' && c == 'B') {
                    // Then we need to pop previous A
                    chars.pop();
                } else if (chars.peek() == 'C' && c == 'D') {
                    // Then we need to pop previous C
                    chars.pop();
                } else {
                    chars.push(c);
                }
            } else {
                chars.push(c);
            }
        }
        System.out.println(chars);
        return chars.size();
    }

    public static void main(String[] args) {
        MinStringLengthAfterRemovingSubstrings obj = new MinStringLengthAfterRemovingSubstrings();
        String s = "ABFCACDB";
        System.out.println(obj.minLength(s));
    }

}

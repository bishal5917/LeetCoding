import java.util.Stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        // Lets make two stacks for two strings
        Stack<Character> sA = getFinalStringsAfterRemoval(s);
        Stack<Character> sB = getFinalStringsAfterRemoval(t);
        System.out.println(sA);
        System.out.println(sB);
        // If size isnot same return false
        if (sA.size() != sB.size())
            return false;
        // Now compare each one by one
        int idx = 0;
        while (idx < sA.size()) {
            if (sA.get(idx) != sB.get(idx)) {
                return false;
            }
            idx += 1;
        }
        return true;
    }

    private Stack<Character> getFinalStringsAfterRemoval(String s) {
        Stack<Character> chars = new Stack<>();
        for (char c : s.toCharArray()) {
            if (chars.isEmpty() && c != '#') {
                // Dont push some backspace
                chars.push(c);
                continue;
            }
            if (c == '#' && chars.isEmpty()) {
                continue;
            } else if (c == '#' && !chars.isEmpty()) {
                chars.pop();
            } else {
                chars.push(c);
            }
        }
        return chars;
    }

    public static void main(String[] args) {
        BackspaceStringCompare obj = new BackspaceStringCompare();
        String s = "a##c";
        String t = "#a#c";
        System.out.println(obj.backspaceCompare(s, t));
    }

}

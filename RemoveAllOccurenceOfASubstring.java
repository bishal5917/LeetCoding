import java.util.Stack;

public class RemoveAllOccurenceOfASubstring {

    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();
        int lastChar = part.charAt(part.length() - 1);
        for (char c : s.toCharArray()) {
            if (c == lastChar) {
                // gotta do something
                // That something is,we go back the stack checking
                // if we can found the part
                st.add(c);
                int idx = part.length() - 1;
                int stTop = st.size() - 1;
                while (idx >= 0 && stTop >= 0) {
                    if (part.charAt(idx) == st.get(stTop)) {
                        idx -= 1;
                        stTop -= 1;
                    } else {
                        break;
                    }
                }
                // Now if idx goes -1,means all found,
                // pop the stack part.length times
                if (idx == -1) {
                    for (int i = 0; i < part.length(); i++) {
                        if (st.isEmpty()) {
                            // Just formality check
                            // this wont happen
                            continue;
                        }
                        st.pop();
                    }
                }
            } else {
                st.add(c);
            }
        }
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < st.size(); i++) {
            sbr.append(st.get(i));
        }
        return sbr.toString();
    }

    public static void main(String[] args) {
        RemoveAllOccurenceOfASubstring obj = new RemoveAllOccurenceOfASubstring();
        String s = "daabcbaabcbc";
        String part = "abc";
        System.out.println(obj.removeOccurrences(s, part));
    }
}

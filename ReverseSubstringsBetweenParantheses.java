import java.util.Stack;

public class ReverseSubstringsBetweenParantheses {

    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        // Lets just popped if we found an opening paranthesis
        for (char c : s.toCharArray()) {
            if (c == ')') {
                // just pop and add to str till we found an opening bracket
                StringBuilder str = new StringBuilder();
                while (st.peek() != '(') {
                    str.append(st.pop());
                }
                // popping the open bracket
                st.pop();
                // add back the reversed ones to the stack
                for (char ch : str.toString().toCharArray()) {
                    st.push(ch);
                }
            } else {
                // else just add
                st.push(c);
            }
        }
        System.out.println(st);
        StringBuilder rev = new StringBuilder();
        for (char c : st) {
            rev.append(c);
        }
        return rev.toString();
    }

    public static void main(String[] args) {
        String s = "(u(love)i)";
        ReverseSubstringsBetweenParantheses obj = new ReverseSubstringsBetweenParantheses();
        System.out.println(obj.reverseParentheses(s));
    }

}

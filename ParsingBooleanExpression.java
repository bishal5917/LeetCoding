import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParsingBooleanExpression {

    public boolean parseBoolExpr(String expression) {
        // Lets use the power of a stack
        Stack<Character> st = new Stack<>();
        // Now lets push the values in the stack and evaluate
        for (char c : expression.toCharArray()) {
            System.out.println(st);
            if (c == ',') {
                continue;
            }
            if (c == ')') {
                // closing found,keep popping till we find the opening
                // evaluate the expression
                // and push back the evaluated value to stack
                List<Character> chars = new ArrayList<>();
                while (!st.isEmpty() && st.peek() != '(') {
                    chars.add(st.pop());
                }
                // gotta pop the bracket also
                st.pop();
                // pop the operator itself and calculate the result
                char value = parse(st.pop(), chars);
                st.add(value);
                continue;
            }
            // pushing to the stack
            st.push(c);
        }
        return st.peek() == 't' ? true : false;
    }

    // O(chars.length) at worst case and constant at best case
    private char parse(char operator, List<Character> chars) {
        if (operator == '!') {
            return chars.get(0) == 't' ? 'f' : 't';
        }
        if (operator == '|') {
            // if any one true seen,result will be true
            for (char c : chars) {
                if (c == 't') {
                    return 't';
                }
            }
            return 'f';
        }
        if (operator == '&') {
            // if any one false seen,result will be false
            for (char c : chars) {
                if (c == 'f') {
                    return 'f';
                }
            }
            return 't';
        }
        return 'f';
    }

    public static void main(String[] args) {
        ParsingBooleanExpression obj = new ParsingBooleanExpression();
        String expression = "!(&(f,t))";
        System.out.println(obj.parseBoolExpr(expression));
    }
}

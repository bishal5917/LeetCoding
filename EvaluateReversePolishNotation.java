import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    Stack<String> st = new Stack<>();

    public int evalRPN(String[] tokens) {
        HashSet<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        // Now lets keep checking and keep adding the value
        for (String token : tokens) {
            if (operators.contains(token)) {
                // evaluate
                int a = Integer.valueOf(st.pop());
                int b = Integer.valueOf(st.pop());
                eval(token, a, b);
            } else {
                st.push(token);
            }
        }
        return Integer.valueOf(st.pop());
    }

    private void eval(String operator, int a, int b) {
        if (operator.equals("+")) {
            int val = b + a;
            st.push(String.valueOf(val));
        } else if (operator.equals("-")) {
            int val = b - a;
            st.push(String.valueOf(val));
        } else if (operator.equals("*")) {
            int val = b * a;
            st.push(String.valueOf(val));
        } else {
            int val = b / a;
            st.push(String.valueOf(val));
        }
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.println(obj.evalRPN(tokens));
    }
}

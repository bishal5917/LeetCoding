import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i = 0;// for push
        int j = 0;// for pop
        // Now lets do operations
        while (i < pushed.length && j < popped.length) {
            if (st.empty()) {
                // if empty just push
                if (pushed[i] == popped[j]) {
                    i += 1;
                    j += 1;
                } else {
                    st.push(pushed[i]);
                    i += 1;
                }
            } else {
                if (pushed[i] == popped[j]) {
                    st.push(pushed[i]);
                    st.pop();
                    i += 1;
                    j += 1;
                } else if (pushed[i] != popped[j]) {
                    // check if theres possible to pop from the stack
                    if (popped[j] == st.peek()) {
                        while (!st.isEmpty() && popped[j] == st.peek()) {
                            st.pop();
                            j += 1;
                        }
                    }
                    st.push(pushed[i]);
                    i += 1;
                    if (i == pushed.length) {
                        break;
                    }
                }
            }
        }
        // System.out.println(st);
        // System.out.println(i + " and " + j);
        while (j < popped.length) {
            if (st.isEmpty() || st.peek() != popped[j]) {
                break;
            }
            if (st.peek() == popped[j]) {
                st.pop();
                j += 1;
            }
        }
        // System.out.println(st);
        return st.size() == 0;
    }

    public static void main(String[] args) {
        ValidateStackSequences obj = new ValidateStackSequences();
        int[] pushed = { 1, 2, 3, 4, 5 };
        int[] popped = { 5, 4, 3, 2, 1 };
        System.out.println(obj.validateStackSequences(pushed, popped));
    }
}

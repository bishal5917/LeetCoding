import java.util.Arrays;
import java.util.LinkedList;

public class LongestValidParantheses {

    public int longestValidParentheses(String s) {
        int n = s.length();
        int longest = 0;
        boolean[] valid = new boolean[n];
        LinkedList<Integer> st = new LinkedList<>();
        // we go turn by turn
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                // just simply push the idx
                st.push(i);
            } else {
                // else we check the previous is closing or not
                if (!st.isEmpty() && s.charAt(st.peek()) == '(') {
                    int prev = st.pop();
                    // mark them true/valid
                    valid[prev] = true;
                    valid[i] = true;
                } else {
                    st.push(i);
                }
            }
        }
        // now time to return the length of substring
        if (st.isEmpty()) {
            // means all valid
            return s.length();
        }
        System.out.println(Arrays.toString(valid));
        // Now how to find the length of the substring
        // Now lets count the consecutive trues
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (valid[i]) {
                count += 1;
                longest = Math.max(count, longest);
            } else {
                // else reset the count
                count = 0;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestValidParantheses obj = new LongestValidParantheses();
        String s = ")()())";
        System.out.println(obj.longestValidParentheses(s));
    }
}

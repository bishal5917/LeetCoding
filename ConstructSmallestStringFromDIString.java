import java.util.Stack;

public class ConstructSmallestStringFromDIString {

    public String smallestNumber(String pattern) {
        // Lets make use of a stack,
        // keep adding and if found I or reached the end,pop and add to ans
        StringBuilder str = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= pattern.length(); i++) {
            st.add(i + 1);
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                // Now add to the answer
                while (!st.isEmpty()) {
                    str.append(String.valueOf(st.pop()));
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ConstructSmallestStringFromDIString obj = new ConstructSmallestStringFromDIString();
        String pattern = "IIIDIDDD";
        System.out.println(obj.smallestNumber(pattern));
    }
}

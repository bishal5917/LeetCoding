import java.util.Stack;

//lets create a custom class to store the count
class MyChar {
    char ch;
    int count;

    MyChar(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

public class RemoveAllAdjacentDuplicatesInStringII {

    public String removeDuplicates(String s, int k) {
        // And the stack
        Stack<MyChar> st = new Stack<>();
        // Now lets perform operations
        for (char c : s.toCharArray()) {
            if (st.isEmpty() || st.peek().ch != c) {
                // then just add new char
                st.push(new MyChar(c, 1));
            } else if (!st.isEmpty() && st.peek().ch == c) {
                // if we found the same just add
                st.peek().count = st.peek().count + 1;
            }
            // Now check if we have same consecutive limit
            if (st.peek().count == k) {
                st.pop();
            }
        }
        System.out.println(st);
        StringBuilder str = new StringBuilder();
        // Now iterate and just add to the stringbuilder
        for (MyChar c : st) {
            for (int i = 0; i < c.count; i++) {
                // append c that many times
                str.append(c.ch);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        // pbbcggttciiippooaais,k=2
        // ps
        RemoveAllAdjacentDuplicatesInStringII obj = new RemoveAllAdjacentDuplicatesInStringII();
        String s = "yffffbgffffgbbbbgssssgthyyyy";
        int k = 4;
        System.out.println(obj.removeDuplicates(s, k));
    }
}

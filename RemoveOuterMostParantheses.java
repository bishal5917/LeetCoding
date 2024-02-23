public class RemoveOuterMostParantheses {

    public String removeOuterParentheses(String s) {
        // lets take a counter
        int count = 0;
        // Our stringbuilder
        StringBuilder str = new StringBuilder();
        boolean canAdd = false;
        // Now iterate and put logic
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count += 1;
            } else {
                count -= 1;
            }
            // Now lets decide which to add and which not to add
            if (count == 2 && c == '(') {
                canAdd = true;
            } else if (count == 0 && c == ')') {
                canAdd = false;
            }
            if (canAdd) {
                str.append(c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        RemoveOuterMostParantheses obj = new RemoveOuterMostParantheses();
        String s = "(()())(())";
        System.out.println(obj.removeOuterParentheses(s));
    }
}

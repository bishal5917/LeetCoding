
public class MinimumRemoveToMakeValidParantheses {

    public String minRemoveToMakeValid(String s) {
        StringBuilder str = new StringBuilder();
        // checking the string
        int openCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount += 1;
            } else if (c == ')') {
                if (openCount == 0) {
                    // if we have no open previously,remove the closing one(Dont append it)
                    continue;
                }
                openCount -= 1;
            }
            str.append(c);
        }

        // Now we gotta check from backwards if our open isnot 0,to remove excess
        // opening braces
        if (openCount == 0)
            return str.toString();
        // Now if there are excess opening,gotta remove them
        StringBuilder newStr = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '(' && openCount > 0) {
                openCount -= 1;
                continue;
            }
            newStr.append(str.charAt(i));
        }
        return newStr.reverse().toString();
    }

    public static void main(String[] args) {
        MinimumRemoveToMakeValidParantheses obj = new MinimumRemoveToMakeValidParantheses();
        String s = "lee(t(c)o)de)";
        System.out.println(obj.minRemoveToMakeValid(s));
    }
}
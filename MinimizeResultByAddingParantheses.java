public class MinimizeResultByAddingParantheses {

    char plus = '+';
    char open = '(';
    char closed = ')';

    public String minimizeResult(String expression) {
        String minValString = "";
        long currMinVal = Integer.MAX_VALUE;
        StringBuilder str = new StringBuilder(expression);
        // PLACING BRACKETS FROM THE RIGHT
        for (int j = str.length(); j >= 0; j--) {
            if (j < str.length() && str.charAt(j) == plus) {
                break;
            }
            if (j - 1 >= 0 && str.charAt(j - 1) == plus) {
                break;
            }
            str.insert(j, closed);
            // PLACING BRACKETS FROM THE LEFT
            for (int i = 0; i < str.length(); i++) {
                // we place left brackets here
                if (str.charAt(i) == plus) {
                    break;
                }
                str.insert(i, open);
                // We check if this is the minimum expression
                long res = evalExpression(str, i, j + 1);
                if (res < currMinVal) {
                    currMinVal = res;
                    minValString = str.toString();
                }
                // Undo the bracket added
                str.deleteCharAt(i);
            }
            // Undo the bracket added
            str.deleteCharAt(j);
        }
        return minValString;
    }

    private long evalExpression(StringBuilder str, int openIdx, int closedIdx) {
        long ans = 1;
        // Lets find prod before bracket first
        int idx = 0;
        String leftPart = "";
        String rightPart = "";
        // Lets process left and right part first
        // *** LEFT PART
        while (idx < openIdx) {
            leftPart += str.charAt(idx++);
        }
        if (!leftPart.isEmpty()) {
            // add to ans
            ans *= Long.valueOf(leftPart);
        }
        // *** RIGHT PART
        idx = closedIdx + 1;
        while (idx < str.length()) {
            rightPart += str.charAt(idx++);
        }
        if (!rightPart.isEmpty()) {
            // add to ans
            ans *= Long.valueOf(rightPart);
        }
        // Now its time for the middle part,i.e between brackets
        String beforePlus = "";
        String afterPlus = "";
        idx = openIdx + 1;
        while (idx < str.length()) {
            if (str.charAt(idx) == plus) {
                break;
            }
            beforePlus += str.charAt(idx++);
        }
        idx++;
        while (idx < str.length()) {
            if (str.charAt(idx) == closed) {
                break;
            }
            afterPlus += str.charAt(idx++);
        }
        // Now we add beforePlus and afterPlus and product with ans
        long sum = 0;
        sum += Long.valueOf(beforePlus);
        sum += Long.valueOf(afterPlus);
        ans *= Long.valueOf(sum);
        return ans;
    }

    public static void main(String[] args) {
        MinimizeResultByAddingParantheses obj = new MinimizeResultByAddingParantheses();
        String expression = "247+38";
        System.out.println(obj.minimizeResult(expression));
    }
}

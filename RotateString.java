public class RotateString {

    public boolean rotateString(String s, String goal) {
        // check if lengths are equal or not
        if (s.length() != goal.length()) {
            return false;
        }
        // Lets do this by concatenation
        StringBuilder sbr = new StringBuilder();
        sbr.append(s);
        sbr.append(s);
        int i = 0;
        int j = 0;
        while (i < sbr.length()) {
            if (sbr.charAt(i) == goal.charAt(j)) {
                j++;
                if (j == goal.length()) {
                    return true;
                }
            } else {
                i = i - j;
                j = 0;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        RotateString obj = new RotateString();
        String s = "defdefdefabcabc";
        String goal = "defdefabcabcdef";
        System.out.println(obj.rotateString(s, goal));
    }
}

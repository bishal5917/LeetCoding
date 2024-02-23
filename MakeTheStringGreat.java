import java.util.Stack;

public class MakeTheStringGreat {

    public String makeGood(String s) {
        // Lets create a stack first
        Stack<Character> chars = new Stack<>();
        for (char c : s.toCharArray()) {
            if (chars.isEmpty()) {
                chars.push(c);
                continue;
            }

            if (!chars.isEmpty()) {
                int sTopAscii = (int) c;
                int currAscii = (int) chars.peek();
                int diff = Math.abs(sTopAscii - currAscii);
                // Difference between lowercase and uppercase ASCII val is 32
                if (diff == 32) {
                    chars.pop();
                } else {
                    chars.push(c);
                }
            }
        }
        if (chars.isEmpty())
            return "";
        // Now create a stringbuilder to return string
        StringBuilder res = new StringBuilder();
        for (char c : chars) {
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "leEeetcode";
        MakeTheStringGreat obj = new MakeTheStringGreat();
        System.out.println(obj.makeGood(s));
    }

}

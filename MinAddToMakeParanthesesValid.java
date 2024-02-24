import java.util.Stack;

public class MinAddToMakeParanthesesValid {

    public int minAddToMakeValid(String s) {
        Stack<Character> parans = new Stack<>();
        // Lets just iterate and put some logic
        for (char c : s.toCharArray()) {
            if (parans.isEmpty()) {
                parans.push(c);
                continue;
            }
            if (!parans.isEmpty()) {
                if (c == ')' && parans.peek() == '(') {
                    parans.pop();
                } else {
                    parans.push(c);
                }
            }

        }
        return parans.size();
    }

    public static void main(String[] args) {
        String s = "()))((";
        MinAddToMakeParanthesesValid obj = new MinAddToMakeParanthesesValid();
        System.out.println(obj.minAddToMakeValid(s));
    }
}

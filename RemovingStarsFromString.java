import java.util.Stack;

public class RemovingStarsFromString {

    public String removeStars(String s) {
        Stack<Character> chars = new Stack<>();
        // Lets iterate and keep putting in the chars
        for (char c : s.toCharArray()) {
            if (chars.isEmpty() && c == '*') {
                chars.push(c);
                continue;
            }
            if (!chars.isEmpty() && c == '*') {
                chars.pop();
            } else {
                chars.add(c);
            }
        }
        // Now add to the stringbuilder
        StringBuilder str = new StringBuilder();
        for (char c : chars) {
            str.append(c);
        }
        System.out.println(chars);
        return str.toString();
    }

    public static void main(String[] args) {
        RemovingStarsFromString obj = new RemovingStarsFromString();
        String s = "leet**cod*e";
        System.out.println(obj.removeStars(s));
    }

}

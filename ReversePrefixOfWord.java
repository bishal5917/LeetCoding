
public class ReversePrefixOfWord {

    public String reversePrefix(String word, char ch) {
        StringBuilder str = new StringBuilder();
        for (char c : word.toCharArray()) {
            str.append(c);
        }
        // Now iterate till we find it to find the last idx
        int l = 0;
        int r = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                r = i;
                break;
            }
        }
        // Now reverse between l and r
        while (l < r) {
            char temp = str.charAt(l);
            str.setCharAt(l, str.charAt(r));
            str.setCharAt(r, temp);
            l += 1;
            r -= 1;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ReversePrefixOfWord obj = new ReversePrefixOfWord();
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(obj.reversePrefix(word, ch));
    }
}
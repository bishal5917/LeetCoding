
public class ReverseWordsInString {

    public String reverseWords(String s) {
        // Lets do the oldskool way without caring about the space
        StringBuilder reversed = new StringBuilder();
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            reversed.append(reverseString(str[i]));
            if (i != str.length - 1) {
                reversed.append(" ");
            }
        }
        // System.out.println(Arrays.toString(str));
        return reversed.toString();
    }

    private String reverseString(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            str.append(s.charAt(i));
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            // Now just swap left and right
            char temp = str.charAt(l);
            str.setCharAt(l, str.charAt(r));
            str.setCharAt(r, temp);
            l += 1;
            r -= 1;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInString obj = new ReverseWordsInString();
        String s = "Let's take LeetCode contest";
        System.out.println(obj.reverseWords(s));
    }

}

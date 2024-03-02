public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            str.append(s.charAt(i));
        }
        // Now just go on and check
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (Character.isAlphabetic(s.charAt(i)) && Character.isAlphabetic(s.charAt(j))) {
                // then swap
                char ch = s.charAt(i);
                str.setCharAt(i, str.charAt(j));
                str.setCharAt(j, ch);
                i += 1;
                j -= 1;
            } else if (Character.isAlphabetic(s.charAt(i))) {
                j -= 1;
            } else {
                i += 1;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ReverseOnlyLetters obj = new ReverseOnlyLetters();
        String s = "a-bC-dEf-ghIj";
        System.out.println(obj.reverseOnlyLetters(s));
    }

}

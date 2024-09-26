public class ReplaceAllDigitsWithCharacters {

    public String replaceDigits(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            char curr = s.charAt(i);
            int shiftIdx = Character.getNumericValue(s.charAt(i + 1)); // Get numeric value of the digit
            str.append(curr);
            str.append((char) (curr + shiftIdx));
            i++;
        }
        // if the length was odd, gotta append the last character also
        if (s.length() % 2 != 0) {
            str.append(s.charAt(s.length() - 1));
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ReplaceAllDigitsWithCharacters obj = new ReplaceAllDigitsWithCharacters();
        String s = "a1c1e1";
        System.out.println(obj.replaceDigits(s));
    }
}

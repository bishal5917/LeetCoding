
public class NumberOfSubstringsWithAllThreeCharacters {

    public int numberOfSubstrings(String s) {
        int count = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        // Using the sliding window left and right pointers
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (a > 0 && b > 0 && c > 0) {
                count = count + s.length() - j + 1;
                // remove the character at i and slide the window
                if (s.charAt(i) == 'a') {
                    a -= 1;
                } else if (s.charAt(i) == 'b') {
                    b -= 1;
                } else {
                    c -= 1;
                }
                i += 1;
            } else {
                if (j < s.length()) {
                    if (s.charAt(j) == 'a') {
                        a += 1;
                    } else if (s.charAt(j) == 'b') {
                        b += 1;
                    } else {
                        c += 1;
                    }
                    j += 1;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfSubstringsWithAllThreeCharacters obj = new NumberOfSubstringsWithAllThreeCharacters();
        String s = "abcabc";
        System.out.println(obj.numberOfSubstrings(s));
    }
}

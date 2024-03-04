
public class AppendCharactersToMakeSubsequences {

    public int appendCharacters(String s, String t) {
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i += 1;
                j += 1;
            } else {
                i += 1;
            }

        }
        count += t.length() - j;
        return count;
    }

    public static void main(String[] args) {
        AppendCharactersToMakeSubsequences obj = new AppendCharactersToMakeSubsequences();
        String s = "coaching";
        String t = "coding";
        System.out.println(obj.appendCharacters(s, t));
    }
}
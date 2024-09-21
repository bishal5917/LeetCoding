public class NumberOfStringsThatAppearAsSubstrings {

    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfStringsThatAppearAsSubstrings obj = new NumberOfStringsThatAppearAsSubstrings();
        String[] patterns = { "a", "abc", "bc", "d" };
        String word = "abc";
        System.out.println(obj.numOfStrings(patterns, word));
    }
}

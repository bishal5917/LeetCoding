public class CountPrefixesOfString {

    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for (String str : words) {
            if (s.startsWith(str)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrefixesOfString obj = new CountPrefixesOfString();
        String[] words = { "a", "b", "c", "ab", "bc", "abc" };
        String s = "abc";
        System.out.println(obj.countPrefixes(words, s));
    }
}

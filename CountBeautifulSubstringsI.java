import java.util.HashSet;

public class CountBeautifulSubstringsI {

    public int beautifulSubstrings(String s, int k) {
        int count = 0;
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for (int i = 0; i < s.length(); i++) {
            int vs = 0;
            int cs = 0;
            for (int j = i; j < s.length(); j++) {
                // time to count
                if (vowels.contains(s.charAt(j))) {
                    vs++;
                } else {
                    cs++;
                }
                // check if condition satisfies
                if (vs == cs && (vs * cs) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountBeautifulSubstringsI obj = new CountBeautifulSubstringsI();
        String s = "baeyh";
        int k = 2;
        System.out.println(obj.beautifulSubstrings(s, k));
    }
}

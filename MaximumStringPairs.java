public class MaximumStringPairs {

    public int maximumNumberOfStringPairs(String[] words) {
        // Lets just use a double for loop (GAVE ME 2ms runtime)
        int count = 0;
        for (String word_i : words) {
            for (String word_j : words) {
                if (word_i.charAt(0) != word_j.charAt(0) && word_i.charAt(0) == word_j.charAt(1)
                        && word_i.charAt(1) == word_j.charAt(0)) {
                    count += 1;
                }
            }
        }
        // gotta return half the count because we will count twice haha
        return count / 2;
    }

    public static void main(String[] args) {
        MaximumStringPairs obj = new MaximumStringPairs();
        String[] words = { "cd", "ac", "dc", "ca", "zz" };
        System.out.println(obj.maximumNumberOfStringPairs(words));
    }

}

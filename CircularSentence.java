public class CircularSentence {

    public boolean isCircularSentence(String sentence) {
        String[] splitted = sentence.split(" ");
        for (int i = 0; i < splitted.length; i++) {
            String curr = splitted[i];
            String next = ((i == splitted.length - 1) ? splitted[0] : splitted[i + 1]);
            if (curr.charAt(curr.length() - 1) != next.charAt(0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CircularSentence obj = new CircularSentence();
        String sentence = "leetcode exercises sound delightful";
        System.out.println(obj.isCircularSentence(sentence));
    }
}

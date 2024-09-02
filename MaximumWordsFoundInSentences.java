public class MaximumWordsFoundInSentences {

    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            String[] sents = sentence.split(" ");
            max = Math.max(sents.length, max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumWordsFoundInSentences obj = new MaximumWordsFoundInSentences();
        String[] sentences = { "alice and bob love leetcode", "i think so too", "this is great thanks very much" };
        System.out.println(obj.mostWordsFound(sentences));
    }
}

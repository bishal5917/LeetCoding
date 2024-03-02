import java.util.Arrays;

public class CheckIfAWordOccursAsPrefix {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] sentnce = sentence.split(" ");
        int idx = -1;
        // Now lets iterate and keep checking
        for (int i = 0; i < sentnce.length; i++) {
            if (sentnce[i].startsWith(searchWord)) {
                idx = i + 1;
                break;
            }
        }
        System.out.println(Arrays.toString(sentnce));
        return idx;
    }

    public static void main(String[] args) {
        CheckIfAWordOccursAsPrefix obj = new CheckIfAWordOccursAsPrefix();
        String sentence = "i am tired";
        String searchWord = "ti";
        System.out.println(obj.isPrefixOfWord(sentence, searchWord));
    }

}

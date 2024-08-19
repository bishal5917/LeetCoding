import java.util.HashSet;

public class CheckIfSentenceIsPangram {

    public boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : sentence.toCharArray()) {
            set.add(ch);
        }
        return set.size() == 26;
    }

    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        CheckIfSentenceIsPangram obj = new CheckIfSentenceIsPangram();
        System.out.println(obj.checkIfPangram(sentence));
    }
}

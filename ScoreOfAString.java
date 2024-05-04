public class ScoreOfAString {

    public int scoreOfString(String s) {
        int score = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int asciiA = (int) s.charAt(i);
            int asciiB = (int) s.charAt(i + 1);
            score += Math.abs(asciiA - asciiB);
        }
        return score;
    }

    public static void main(String[] args) {
        ScoreOfAString obj = new ScoreOfAString();
        String s = "hello";
        System.out.println(obj.scoreOfString(s));
    }
}
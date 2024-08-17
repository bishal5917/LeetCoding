public class VowelGameInAString {

    public boolean doesAliceWin(String s) {
        int vowels = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            }
        }
        if (vowels > 0) {
            // this case alice wins
            // if its odd,she can take it all
            // if its even, she can remove n-1 and leave 1
            // and bob wont be able to remove any on his turn
            return true;
        } else {
            // else bob wins
            // if its 0 then alice cant play
            return false;
        }
    }

    public static void main(String[] args) {
        VowelGameInAString obj = new VowelGameInAString();
        String s = "leetcoder";
        System.out.println(obj.doesAliceWin(s));
    }
}

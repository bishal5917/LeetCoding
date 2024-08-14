public class FaultyKeyboard {

    public String finalString(String s) {
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                str.reverse();
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        FaultyKeyboard obj = new FaultyKeyboard();
        String s = "string";
        System.out.println(obj.finalString(s));
    }
}

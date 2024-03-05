public class AddingSpacesToString {

    public String addSpaces(String s, int[] spaces) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < s.length() && j < spaces.length) {
            if (i == spaces[j]) {
                str.append(" ");
                str.append(s.charAt(i));
                i += 1;
                j += 1;
            } else {
                str.append(s.charAt(i));
                i += 1;
            }
        }

        while (i < s.length()) {
            str.append(s.charAt(i));
            i += 1;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        AddingSpacesToString obj = new AddingSpacesToString();
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = { 8, 13, 15 };
        System.out.println(obj.addSpaces(s, spaces));
    }
}

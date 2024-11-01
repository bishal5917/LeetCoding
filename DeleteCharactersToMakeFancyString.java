public class DeleteCharactersToMakeFancyString {

    public String makeFancyString(String s) {
        StringBuilder sbr = new StringBuilder();
        int l = 0;
        int r = 1;
        while (r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                sbr.append(s.charAt(l));
                l++;
                r++;
            } else {
                int count = 0;
                while (r < s.length() && s.charAt(l) == s.charAt(r)) {
                    count++;
                    if (count < 2) {
                        sbr.append(s.charAt(l));
                    }
                    l++;
                    r++;
                }
            }
        }
        // adding the last remaining one
        sbr.append(s.charAt(s.length() - 1));
        return sbr.toString();
    }

    public static void main(String[] args) {
        DeleteCharactersToMakeFancyString obj = new DeleteCharactersToMakeFancyString();
        String s = "aaabaaaaaab";
        System.out.println(obj.makeFancyString(s));
    }
}


public class LongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) != typed.charAt(j)) {
                return false;
            } else {
                char currChar = name.charAt(i);
                if (i + 1 < name.length() && name.charAt(i + 1) == currChar) {
                    i += 1;
                    j += 1;
                    continue;
                }
                while (j < typed.length() && typed.charAt(j) == currChar) {
                    j += 1;
                }
                i += 1;
            }
        }
        System.out.println(i);
        System.out.println(j);
        return i != name.length() || j != typed.length() ? false : true;
    }

    public static void main(String[] args) {
        LongPressedName obj = new LongPressedName();
        String name = "alexd";
        String typed = "ale";
        System.out.println(obj.isLongPressedName(name, typed));
    }
}

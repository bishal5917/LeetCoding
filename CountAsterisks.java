
public class CountAsterisks {

    public int countAsterisks(String s) {
        int count = 0;
        boolean isOpened = false;
        int i = 0;
        while (i < s.length()) {
            boolean canCount = !isOpened && s.charAt(i) == '*';
            if (canCount) {
                count++;
            }
            if (s.charAt(i) == '|') {
                isOpened = !isOpened;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountAsterisks obj = new CountAsterisks();
        String s = "l|*e*et|c**o|*de|";
        System.out.println(obj.countAsterisks(s));
    }
}
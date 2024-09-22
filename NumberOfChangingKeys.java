public class NumberOfChangingKeys {

    public int countKeyChanges(String s) {
        int changes = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            String curr = String.valueOf(s.charAt(i));
            String next = String.valueOf(s.charAt(i + 1));
            if (!curr.toLowerCase().equals(next.toLowerCase())) {
                changes++;
            }
        }
        return changes;
    }

    public static void main(String[] args) {
        NumberOfChangingKeys obj = new NumberOfChangingKeys();
        String s = "aAbBcC";
        System.out.println(obj.countKeyChanges(s));
    }
}

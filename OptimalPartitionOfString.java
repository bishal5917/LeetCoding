import java.util.HashSet;

public class OptimalPartitionOfString {

    public int partitionString(String s) {
        int count = 1;
        // Lets use a set
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                set = new HashSet<>();
                set.add(c);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        OptimalPartitionOfString obj = new OptimalPartitionOfString();
        String s = "abacaba";
        System.out.println(obj.partitionString(s));
    }
}

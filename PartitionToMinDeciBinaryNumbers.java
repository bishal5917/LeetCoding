public class PartitionToMinDeciBinaryNumbers {

    public int minPartitions(String n) {
        int maxNum = 0;
        for (char c : n.toCharArray()) {
            int digit = Integer.valueOf(String.valueOf(c));
            maxNum = Math.max(maxNum, digit);
        }
        return maxNum;
    }

    public static void main(String[] args) {
        PartitionToMinDeciBinaryNumbers obj = new PartitionToMinDeciBinaryNumbers();
        String n = "32";
        System.out.println(obj.minPartitions(n));
    }
}

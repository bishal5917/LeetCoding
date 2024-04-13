public class FindValueAfterOperations {

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String op : operations) {
            if (op.equals("--X") || op.equals("X--")) {
                x -= 1;
            } else {
                x += 1;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        FindValueAfterOperations obj = new FindValueAfterOperations();
        String[] operations = { "--X", "X++", "X++" };
        System.out.println(obj.finalValueAfterOperations(operations));
    }

}

public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        int row = 0;
        int col = 0;
        // Now we check the moves
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                row--;
            } else if (c == 'D') {
                row++;
            } else if (c == 'L') {
                col--;
            } else if (c == 'R') {
                col++;
            }
        }
        return row == 0 && col == 0;
    }

    public static void main(String[] args) {
        RobotReturnToOrigin obj = new RobotReturnToOrigin();
        String moves = "UDUD";
        System.out.println(obj.judgeCircle(moves));
    }
}

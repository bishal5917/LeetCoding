import java.util.ArrayList;
import java.util.List;

public class QueensThatCanAttackTheKing {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // Lets create a board and place queens
        int[][] board = new int[8][8];
        for (int[] queen : queens) {
            int x = queen[0];
            int y = queen[1];
            board[x][y] = 1;
        }
        List<List<Integer>> attackers = new ArrayList<>();
        // Now starting from the king we go all 8 dirs
        int[][] dirs = {
                { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 },
                { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 },
        };
        for (int[] dir : dirs) {
            List<Integer> point = getQueen(board, king[0], king[1], dir[0], dir[1],
                    new ArrayList<>());
            if (point.size() != 0) {
                attackers.add(point);
            }
        }
        return attackers;
    }

    // Lets do this using recursion
    private List<Integer> getQueen(int[][] board, int r, int c, int x, int y,
            List<Integer> point) {
        if (r >= 8 || c >= 8 || r < 0 || c < 0) {
            return point;
        }
        if (board[r][c] == 1) {
            point.add(r);
            point.add(c);
            return point;
        }
        r += x;
        c += y;
        point = getQueen(board, r, c, x, y, point);
        return point;
    }

    public static void main(String[] args) {
        QueensThatCanAttackTheKing obj = new QueensThatCanAttackTheKing();
        int[][] queens = {
                { 0, 1 }, { 1, 0 }, { 4, 0 }, { 0, 4 }, { 3, 3 }, { 2, 4 }
        };
        int[] king = { 0, 0 };
        System.out.println(obj.queensAttacktheKing(queens, king));
    }
}

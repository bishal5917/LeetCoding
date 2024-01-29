import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BattleshipsInABoard {

    public int countBattleships(char[][] board) {
        return countbattleShipRecursiveHelper(board, 0, 0, new HashSet<>(), 0);
    }

    private int countbattleShipRecursiveHelper(char[][] board, int row, int col, Set<List<Integer>> visited,
            int count) {
        List<Integer> currRowCol = new ArrayList<>();
        currRowCol.add(row);
        currRowCol.add(col);
        if (row >= board.length || col >= board[0].length || row < 0 || col < 0 || visited.contains(currRowCol)) {
            return count;
        }
        boolean eval = row - 1 >= 0 && board[row - 1][col] == 'X' || col - 1 >= 0 && board[row][col - 1] == 'X';
        if (board[row][col] == 'X' && eval == false) {
            count += 1;
        }
        visited.add(currRowCol);
        count = countbattleShipRecursiveHelper(board, row, col + 1, visited, count);
        count = countbattleShipRecursiveHelper(board, row + 1, col, visited, count);
        count = countbattleShipRecursiveHelper(board, row, col - 1, visited, count);
        count = countbattleShipRecursiveHelper(board, row - 1, col, visited, count);
        return count;
    }

    public static void main(String[] args) {
        char[][] board = { { 'X', '.', '.', 'X' }, { '.', '.', '.', 'X' }, { '.', '.', '.', 'X' } };
        BattleshipsInABoard obj = new BattleshipsInABoard();
        System.out.println(obj.countBattleships(board));
    }
}

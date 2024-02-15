import java.util.ArrayList;
import java.util.List;

public class NQueensProblem {
    private static char QUEEN = 'Q';

    // N QUEENS
    public List<List<String>> solveNQueens(int n) {
        return solveNQueensRecursiveHelper(createChessBoard(n), 0, new ArrayList<>());
    }

    // N QUEENS II
    public int totalNQueens(int n) {
        return totalNQueensRecursiveHelper(createChessBoard(n), 0, 0);
    }

    private List<StringBuilder> createChessBoard(int n) {
        // CREATING A CHESSBOARD WITH ALL EMPTY
        List<StringBuilder> chess = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder chessRow = new StringBuilder();
            for (int j = 0; j < n; j++) {
                chessRow.append('.');
            }
            chess.add(chessRow);
        }
        return chess;
    }

    private List<List<String>> solveNQueensRecursiveHelper(List<StringBuilder> board, int row,
            List<List<String>> solution) {
        if (row == board.size()) {
            // means all rows are filled
            // append the value and return
            List<String> ans = new ArrayList<>();
            for (StringBuilder boardRow : board) {
                ans.add(boardRow.toString());
            }
            solution.add(ans);
            // LETS PRINT THE BOARD TO SEE THE SOLUTION
            System.out.println("*** SOLUTION ***");
            printBoard(board);
            return solution;
        }
        // for every row , basically checks every column
        for (int c = 0; c < board.size(); c++) {
            if (isValidHere(board, row, c)) {
                // place the queen
                StringBuilder curr = board.get(row);
                curr.setCharAt(c, QUEEN);
                // go for the next row
                solveNQueensRecursiveHelper(board, row + 1, solution);
                curr.setCharAt(c, '.');
            }
        }
        return solution;
    }

    // This method just returns the number of solutions found
    private int totalNQueensRecursiveHelper(List<StringBuilder> board, int row, int count) {
        if (row == board.size()) {
            // means all rows are filled
            // add the count and return
            count = count + 1;
            return count;
        }
        // for every row , basically checks every column
        for (int c = 0; c < board.size(); c++) {
            if (isValidHere(board, row, c)) {
                // place the queen
                StringBuilder curr = board.get(row);
                curr.setCharAt(c, QUEEN);
                // go for the next row
                count = totalNQueensRecursiveHelper(board, row + 1, count);
                curr.setCharAt(c, '.');
            }
        }
        return count;
    }

    // For validating if we can add given value at that position or not
    private boolean isValidHere(List<StringBuilder> board, int r, int c) {
        return !isAnyOtherOnRow(board, r, c) && !isAnyOtherOnCol(board, r, c)
                && !isAnyOtherOnTopLeftDiagonal(board, r, c) && !isAnyOtherOnBottomRightDiagonal(board, r, c)
                && !isAnyOtherOnTopRightDiagonal(board, r, c) && !isAnyOtherBottomLeftDiagonal(board, r, c);
    }

    // Basically checking if there is another QUEEN on the same row
    private boolean isAnyOtherOnRow(List<StringBuilder> board, int r, int c) {
        for (int idx = 0; idx < board.size(); idx++) {
            if (board.get(r).charAt(idx) == QUEEN) {
                return true;
            }
        }
        return false;
    }

    // Basically checking if there is another QUEEN on the same col
    private boolean isAnyOtherOnCol(List<StringBuilder> board, int r, int c) {
        for (int idx = 0; idx < board.size(); idx++) {
            if (board.get(idx).charAt(c) == QUEEN) {
                return true;
            }
        }
        return false;
    }

    // Basically checking if there is another QUEEN on the top left diagonal
    private boolean isAnyOtherOnTopLeftDiagonal(List<StringBuilder> board, int r, int c) {
        while (r < board.size() && c < board.size()) {
            if (board.get(r).charAt(c) == QUEEN) {
                return true;
            }
            r += 1;
            c += 1;
        }
        return false;
    }

    // Basically checking if there is another QUEEN on the bottom right diagonal
    private boolean isAnyOtherOnBottomRightDiagonal(List<StringBuilder> board, int r, int c) {
        while (r >= 0 && c >= 0) {
            if (board.get(r).charAt(c) == QUEEN) {
                return true;
            }
            r -= 1;
            c -= 1;
        }
        return false;
    }

    // Basically checking if there is another QUEEN on the top right diagonal
    private boolean isAnyOtherOnTopRightDiagonal(List<StringBuilder> board, int r, int c) {
        while (r >= 0 && c < board.size()) {
            if (board.get(r).charAt(c) == QUEEN) {
                return true;
            }
            r -= 1;
            c += 1;
        }
        return false;
    }

    // Basically checking if there is another QUEEN on the bottom left diagonal
    private boolean isAnyOtherBottomLeftDiagonal(List<StringBuilder> board, int r, int c) {
        while (r < board.size() && c >= 0) {
            if (board.get(r).charAt(c) == QUEEN) {
                return true;
            }
            r += 1;
            c -= 1;
        }
        return false;
    }

    private void printBoard(List<StringBuilder> board) {
        for (int i = 0; i < board.size(); i++) {
            StringBuilder row = board.get(i);
            for (int j = 0; j < row.length(); j++) {
                System.out.print(row.charAt(j) + "    ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        NQueensProblem obj = new NQueensProblem();
        obj.solveNQueens(n);
        int solution = obj.totalNQueens(n);
        System.out.println(solution);
    }
}

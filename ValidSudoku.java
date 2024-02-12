public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // check only if the board has a number
                if (board[i][j] != '.') {
                    boolean ans = isAnyOtherOnRow(board, i, j) || isAnyOtherOnCol(board, i, j)
                            || isThereAnyWhereOnGrid(board, i, j);
                    if (ans == true) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Basically checking if there is another value on same row
    private boolean isAnyOtherOnRow(char[][] board, int r, int c) {
        int val = board[r][c];
        for (int idx = 0; idx < 9; idx++) {
            if (board[r][idx] == val && idx != c) {
                return true;
            }
        }
        return false;
    }

    // Basically checking if there is another value on same col
    private boolean isAnyOtherOnCol(char[][] board, int r, int c) {
        int val = board[r][c];
        for (int idx = 0; idx < 9; idx++) {
            if (board[idx][c] == val && idx != r) {
                return true;
            }
        }
        return false;
    }

    // Basically checking if there is another value on that 3*3 box
    private boolean isThereAnyWhereOnGrid(char[][] board, int r, int c) {
        // find nearest to row and col first (AMONG 0,3 and 6)
        // must be nearest positive difference
        // SETTING THE START ROW
        int startRow;
        int startCol;
        if (r >= 0 && r < 3) {
            startRow = 0;
        } else if (r >= 3 && r < 6) {
            startRow = 3;
        } else {
            startRow = 6;
        }
        // SETTING THE START COLUMN
        if (c >= 0 && c < 3) {
            startCol = 0;
        } else if (c >= 3 && c < 6) {
            startCol = 3;
        } else {
            startCol = 6;
        }

        int val = board[r][c];
        for (int i = startRow; i <= startRow + 2; i++) {
            for (int j = startCol; j <= startCol + 2; j++) {
                if (board[i][j] == val && i != r && j != c) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidSudoku obj = new ValidSudoku();
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' },
        };
        System.out.println(obj.isValidSudoku(board));
    }
}

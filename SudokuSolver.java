import java.util.Arrays;

class SudokuSolver {

    public void solveSudoku(char[][] board) {
        sudokuSolver(board, 0, 0);
    }

    private boolean sudokuSolver(char[][] board, int r, int c) {
        if (r == 9) {
            // means solved,return true
            return true;
        }
        if (c == 9) {
            // go for next row
            return sudokuSolver(board, r + 1, 0);
        }
        if (board[r][c] != '.') {
            // means already filled,go for next row or column
            return sudokuSolver(board, r, c + 1);
        }
        // else try all possibilities
        for (char ch = '1'; ch <= '9'; ch++) {
            if (isValidHere(board, r, c, ch)) {
                // place if valid
                board[r][c] = ch;
                boolean isSolved = sudokuSolver(board, r, c + 1);
                if (isSolved) {
                    // if all solved,early exit
                    return isSolved;
                }
                board[r][c] = '.';
            }
        }
        // else return false
        return false;
    }

    // For validating if we can add given value at that position or not
    private boolean isValidHere(char[][] board, int r, int c, char digit) {
        return !isAnyOtherOnRow(board, r, c, digit) && !isAnyOtherOnCol(board, r, c, digit)
                && !isThereAnyWhereOnGrid(board, r, c, digit);
    }

    // Basically checking if there is another value on same row
    private boolean isAnyOtherOnRow(char[][] board, int r, int c, char digit) {
        for (int idx = 0; idx < 9; idx++) {
            if (board[r][idx] == digit && idx != c) {
                return true;
            }
        }
        return false;
    }

    // Basically checking if there is another value on same col
    private boolean isAnyOtherOnCol(char[][] board, int r, int c, char digit) {
        for (int idx = 0; idx < 9; idx++) {
            if (board[idx][c] == digit && idx != r) {
                return true;
            }
        }
        return false;
    }

    // Basically checking if there is another value on that 3*3 box
    private boolean isThereAnyWhereOnGrid(char[][] board, int r, int c, char digit) {
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

        for (int i = startRow; i <= startRow + 2; i++) {
            for (int j = startCol; j <= startCol + 2; j++) {
                if (board[i][j] == digit && i != r && j != c) {
                    return true;
                }
            }
        }
        return false;
    }

    // Just printing the board
    private void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void main(String[] args) {
        SudokuSolver obj = new SudokuSolver();
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        obj.solveSudoku(board);
        obj.printBoard(board);
    }
}
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        // int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (checkWordExistsHelper(board, word, i, j, 0)) {
                        return true;
                    }
                    // int returnedCount = checkWordHelper(board, word,
                    // new StringBuilder(board[i][j]), i, j, 0);
                    // count += returnedCount;
                    // if (count > 0) {
                    // return true;
                    // }
                }
            }
        }
        return false;
    }

    // More optimal way , returns if the word has been found
    private boolean checkWordExistsHelper(char[][] board, String word, int row, int col, int index) {

        if (index == word.length()) {
            // means entire word is found
            // just return
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        // save the current character
        char currChar = board[row][col];

        // Mark as visited
        board[row][col] = '0';

        // Then go all the direction
        boolean right = checkWordExistsHelper(board, word, row, col + 1, index + 1);
        boolean down = checkWordExistsHelper(board, word, row + 1, col, index + 1);
        boolean left = checkWordExistsHelper(board, word, row, col - 1, index + 1);
        boolean up = checkWordExistsHelper(board, word, row - 1, col, index + 1);

        // Backtrack
        // Set the character taken to the same character before
        board[row][col] = currChar;

        return right || down || left || up;
    }

    // Doesnot work for large boards
    // going through each and every possibilities and checking the string
    private int checkWordHelper(char[][] board, String word, StringBuilder curr, int row, int col, int count) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '0') {
            return count;
        }

        // add current char to our string builder
        char currChar = board[row][col];
        curr.append(currChar);

        if (word.equals(curr.toString())) {
            count += 1;
            return count;
        }

        // Mark as visited
        board[row][col] = '0';

        // Then go all the direction
        count = checkWordHelper(board, word, curr, row, col + 1, count);
        count = checkWordHelper(board, word, curr, row + 1, col, count);
        count = checkWordHelper(board, word, curr, row, col - 1, count);
        count = checkWordHelper(board, word, curr, row - 1, col, count);

        // Backtrack
        // Set the character taken to the same character before
        // Remove the character from the stringbuilder too
        curr.deleteCharAt(curr.length() - 1);
        board[row][col] = currChar;

        return count;
    }

    public static void main(String[] args) {
        WordSearch obj = new WordSearch();
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word = "ABCCED";
        boolean ans = obj.exist(board, word);
        System.out.println(ans);
    }

}

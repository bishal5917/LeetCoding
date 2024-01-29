
public class CountServersThatCommunicate {

    public int countServers(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (isThereAnyOtherServerOnSameRowOrColumn(grid, i, j)) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }

    private boolean isThereAnyOtherServerOnSameRowOrColumn(int[][] grid, int row, int col) {
        // Dont take into account if we encounter the same row&col
        // so we do c!=col and r!=row here
        for (int c = 0; c < grid[0].length; c++) {
            if (grid[row][c] == 1 && c != col) {
                return true;
            }
        }
        for (int r = 0; r < grid.length; r++) {
            if (grid[r][col] == 1 && r != row) {
                return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 1 }
        };
        CountServersThatCommunicate obj = new CountServersThatCommunicate();
        System.out.println(obj.countServers(grid));
    }
}

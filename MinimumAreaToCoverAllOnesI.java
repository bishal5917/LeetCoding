public class MinimumAreaToCoverAllOnesI {

    public int minimumArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int minRow = rows;
        int maxRow = 0;
        int minCol = cols;
        int maxCol = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        System.out.println(minRow + "-" + maxRow);
        System.out.println(minCol + "-" + maxCol);
        // we return area
        // area = length * breadth
        int length = maxRow - minRow + 1;
        int breadth = maxCol - minCol + 1;
        return length * breadth;
    }

    public static void main(String[] args) {
        MinimumAreaToCoverAllOnesI obj = new MinimumAreaToCoverAllOnesI();
        int[][] grid = {
                { 0, 1, 0 },
                { 1, 0, 1 }
        };
        System.out.println(obj.minimumArea(grid));
    }
}

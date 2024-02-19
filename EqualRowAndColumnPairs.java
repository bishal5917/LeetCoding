import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualRowAndColumnPairs {

    public int equalPairs(int[][] grid) {
        int count = 0;
        HashMap<Integer, List<Integer>> rowElementsMap = new HashMap<>();
        HashMap<Integer, List<Integer>> colElementsMap = new HashMap<>();
        // Lets generate hashmap for each and every pairs
        // for every elements in a row
        for (int i = 0; i < grid.length; i++) {
            List<Integer> rowElems = new ArrayList<>();
            for (int c = 0; c < grid[0].length; c++) {
                rowElems.add(grid[i][c]);
            }
            rowElementsMap.put(i, rowElems);
        }
        // for every elements in a column
        for (int i = 0; i < grid[0].length; i++) {
            List<Integer> colElems = new ArrayList<>();
            for (int r = 0; r < grid.length; r++) {
                colElems.add(grid[r][i]);
            }
            colElementsMap.put(i, colElems);
        }
        System.out.println(rowElementsMap);
        System.out.println(colElementsMap);
        // Now go for both maps one by one and check if the values list are equal
        for (Map.Entry<Integer, List<Integer>> rowEntry : rowElementsMap.entrySet()) {
            for (Map.Entry<Integer, List<Integer>> colEntry : colElementsMap.entrySet()) {
                if (rowElementsMap.get(rowEntry.getKey()).equals(colElementsMap.get(colEntry.getKey()))) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        EqualRowAndColumnPairs obj = new EqualRowAndColumnPairs();
        int[][] grid = {
                { 3, 2, 1 },
                { 1, 7, 6 },
                { 2, 7, 7 }
        };
        int ans = obj.equalPairs(grid);
        System.out.println(ans);
    }
}
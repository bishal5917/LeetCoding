import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllGroupsOfFarmland {

    public int[][] findFarmland(int[][] land) {
        List<List<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    List<Integer> groupCoordinates = new ArrayList<>(
                            Arrays.asList(i, j, Integer.MIN_VALUE, Integer.MIN_VALUE));
                    groups.add(traverseLandRecursiveHelper(land, i, j, groupCoordinates));
                }
            }
        }

        if (groups.size() == 0) {
            return new int[0][0];
        }
        // converting dynamic list to static list
        int numRows = groups.size();
        int numCols = groups.get(0).size();

        int[][] result = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = groups.get(i);
            for (int j = 0; j < numCols; j++) {
                result[i][j] = row.get(j);
            }
        }
        System.out.println(groups);
        return result;
    }

    private List<Integer> traverseLandRecursiveHelper(int[][] land, int row, int col,
            List<Integer> groupCoordinates) {
        if (row >= land.length || col >= land[0].length || row < 0 || col < 0 || land[row][col] == 0) {
            return groupCoordinates;
        }
        // Mark as visited once it is traversed (SET TO ZERO)
        land[row][col] = 0;
        // track the max coordinates for the group
        groupCoordinates.set(2, Math.max(row, groupCoordinates.get(2)));
        groupCoordinates.set(3, Math.max(col, groupCoordinates.get(3)));
        groupCoordinates = traverseLandRecursiveHelper(land, row, col + 1, groupCoordinates);
        groupCoordinates = traverseLandRecursiveHelper(land, row + 1, col, groupCoordinates);
        groupCoordinates = traverseLandRecursiveHelper(land, row, col - 1, groupCoordinates);
        groupCoordinates = traverseLandRecursiveHelper(land, row - 1, col, groupCoordinates);
        return groupCoordinates;
    }

    public static void main(String[] args) {
        int[][] land = {
                { 1, 0, 0 },
                { 0, 1, 1 },
                { 0, 1, 1 }
        };
        FindAllGroupsOfFarmland obj = new FindAllGroupsOfFarmland();
        System.out.println(obj.findFarmland(land));
    }
}

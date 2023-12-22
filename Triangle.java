import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dynamicSums = new ArrayList<>();
        // push the last array of the triangle
        List<Integer> allZeroes = new ArrayList<>();
        // adding zeroes
        for (int i = 0; i <= triangle.get(triangle.size() - 1).size(); i++) {
            allZeroes.add(0);
        }
        dynamicSums.add(allZeroes);
        // starting from the last value from an array
        int last = triangle.size() - 1;
        while (last >= 0) {
            List<Integer> dynamicVals = new ArrayList<>();
            List<Integer> currTriangleBase = triangle.get(last);
            List<Integer> lastSums = dynamicSums.get(dynamicSums.size() - 1);
            // System.out.println(lastSums);
            // System.out.println(currTriangleBase);
            for (int j = 0; j < currTriangleBase.size(); j++) {
                int leftChild = j;
                int rightChild = j + 1;
                int leftPartCost = lastSums.get(leftChild) + currTriangleBase.get(j);
                int rightPartCost = lastSums.get(rightChild) + currTriangleBase.get(j);
                dynamicVals.add(Math.min(leftPartCost, rightPartCost));
            }
            dynamicSums.add(dynamicVals);
            last -= 1;
        }
        System.out.println(dynamicSums.get(dynamicSums.size() - 1).get(0));
        return dynamicSums.get(dynamicSums.size() - 1).get(0);
    }

    public static void main(String[] args) {
        Triangle obj = new Triangle();
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3));
        obj.minimumTotal(triangle);
    }

}

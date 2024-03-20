import java.util.HashMap;

public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        int total = 0;
        // USING THE SLIDING WINDOW APPROACH
        int i = 0;
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (j < fruits.length) {
            // add to the map
            int nextFruit = fruits[j];
            if (map.get(nextFruit) == null) {
                map.put(nextFruit, 1);
            } else {
                map.put(nextFruit, map.get(nextFruit) + 1);
            }
            // If we are over than 2,reduce the size
            while (map.size() > 2) {
                int prevFruit = fruits[i];
                if (map.get(prevFruit) == 1) {
                    map.remove(prevFruit);
                } else {
                    map.put(prevFruit, map.get(prevFruit) - 1);
                }
                i += 1;
            }
            total = Math.max(total, j - i + 1);
            j += 1;
        }
        return total;
    }

    public static void main(String[] args) {
        FruitIntoBaskets obj = new FruitIntoBaskets();
        int[] fruits = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
        System.out.println(obj.totalFruit(fruits));
    }
}
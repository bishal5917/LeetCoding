import java.util.Arrays;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1) {
            return true;
        }
        // Lets keep placing flowers and check
        int prevFlowerIdx = -1;
        for (int i = 0; i < flowerbed.length; i++) {
            // if its already has a flower
            if (flowerbed[i] == 1) {
                prevFlowerIdx = i;
                continue;
            }
            // Now if its not the first
            // check if previously we have flower or not
            if (flowerbed[i] == 0) {
                if (i == 0 && i + 1 < flowerbed.length && flowerbed[i + 1] != 1) {
                    // means its the first
                    // add a flower
                    flowerbed[i] = 1;
                    prevFlowerIdx = i;
                    n -= 1;
                    continue;
                }
                if (i + 1 < flowerbed.length && prevFlowerIdx != i - 1 && flowerbed[i + 1] != 1) {
                    // means can plant
                    flowerbed[i] = 1;
                    n -= 1;
                    prevFlowerIdx = i;
                    continue;
                }
                if (prevFlowerIdx != i - 1 && i == flowerbed.length - 1) {
                    // means can plant
                    flowerbed[i] = 1;
                    n -= 1;
                    prevFlowerIdx = i;
                }
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        CanPlaceFlowers obj = new CanPlaceFlowers();
        int[] flowerbed = { 0, 0, 1, 0, 1 };
        int n = 1;
        System.out.println(Arrays.toString(flowerbed));
        System.out.println(obj.canPlaceFlowers(flowerbed, n));
        System.out.println(Arrays.toString(flowerbed));
    }
}

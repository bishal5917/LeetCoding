import java.util.Arrays;

public class TrappingRainWater {

    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        // Finding the maxLeft and maxRight
        int lm = 0;
        int rm = 0;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        for (int i = 0; i < n; i++) {
            // left max
            lm = Math.max(lm, height[i]);
            maxLeft[i] = lm;
            // right max
            rm = Math.max(rm, height[n - i - 1]);
            maxRight[n - i - 1] = rm;
        }
        System.out.println(Arrays.toString(maxLeft));
        System.out.println(Arrays.toString(maxRight));
        // Now lets collect the water
        // At any point,water is
        // water = Math.min(maxLeft[i],maxRight[i])-arr[i]
        for (int i = 0; i < n; i++) {
            water += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(obj.trap(height));
    }
}

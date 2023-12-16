public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int maxWaterArea = Integer.MIN_VALUE;

        int i = 0;
        int j = height.length - 1;

        while (i <= j) {
            int currentWaterArea = Math.min(height[i], height[j]) * (j - i);
            if (currentWaterArea > maxWaterArea) {
                maxWaterArea = currentWaterArea;
            }
            if (height[i] <= height[j]) {
                i += 1;
            } else {
                j -= 1;
            }
        }

        System.out.println(maxWaterArea);
        return maxWaterArea;
    }

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        ContainerWithMostWater obj = new ContainerWithMostWater();
        obj.maxArea(height);
    }

}

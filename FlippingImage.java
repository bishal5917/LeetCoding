
public class FlippingImage {

    public int[][] flipAndInvertImage(int[][] image) {

        for (int i = 0; i < image.length; i++) {
            int[] arr = flipAndInvert(image[i]);
            image[i] = arr;
        }

        System.out.println(image);
        return image;

    }

    public int[] flipAndInvert(int[] list) {

        int i = 0;
        int j = list.length - 1;

        while (i <= j) {
            int temp = list[i];
            list[i] = list[j];
            list[j] = temp;
            i += 1;
            j -= 1;
        }

        for (int elem = 0; elem < list.length; elem++) {
            if (list[elem] == 0) {
                list[elem] = 1;

            } else {
                list[elem] = 0;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
        FlippingImage obj = new FlippingImage();
        obj.flipAndInvertImage(nums);
    }
}

import java.util.Arrays;

public class KRadiusSubarrayAverages {

    public int[] getAverages(int[] nums, int k) {
        int[] avgs = new int[nums.length];
        // Now the k from the front and k from the back will have -1
        for (int i = 0; i < k; i++) {
            if (i < nums.length) {
                avgs[i] = -1;
                avgs[nums.length - 1 - i] = -1;
            } else {
                break;
            }
        }
        if (nums.length < k * 2 + 1) {
            return avgs;
        }
        // Now its known that we gotta slide the window but how to do this
        // Lets first maintain the first window
        // size will be k*2+1
        int i = 0;
        int j = 0;
        int idx = k;
        long sum = 0;
        long windowSize = k * 2 + 1;
        while (j < windowSize && j < nums.length) {
            sum += nums[j];
            j += 1;
        }
        avgs[idx++] = (int) (sum / windowSize);
        // NOW LETS SLIDE THE WINDOW FORWARD
        while (j < nums.length) {
            sum -= nums[i];
            sum += nums[j];
            avgs[idx++] = (int) (sum / windowSize);
            i += 1;
            j += 1;
        }
        return avgs;
    }

    public static void main(String[] args) {
        KRadiusSubarrayAverages obj = new KRadiusSubarrayAverages();
        int[] nums = { 7, 4, 3, 9, 1, 8, 5, 2, 6 };
        int k = 3;
        int[] ans = obj.getAverages(nums, k);
        System.out.println(Arrays.toString(ans));
    }
}

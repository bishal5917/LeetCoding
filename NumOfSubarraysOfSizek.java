public class NumOfSubarraysOfSizek {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int left = 0;
        int right = 0;
        int currsum = 0;
        while (right < k) {
            currsum += arr[right];
            right += 1;
        }
        // check if its greater than or equal to threshold
        if (currsum / k >= threshold) {
            count += 1;
        }
        // USING THE SLIDING WINDOW TECHNIQUE
        while (right < arr.length) {
            currsum = currsum + arr[right];
            currsum = currsum - arr[left];
            left += 1;
            right += 1;
            // checking if its greater than average
            if (currsum / k >= threshold) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumOfSubarraysOfSizek obj = new NumOfSubarraysOfSizek();
        int[] arr = { 2, 2, 2, 2, 5, 5, 5, 8 };
        System.out.println(obj.numOfSubarrays(arr, 3, 4));
    }
}

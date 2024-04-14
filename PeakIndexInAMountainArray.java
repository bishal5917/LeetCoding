public class PeakIndexInAMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        // Using the Binary search
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > arr[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        PeakIndexInAMountainArray obj = new PeakIndexInAMountainArray();
        int[] arr = { 0, 10, 5, 2 };
        System.out.println(obj.peakIndexInMountainArray(arr));
    }

}

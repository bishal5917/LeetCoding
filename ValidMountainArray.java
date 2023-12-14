public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        // lets find peak element first
        int isStrictlyIncreasing = 0;
        int isStrictlyDecreasing = 0;
        Boolean isPlateau = false;
        int peakElem = Integer.MIN_VALUE;
        int peakIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= peakElem) {
                peakElem = Math.max(peakElem, arr[i]);
                peakIdx = i;
            }
        }
        int midLeft = peakIdx;
        int midRight = peakIdx;
        int left = peakIdx - 1;
        int right = peakIdx + 1;

        while (left >= 0) {
            if (arr[left] < arr[midLeft]) {
                isStrictlyIncreasing += 1;
            } else if (arr[left] == arr[midLeft]) {
                isPlateau = true;
            }
            left = left - 1;
            midLeft = midLeft - 1;
        }
        while (right <= arr.length - 1) {
            if (arr[right] < arr[midRight]) {
                isStrictlyDecreasing += 1;
            } else if (arr[right] == arr[midRight]) {
                isPlateau = true;
            }
            right = right + 1;
            midRight = midRight + 1;
        }

        if (isPlateau == true) {
            return false;
        }
        if (isStrictlyIncreasing == 0 || isStrictlyDecreasing==0) {
            return false;
        }
        System.out.println(isStrictlyIncreasing);
        System.out.println(isStrictlyDecreasing);
        return isStrictlyIncreasing == peakIdx && isStrictlyDecreasing == arr.length - 1 - peakIdx ? true : false;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1 };
        ValidMountainArray obj = new ValidMountainArray();
        Boolean ans = obj.validMountainArray(arr);
        System.out.println(ans);
    }
}

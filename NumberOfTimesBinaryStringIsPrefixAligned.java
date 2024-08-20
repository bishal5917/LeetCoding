public class NumberOfTimesBinaryStringIsPrefixAligned {

    public int numTimesAllBlue(int[] flips) {
        int n = flips.length;
        int count = 0;
        int pivotIdx = 0;
        int onesLeft = 0;
        int zerosRight = n;
        for (int flip : flips) {
            pivotIdx = Math.max(pivotIdx, flip);
            onesLeft += 1;
            zerosRight -= 1;
            // Time to check if its prefix aligned
            if (onesLeft == pivotIdx && zerosRight == n - pivotIdx) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfTimesBinaryStringIsPrefixAligned obj = new NumberOfTimesBinaryStringIsPrefixAligned();
        int[] flips = { 3, 2, 4, 1, 5 };
        System.out.println(obj.numTimesAllBlue(flips));
    }
}

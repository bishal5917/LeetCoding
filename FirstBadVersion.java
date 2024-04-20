public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int first = 1;
        int last = n;
        int badOne = -1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            boolean isBad = isBadVersion(mid);
            if (isBad) {
                last = mid - 1;
                badOne = mid;
            } else {
                first = mid + 1;
            }
        }
        return badOne;
    }

    // THIS WILL BE GIVEN BY LEETCODE ITSELF
    private boolean isBadVersion(int version) {
        return version == version % 2;
    }

    public static void main(String[] args) {
        FirstBadVersion obj = new FirstBadVersion();
        System.out.println(obj.firstBadVersion(5));
    }
}

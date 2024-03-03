public class NeedleAndHaystack {

    // Lets try first with normal string matching technique
    // This is just my string matching technique algo,gave 1ms
    // To do this optimally,gotta do with KMP
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int findIdx = -1;
        int iTracker = -1;
        while (i < haystack.length() && j < needle.length()) {
            if (iTracker == -1) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    i += 1;
                } else {
                    iTracker = i;
                    i += 1;
                    j += 1;
                }
            } else {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    i = iTracker + 1;
                    j = 0;
                    iTracker = -1;
                } else {
                    i += 1;
                    j += 1;
                }
            }
            if (j == needle.length()) {
                findIdx = iTracker;
                break;
            }
        }
        return findIdx;
    }

    public static void main(String[] args) {
        NeedleAndHaystack obj = new NeedleAndHaystack();
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(obj.strStr(haystack, needle));
    }
}

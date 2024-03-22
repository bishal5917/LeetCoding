public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    public int minimumRecolors(String blocks, int k) {
        char white = 'W';
        int whites = 0;
        int res = Integer.MAX_VALUE;
        // Using the fixed sliding window approach
        int i = 0;
        int j = 0;
        while (j < k && j < blocks.length()) {
            if (blocks.charAt(j) == white) {
                whites += 1;
            }
            j += 1;
        }
        // Update the minimum
        res = Math.min(whites, res);
        // NOW LETS SLIDE THE WINDOW
        while (j < blocks.length()) {
            if (blocks.charAt(i) == white) {
                whites -= 1;
            }
            if (blocks.charAt(j) == white) {
                whites += 1;
            }
            i += 1;
            j += 1;
            res = Math.min(whites, res);
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumRecolorsToGetKConsecutiveBlackBlocks obj = new MinimumRecolorsToGetKConsecutiveBlackBlocks();
        String blocks = "WBBWWBBWBW";
        int k = 7;
        System.out.println(obj.minimumRecolors(blocks, k));
    }
}

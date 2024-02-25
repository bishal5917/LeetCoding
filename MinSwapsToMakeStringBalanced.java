public class MinSwapsToMakeStringBalanced {

    public int minSwaps(String s) {
        int maxClosingSoFar = -1;
        int curr = 0;
        for (char c : s.toCharArray()) {
            if (c == ']') {
                curr += 1;
                maxClosingSoFar = Math.max(maxClosingSoFar, curr);
            } else {
                curr -= 1;
            }
        }
        // because we add 1 and divide by 2 because one swap will cancel out the other
        return (maxClosingSoFar + 1) / 2;
    }

    public static void main(String[] args) {
        MinSwapsToMakeStringBalanced obj = new MinSwapsToMakeStringBalanced();
        String s = "]]][[[";
        System.out.println(obj.minSwaps(s));
    }
}

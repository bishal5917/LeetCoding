public class MaxNestingDepthOfParantheses {

    public int maxDepth(String s) {
        int maxDepth = Integer.MIN_VALUE;
        int leftEncounteredSoFar = 0;
        int rightEncounteredSoFar = 0;
        // lets just go and iterate and keep checking
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftEncounteredSoFar += 1;
            } else if (c == ')') {
                int currDepth = leftEncounteredSoFar - rightEncounteredSoFar;
                maxDepth = Math.max(maxDepth, currDepth);
                rightEncounteredSoFar += 1;
            } else {
                int currDepth = leftEncounteredSoFar - rightEncounteredSoFar;
                maxDepth = Math.max(maxDepth, currDepth);
            }
        }
        return maxDepth == Integer.MIN_VALUE ? 1 : maxDepth;
    }

    public static void main(String[] args) {
        MaxNestingDepthOfParantheses obj = new MaxNestingDepthOfParantheses();
        String s = "(1)+((2))+(((3)))";
        // String s = "(1())";
        System.out.println(obj.maxDepth(s));
    }
}

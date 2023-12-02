public class SmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int targetCode = (int) target;
        char currMinTarget = letters[0];
        int currMinCode = Integer.MAX_VALUE;
        System.out.println(targetCode);
        for (char item : letters) {
            int itemCode = (int) item;
            if (itemCode - target < currMinCode && itemCode - target > 0) {
                currMinCode = itemCode - target;
                currMinTarget = item;
            }
        }

        System.out.println(currMinCode);
        System.out.println(currMinTarget);

        return currMinTarget;
    }

    public static void main(String[] args) {
        SmallestLetterGreaterThanTarget obj = new SmallestLetterGreaterThanTarget();
        char[] letters = { 'c', 'f', 'j' };
        char target = 'g';
        obj.nextGreatestLetter(letters, target);
    }
}
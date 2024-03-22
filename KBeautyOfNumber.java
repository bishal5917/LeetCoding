public class KBeautyOfNumber {

    public int divisorSubstrings(int num, int k) {
        // Maintaining a fixed size window of k
        int count = 0;
        int j = 0;
        StringBuilder curr = new StringBuilder();
        String numStr = String.valueOf(num);
        while (j < k && j < numStr.length()) {
            curr.append(numStr.charAt(j));
            j += 1;
        }
        int val = Integer.valueOf(curr.toString());
        if (val != 0 && num % val == 0)
            count += 1;
        // NOW LETS SLIDE THE WINDOW
        while (j < numStr.length()) {
            curr.deleteCharAt(0);
            curr.append(numStr.charAt(j));
            val = Integer.valueOf(curr.toString());
            if (val != 0 && num % val == 0)
                count += 1;
            j += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        KBeautyOfNumber obj = new KBeautyOfNumber();
        int num = 430043;
        int k = 2;
        System.out.println(obj.divisorSubstrings(num, k));
    }
}
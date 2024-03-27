public class FindStudentThatWillReplaceChalk {

    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0l;
        for (int c : chalk) {
            sum += c;
        }
        sum = (int) (k % sum);
        // Now lets check
        for (int i = 0; i < chalk.length; i++) {
            if (sum < chalk[i]) {
                return i;
            }
            sum -= chalk[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        FindStudentThatWillReplaceChalk obj = new FindStudentThatWillReplaceChalk();
        int[] chalk = { 5, 1, 5 };
        int k = 22;
        System.out.println(obj.chalkReplacer(chalk, k));
    }
}

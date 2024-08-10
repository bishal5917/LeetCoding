public class NumberOfStepsToReduceNumberToZero {

    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num -= 1;
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        NumberOfStepsToReduceNumberToZero obj = new NumberOfStepsToReduceNumberToZero();
        int num = 10;
        System.out.println(obj.numberOfSteps(num));
    }
}

public class CountOperationsToObtainZero {

    public int countOperations(int num1, int num2) {
        // lets do this recursively
        return countOpsRecursiveHelper(num1, num2, 0);
    }

    private int countOpsRecursiveHelper(int num1, int num2, int count) {
        if (num1 == 0 || num2 == 0) {
            return count;
        }
        if (num1 >= num2) {
            count = countOpsRecursiveHelper(num1 - num2, num2, count);
        } else {
            count = countOpsRecursiveHelper(num1, num2 - num1, count);
        }
        count++;
        return count;
    }

    public static void main(String[] args) {
        CountOperationsToObtainZero obj = new CountOperationsToObtainZero();
        int num1 = 2;
        int num2 = 3;
        System.out.println(obj.countOperations(num1, num2));
    }
}

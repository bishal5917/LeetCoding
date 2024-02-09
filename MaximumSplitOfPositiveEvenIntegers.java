import java.util.ArrayList;
import java.util.List;

public class MaximumSplitOfPositiveEvenIntegers {

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> sums = new ArrayList<>();
        if (finalSum == 2) {
            sums.add(finalSum);
            return sums;
        }
        return findSplittedIntegersRecursiveHelper(finalSum, sums, new ArrayList<>(), 0, 2);
    }

    private List<Long> findSplittedIntegersRecursiveHelper(long num, List<Long> curr, List<Long> maxOne, long currSum,
            long start) {
        if (currSum == num) {
            System.out.println(new ArrayList<>(curr));
            if (curr.size() > maxOne.size()) {
                maxOne = new ArrayList<>(curr);
            }
            return maxOne;
        }
        for (long i = start; i < num; i = i + 2) {
            curr.add(i);
            currSum += i;
            maxOne = findSplittedIntegersRecursiveHelper(num, curr, maxOne, currSum, i + 2);
            curr.remove(curr.size() - 1);
            currSum -= i;
        }
        return maxOne;
    }

    public static void main(String[] args) {
        long number = 28;
        MaximumSplitOfPositiveEvenIntegers obj = new MaximumSplitOfPositiveEvenIntegers();
        List<Long> ans = obj.maximumEvenSplit(number);
        System.out.println(ans);
    }
}

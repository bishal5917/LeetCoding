public class MinIncrementsToFormTargetArray {

    public int minNumberOperations(int[] target) {
        int can_reuse = target[0];
        int ops = target[0];
        for (int i = 1; i < target.length; i++) {
            // if (target[i] <= can_reuse) {
            // can_reuse = target[i];
            // } else {
            // ops += target[i] - can_reuse;
            // can_reuse = target[i];
            // }
            if (target[i] > can_reuse) {
                ops += target[i] - can_reuse;
            }
            can_reuse = target[i];
        }
        return ops;
    }

    public static void main(String[] args) {
        MinIncrementsToFormTargetArray obj = new MinIncrementsToFormTargetArray();
        int[] target = { 1, 2, 3, 2, 1 };
        System.out.println(obj.minNumberOperations(target));
    }
}

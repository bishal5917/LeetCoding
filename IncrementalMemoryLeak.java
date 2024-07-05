import java.util.Arrays;

public class IncrementalMemoryLeak {

    public int[] memLeak(int memory1, int memory2) {
        // Now lets check,till we crash
        int idx = 1;
        while (true) {
            if (memory1 >= memory2 && idx <= memory1) {
                memory1 -= idx;
            } else if (memory2 > memory1 && idx <= memory2) {
                memory2 -= idx;
            } else {
                break;
            }
            idx++;
        }
        return new int[] { idx, memory1, memory2 };
    }

    public static void main(String[] args) {
        IncrementalMemoryLeak obj = new IncrementalMemoryLeak();
        int memory1 = 8;
        int memory2 = 11;
        int[] ans = obj.memLeak(memory1, memory2);
        System.out.println(Arrays.toString(ans));
    }
}

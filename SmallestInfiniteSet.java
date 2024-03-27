import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SmallestInfiniteSet {

    private List<Integer> elements;
    private Set<Integer> set;

    public SmallestInfiniteSet() {
        this.elements = new ArrayList<>();
        this.set = new HashSet<>();
        // Add numbers from 1 to 1000
        for (int i = 1; i <= 1000; i++) {
            elements.add(i);
            set.add(i);
        }
    }

    public int popSmallest() {
        if (elements.size() == 0) {
            return -1;
        }
        // swap the root with the last element
        swap(0, elements.size() - 1);
        // remove the last element and return
        int val = elements.remove(elements.size() - 1);
        set.remove(val);
        // perform heapify operation
        heapify();
        return val;
    }

    public void addBack(int num) {
        if (set.contains(num)) {
            return;
        }
        elements.add(num);
        set.add(num);
        // perform heapify operation
        heapify();
    }

    // HELPER FUNCTIONS FOR MIN-HEAP
    private void heapify() {
        // we dont care about the leaves,they will just get into their position by
        // themselves
        int startIdx = elements.size() / 2 - 1;
        // from this index to 0
        for (int i = startIdx; i >= 0; i--) {
            // get the right child and the left child
            int leftChildIdx = (i * 2) + 1;
            int rightChildIdx = (i * 2) + 2;
            int idxToSwapWithParent = 0;
            if (leftChildIdx >= elements.size() && rightChildIdx >= elements.size()) {
                // if there are no childs just continue for the next parent
                continue;
            }
            // swap the smallest child with the parent
            if (rightChildIdx >= elements.size()) {
                idxToSwapWithParent = leftChildIdx;
            } else if (leftChildIdx < elements.size() && rightChildIdx < elements.size()) {
                if (elements.get(leftChildIdx) < elements.get(rightChildIdx)) {
                    idxToSwapWithParent = leftChildIdx;
                } else {
                    idxToSwapWithParent = rightChildIdx;
                }
            }
            // Now we found out the idx to swap with parent
            // Now just swap and go for next iteration of the loop
            // swap if the parent is less than the child
            if (elements.get(idxToSwapWithParent) < elements.get(i)) {
                swap(i, idxToSwapWithParent);
            }
        }
    }

    private void swap(int a, int b) {
        int temp = elements.get(a);
        elements.set(a, elements.get(b));
        elements.set(b, temp);
    }

    public static void main(String[] args) {
        SmallestInfiniteSet obj = new SmallestInfiniteSet();
        obj.addBack(2);
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
    }
}

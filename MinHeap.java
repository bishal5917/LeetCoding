import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    private List<Integer> elements;

    public List<Integer> getElements() {
        return elements;
    }

    MinHeap() {
        this.elements = new ArrayList<>();
    }

    public long size() {
        return elements.size();
    }

    public void insert(int val) {
        elements.add(val);
        // perform heapify operation
        heapify();
    }

    public int poll() {
        // swap the root with the last element
        swap(0, elements.size() - 1);
        // remove the last element and return
        int val = elements.remove(elements.size() - 1);
        // perform heapify operation
        heapify();
        return val;
    }

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
        MinHeap heap = new MinHeap();
        heap.insert(10);
        heap.insert(7);
        heap.insert(11);
        heap.insert(5);
        heap.insert(4);
        System.out.println(heap.getElements());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
    }
}

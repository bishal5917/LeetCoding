class MinHeap:
    def __init__(self, arr):
        self.heap = self.buildHeap(arr)

    def peek(self):
        return self.heap[0]

    def insert(self, value):
        self.heap.append(value)
        lastIdx = len(self.heap) - 1
        parentIdx = (lastIdx - 1) // 2
        while True:
            if self.heap[parentIdx] > value:
                self.swap(parentIdx, lastIdx, self.heap)
            lastIdx = parentIdx
            parentIdx = (parentIdx - 1) // 2
            if not parentIdx:
                return self.heap

    def remove(self):
        pass

    def buildHeap(self, arr):
        return arr

    def siftDown(self, currIdx, endIdx, heap):
        pass

    def siftUp(self, currIdx, heap):
        pass

    def swap(self, i, j, heap):
        heap[i], heap[j] = heap[j], heap[i]


if __name__ == "__main__":
    arr = [8, 12, 23, 17, 31, 30, 44, 102, 18]
    x = MinHeap(arr)
    print(x.peek())
    print(x.insert(9))
    print(x.remove())

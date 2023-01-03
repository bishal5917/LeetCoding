class MinHeap:
    def __init__(self, arr):
        self.heap = self.buildHeap(arr)

    def peek(self):
        return self.heap[0]

    def insert(self, value):
        self.heap.append(value)
        return self.siftUp(len(self.heap) - 1, self.heap)

    def remove(self):
        self.swap(0, len(self.heap) - 1, self.heap)
        toRemove = self.heap.pop()
        return toRemove, self.siftDown(0, len(self.heap) - 1, self.heap)

    def buildHeap(self, arr):
        firstParentIdx = (len(arr) - 1) // 2
        for idx in reversed(range(firstParentIdx)):
            self.siftDown(idx, len(arr) - 1, arr)
        return arr

    def siftDown(self, currIdx, endIdx, heap):
        leftChild = 2 * currIdx + 1
        while leftChild <= endIdx:
            rightChild = 2 * currIdx + 2 if 2 * currIdx + 2 <= endIdx else -1
            # getting minimum of the two childs
            if heap[leftChild] < heap[rightChild] and rightChild != -1:
                minIdx = leftChild
            else:
                minIdx = rightChild
            if heap[currIdx] > heap[minIdx]:
                self.swap(currIdx, minIdx, heap)
                currIdx = minIdx
                leftChild = 2 * currIdx + 1
            else:
                break
        return heap

    def siftUp(self, currIdx, heap):
        parentIdx = (currIdx - 1) // 2
        while True:
            value = heap[currIdx]
            if self.heap[parentIdx] > value:
                self.swap(parentIdx, currIdx, heap)
            currIdx = parentIdx
            parentIdx = (currIdx - 1) // 2
            if not parentIdx:
                return heap

    def swap(self, i, j, heap):
        heap[i], heap[j] = heap[j], heap[i]


if __name__ == "__main__":
    arr = [8, 12, 23, 17, 31, 30, 44, 102, 18]
    x = MinHeap(arr)
    print(x.peek())
    print(x.insert(9))
    print(x.remove())

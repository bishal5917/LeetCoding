class MinHeap:
    def __init__(self, arr):
        self.heap = self.buildHeap(self, arr)

    def peek(self):
        return self.heap[0]

    def insert(self, value):
        pass

    def remove(self):
        pass

    def buildHeap(self, arr):
        pass

    def siftDown(self, currIdx, endIdx, heap):
        pass

    def siftUp(self, currIdx, heap):
        pass

    def swap(self, i, j, heap):
        heap[i], heap[j] = heap[j], heap[i]

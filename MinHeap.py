class MinHeap:
    def __init__(self, array):
        self.heap = self.buildHeap(array)

    def buildHeap(self, array):
        firstParentIndexFromBottom = (len(array)-2)//2
        # we go from first parent from last to all the way up sifting down 
        # in the process
        for currIndexItem in reversed(range(firstParentIndexFromBottom)):
            self.siftdown(currIndexItem, len(array)-1, array)
        return array

    def peek(self):
        return self.heap[0]

    def siftup(self, currIndex, heap):
        parentIndex = (currIndex-1)//2  # // gives the floor value
        while currIndex > 0 and heap[currIndex] < heap[parentIndex]:
            self.swap(currIndex, parentIndex, heap)
            # after swapping the parentIndex is updated
            currIndex = parentIndex
            parentIndex = (currIndex-1)//2

    def siftdown(self, currIndex, endIndex, heap):
        childOne = 2*currIndex+1
        while childOne <= endIndex:
            childTwo = 2*currIndex+2 if 2*currIndex+2 <= endIndex else -1
            if childTwo != -1 and heap[childTwo] < heap[childOne]:
                indextoswap = childTwo
            else:
                indextoswap = childOne
            if heap[currIndex] > heap[indextoswap]:
                self.Swap(currIndex, indextoswap, heap)
                currIndex = indextoswap
                childOne = 2*currIndex+1
            else:
                break

    def Swap(self, i, j, heap):
        heap[i], heap[j] = heap[j], heap[i]

    def remove(self):
        self.Swap(0, len(self.heap)-1, self.heap)
        removed = self.heap.pop()
        self.siftdown(0, len(self.heap)-1, self.heap)
        return removed

    def insert(self, value):
        self.append.value()
        self.siftup(len(self.heap)-1, self.heap)

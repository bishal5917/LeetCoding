def QuickSelect(array, startIdx, endIdx, position):
    while True:
        pivotIdx = startIdx
        leftIdx = startIdx + 1
        rightIdx = endIdx
        while leftIdx <= rightIdx:
            if array[leftIdx] > array[pivotIdx] and array[rightIdx] < array[pivotIdx]:
                arr[leftIdx], arr[rightIdx] = arr[rightIdx], arr[leftIdx]
            if array[leftIdx] <= array[pivotIdx]:
                leftIdx += 1
            if array[rightIdx] >= array[pivotIdx]:
                rightIdx -= 1
        arr[pivotIdx], arr[rightIdx] = arr[rightIdx], arr[pivotIdx]
        if rightIdx == position:
            return array[rightIdx]
        elif rightIdx < position:
            startIdx = rightIdx + 1
        else:
            endIdx = rightIdx - 1


if __name__ == "__main__":
    arr = [8, 5, 2, 9, 7, 6, 3]
    k = 3
    position = k - 1
    print(QuickSelect(arr, 0, len(arr) - 1, position))

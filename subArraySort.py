#find the subarray such that "if it us sorted , the whole given list will be sorted"
#Time complexity=O(n) -- because there are no nested for loops
#space complexity=O(1)

def subArraySort(arr):
    firstUnsortedIndex = 0
    secondUnsortedIndex = 0
    for i in range(1, len(arr)):
        if arr[i] > arr[i + 1] or arr[i] < arr[i - 1]:
            firstUnsortedIndex = i
            break
    for i in range(1, len(arr) - 1):
        if arr[i] > arr[i + 1] or arr[i] < arr[i - 1]:
            secondUnsortedIndex = i


    maxone = 0
    minone = float("inf")
    for i in range(firstUnsortedIndex, secondUnsortedIndex + 1):
        maxone = max(maxone, arr[i])
        minone = min(minone, arr[i])


    leftSubArrayIndex = 0
    rightSubArrayIndex = 0
    for x in range(0, firstUnsortedIndex):
        if arr[x] > minone:
            leftSubArrayIndex = x
            break
    for y in reversed(range(len(arr))):
        if arr[y] < maxone:
            rightSubArrayIndex = y
            break

    return [leftSubArrayIndex, rightSubArrayIndex]


if __name__ == "__main__":
    arr = [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]
    print(subArraySort(arr))

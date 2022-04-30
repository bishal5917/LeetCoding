def MaxSumSubsequence(arr):
    sums = [0 for i in range(len(arr))]
    sequence = [None for i in range(len(arr))]
    sums[0] = arr[0]

    for i in range(1, len(arr)):
        for j in range(0, i):
            if arr[j] < arr[i]:
                sums[i] = max(sums[i], sums[j]+arr[i])
                sequence[i] = j
                # we are storing the previous index only
            else:
                sums[i] = arr[i]

    # getting the max sum Idx
    currentMaxIdx = 0
    for i in range(0, len(sums)):
        if sums[i] > sums[currentMaxIdx]:
            currentMaxIdx = i

    print(currentMaxIdx)
    print(sums)
    print(sequence)


if __name__ == "__main__":
    arr = [8, 12, 2, 3, 15, 5, 7]
    MaxSumSubsequence(arr)

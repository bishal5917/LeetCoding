def MaxSumSubsequence(arr):
    sums = [nums for nums in arr]
    sequence = [None for x in arr]
    sums[0] = arr[0]

    for i in range(1, len(arr)):
        for j in range(0, i):
            if arr[j] < arr[i] and sums[j] + arr[i] >= sums[i]:
                sums[i] = max(sums[i], sums[j]+arr[i])
                sequence[i] = j
                # we are storing the previous index only

    # getting the max sum Idx
    currentMaxIdx = 0
    for i in range(0, len(sums)):
        if sums[i] > sums[currentMaxIdx]:
            currentMaxIdx = i

    return GiveThoseNums(sums, currentMaxIdx, sequence)


def GiveThoseNums(sums, idx, seq):
    sequences = []
    while idx is not None:
        sequences.append(idx)
        idx = seq[idx]
    return list(reversed(sequences))


if __name__ == "__main__":
    arr = [8, 12, 2, 3, 15, 5, 7]
    x = MaxSumSubsequence(arr)
    print("We had to add nums of these indices to get max subsequence : ", x)

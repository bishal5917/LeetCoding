def RadixSort(arr):
    totalDigits = 0
    maxDigit = max(arr)
    totalDigits = len(str(maxDigit))
    Pass = 1

    while Pass != totalDigits + 1:
        sorted = [0 for _ in arr]
        counts = [0 for _ in range(0, 10)]

        for i in range(0, len(arr)):
            leastSigDigit = (arr[i] // (pow(10, (Pass - 1)))) % 10
            counts[leastSigDigit] += 1
        for i in range(1, len(counts)):
            counts[i] = counts[i] + counts[i - 1]
        for i in reversed(range(len(arr))):
            leastSigDigit = (arr[i] // (pow(10, (Pass - 1)))) % 10
            counts[leastSigDigit] -= 1
            toPlaceThat = counts[leastSigDigit]
            sorted[toPlaceThat] = arr[i]
        arr = [item for item in sorted]
        Pass += 1

        print(f"Pass {Pass-1} : {sorted}")


if __name__ == "__main__":
    arr = [8762, 654, 3008, 345, 87, 65, 234, 12, 2]
    RadixSort(arr)

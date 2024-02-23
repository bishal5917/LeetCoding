def LargestNumber(nums):
    # sorting the digit by most significant digit using radix sort
    if len(nums) == 1:
        for item in nums:
            return str(item)

    totalDigits = 0
    maxDigit = max(nums)
    totalDigits = len(str(maxDigit))
    Pass = 1
    final = []

    while Pass != totalDigits:
        sorted = [0 for _ in nums]
        counts = [0 for _ in range(0, 10)]

        for i in range(0, len(nums)):
            leastSigDigit = (nums[i] // (pow(10, (Pass - 1)))) % 10
            counts[leastSigDigit] += 1
        for i in range(1, len(counts)):
            counts[i] = counts[i] + counts[i - 1]
        for i in reversed(range(len(nums))):
            leastSigDigit = (nums[i] // (pow(10, (Pass - 1)))) % 10
            counts[leastSigDigit] -= 1
            toPlaceThat = counts[leastSigDigit]
            sorted[toPlaceThat] = nums[i]
        nums = [item for item in sorted]
        Pass += 1
        sorted.reverse()

        final = sorted

    largest = ""
    for item in final:
        largest += str(item)
    return largest


if __name__ == "__main__":
    # nums = [3, 30, 34, 5, 9]
    nums = [1]
    print(LargestNumber(nums))

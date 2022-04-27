
def LargestRange(arr):
    longestLength = 0
    hash = {}
    for item in arr:
        hash[item] = True

    for num in arr:
        if hash[num] == False:
            continue
            # skipping that number which has already been false
        hash[num] = False
        left = num-1
        right = num+1
        currentLength = 1
        while left in hash:
            currentLength += 1
            hash[left] = False
            left = left-1
        while right in hash:
            currentLength += 1
            hash[right] = False
            right = right+1
        if currentLength > longestLength:
            longestLength = currentLength
            return left+1, right-1
            # left+1,right-1 because while loop exits by incrementing


if __name__ == "__main__":
    arr = [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]
    x = LargestRange(arr)
    print(x)

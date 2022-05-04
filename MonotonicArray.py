def MonotonicArray(arr):
    # An Array is a Monotonic Array if it is either strictly increasing or
    # strictly decreasing
    isInc = False
    isDec = False
    for i in range(1, len(arr)):
        if arr[i] <= arr[i-1]:
            isDec = True
        if arr[i] >= arr[i-1]:
            isInc = True

    if isInc == isDec:
        return False
    else:
        return True


if __name__ == "__main__":
    givenArray = [-1, -5, -10, -13, -1100, -1101, -1102, -9001]
    x = MonotonicArray(givenArray)
    print(x)

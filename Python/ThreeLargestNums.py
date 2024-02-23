def ThreeLargestNums(arr):
    fmax = 0
    smax = 0
    tmax = 0
    for item in arr:
        if item > tmax:
            fmax = smax
            smax = tmax
            tmax = item
        if item > smax and item < tmax:
            fmax = smax
            smax = item
        if item > fmax and item < smax:
            fmax = item

    return fmax, smax, tmax


if __name__ == "__main__":
    arr = [141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7]
    x = ThreeLargestNums(arr)
    print(x)
